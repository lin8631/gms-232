#!/bin/bash
# MapleStory gms-232 服务端启动脚本
# 用法: ./start.sh         前台运行（默认）
#       ./start.sh -b      后台运行
#       ./start.sh --bg    后台运行

APP_DIR="$(cd "$(dirname "$0")" && pwd)"
JAR="$APP_DIR/bin/maplestory-1.77.3.jar"
LOG="$APP_DIR/server.log"
PID_FILE="$APP_DIR/server.pid"

cd "$APP_DIR"

# 从 .env 文件加载数据库配置（如果存在）
if [ -f "$APP_DIR/.env" ]; then
    set -a
    . "$APP_DIR/.env"
    set +a
fi

if [ ! -f "$JAR" ]; then
    echo "错误: 未找到 $JAR"
    echo "请先执行: mvn clean package -DskipTests"
    exit 1
fi

if [ -f "$PID_FILE" ]; then
    OLD_PID=$(cat "$PID_FILE")
    if kill -0 "$OLD_PID" 2>/dev/null; then
        echo "服务端已在运行 (PID: $OLD_PID)"
        echo "实时日志（按 Ctrl+C 停止跟踪，进程继续运行）："
        tail -f "$LOG"
        exit 0
    fi
fi

BG_MODE=false
if [ "$1" = "-b" ] || [ "$1" = "--bg" ]; then
    BG_MODE=true
fi

if [ "$BG_MODE" = true ]; then
    # 清空旧日志
    > "$LOG"
    echo "正在后台启动服务端..."
    nohup java -Xmx4g -jar "$JAR" > "$LOG" 2>&1 &
    PID=$!
    echo "$PID" > "$PID_FILE"

    # 实时输出日志，直到启动完成
    echo ""
    echo "===== 启动日志（等待启动完成）====="
    tail -f "$LOG" &
    TAIL_PID=$!

    # 等待 "Finished loading server" 或超时 120 秒
    while true; do
        if grep -q "Finished loading server" "$LOG" 2>/dev/null; then
            sleep 2
            break
        fi
        sleep 1
    done

    # 停止 tail -f
    kill "$TAIL_PID" 2>/dev/null
    wait "$TAIL_PID" 2>/dev/null

    echo ""
    echo "===== 启动完成 ====="
    echo "服务端已启动 (PID: $PID)"
    echo "日志文件: $LOG"
    echo "停止命令: kill \$(cat $PID_FILE)"
    echo "实时查看日志: tail -f $LOG"
else
    echo "正在前台启动服务端（按 Ctrl+C 停止）..."
    echo $$ > "$PID_FILE"
    exec java -Xmx4g -jar "$JAR"
fi
