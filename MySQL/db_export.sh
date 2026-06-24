#!/bin/bash
# gms232 数据库一键导出脚本
# 用法: ./db_export.sh [输出文件名]

set -e

DB_NAME="gms232"
DB_USER="root"
DB_PASS="root"
DB_HOST="127.0.0.1"
DB_PORT="3306"
OUTPUT="${1:-backup_${DB_NAME}_$(date +%Y%m%d_%H%M%S).sql}"

echo "正在导出数据库 $DB_NAME 到 $OUTPUT ..."
mysqldump -h "$DB_HOST" -P "$DB_PORT" -u "$DB_USER" -p"$DB_PASS" \
    --routines \
    --triggers \
    --single-transaction \
    --quick \
    --lock-tables=false \
    "$DB_NAME" > "$OUTPUT"

echo "完成！导出文件: $OUTPUT"
echo "大小: $(du -h "$OUTPUT" | cut -f1)"
