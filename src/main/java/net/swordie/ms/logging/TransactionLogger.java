package net.swordie.ms.logging;

import net.swordie.ms.client.character.Char;
import net.swordie.ms.client.character.items.Item;
import net.swordie.orm.dao.SworDaoFactory;
import net.swordie.orm.dao.TradeTransactionDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.swordie.ms.handlers.executors.EventManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TransactionLogger {

    private static final int MAX_QUEUE_SIZE = 500;
    private static final long FLUSH_INTERVAL_SECONDS = 30;

    private static final Logger log = LogManager.getLogger(TransactionLogger.class);
    private static final Lock lock = new ReentrantLock();
    private static final TradeTransactionDao tradeTransactionDao = (TradeTransactionDao) SworDaoFactory.getByClass(TradeTransaction.class);

    private static final List<TradeTransaction> transactionQueue = new ArrayList<>();
    private static boolean timerStarted = false;

    public static synchronized void startBackgroundFlush() {
        if (timerStarted) {
            return;
        }
        timerStarted = true;
        EventManager.addFixedRateEvent(
                TransactionLogger::flush, FLUSH_INTERVAL_SECONDS, FLUSH_INTERVAL_SECONDS, java.util.concurrent.TimeUnit.SECONDS);
    }


    public static void addTradeTransaction(UUID tradeUuid, Item item, Char from, Char to) {
        try {
            lock.lock();
            transactionQueue.add(TradeTransaction.fromTrade(tradeUuid, item, from, to));
        } finally {
            lock.unlock();
        }
        if (transactionQueue.size() >= MAX_QUEUE_SIZE) {
            new Thread(TransactionLogger::flush).start();
        }
    }

    public static void addTradeTransaction(UUID tradeUuid, long money, Char from, Char to) {
        if (money == 0) {
            return;
        }

        try {
            lock.lock();
            transactionQueue.add(TradeTransaction.fromTrade(tradeUuid, money, from, to));
        } finally {
            lock.unlock();
        }
        if (transactionQueue.size() >= MAX_QUEUE_SIZE) {
            new Thread(TransactionLogger::flush).start();
        }
    }

    public static void addDropTransaction(Item item, Char from, Char to) {
        try {
            lock.lock();
            transactionQueue.add(TradeTransaction.fromDrop(item, from, to));
        } finally {
            lock.unlock();
        }
        if (transactionQueue.size() >= MAX_QUEUE_SIZE) {
            new Thread(TransactionLogger::flush).start();
        }
    }

    public static void addDropTransaction(long money, Char from, Char to) {
        if (money == 0) {
            return;
        }

        try {
            lock.lock();
            transactionQueue.add(TradeTransaction.fromDrop(money, from, to));
        } finally {
            lock.unlock();
        }
        if (transactionQueue.size() >= MAX_QUEUE_SIZE) {
            new Thread(TransactionLogger::flush).start();
        }
    }

    private static void flush() {
        List<TradeTransaction> batch;
        try {
            lock.lock();
            if (transactionQueue.isEmpty()) {
                return;
            }
            batch = new ArrayList<>(transactionQueue);
            transactionQueue.clear();
        } finally {
            lock.unlock();
        }
        try {
            tradeTransactionDao.saveOrUpdate(batch);
        } catch (Exception e) {
            log.error("Failed to flush transaction batch", e);
        }
    }
}
