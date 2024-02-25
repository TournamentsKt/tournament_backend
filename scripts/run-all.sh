#!/bin/bash

BASE_DIR=$(dirname "$0")/..

docker network inspect tournaminz-network >/dev/null 2>&1 || \
  docker network create -d -f bridge tournaminz-network

bash "${BASE_DIR}"/scripts/db/run-db.sh
bash "${BASE_DIR}"/scripts/boot/run-boot.sh
