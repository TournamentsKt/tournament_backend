#!/bin/bash

BASE_DIR=$(dirname "$0")/../..
SCRIPTS_DIR=${BASE_DIR}/scripts/db/sql

DB_IMAGE_NAME=tournaminz-db

docker stop ${DB_IMAGE_NAME}
docker container rm ${DB_IMAGE_NAME}

docker run -d --name ${DB_IMAGE_NAME} \
  -p 5432:5432 \
  --network=tournaminz-network \
  -v "${SCRIPTS_DIR}":/docker-entrypoint-initdb.d \
  -e POSTGRES_USER=tournaminz \
  -e POSTGRES_PASSWORD=minzpostgres \
  -e POSTGRES_DB=tournaminz \
  postgres
