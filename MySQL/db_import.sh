#!/bin/bash
# gms232 数据库一键恢复脚本
# 用法: ./db_import.sh <备份文件>

set -e

if [ $# -lt 1 ]; then
    echo "用法: $0 <备份文件.sql>"
    exit 1
fi

INPUT="$1"
if [ ! -f "$INPUT" ]; then
    echo "错误: 文件 $INPUT 不存在"
    exit 1
fi

DB_NAME="gms232"
DB_USER="root"
DB_PASS="root"
DB_HOST="127.0.0.1"
DB_PORT="3306"

echo "正在从 $INPUT 恢复数据库 $DB_NAME ..."
echo "警告: 将覆盖现有数据！(5秒后继续)"
sleep 5

mysql -h "$DB_HOST" -P "$DB_PORT" -u "$DB_USER" -p"$DB_PASS" "$DB_NAME" < "$INPUT"

echo "完成！已从 $INPUT 恢复数据库 $DB_NAME"
