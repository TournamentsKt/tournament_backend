#!/bin/bash

BASE_DIR=$(dirname "$0")/../..
BOOT_IMAGE_NAME=tournaminz-boot

gradle clean bootJar -p "${BASE_DIR}"

docker stop ${BOOT_IMAGE_NAME}
docker container rm ${BOOT_IMAGE_NAME}

docker build . -t ${BOOT_IMAGE_NAME} -f "${BASE_DIR}"/Dockerfile

docker run -d --name ${BOOT_IMAGE_NAME} \
  -p 8082:8080 \
  --network=tournaminz-network \
  -e SPRING_DATASOURCE_URL="jdbc:postgresql://tournaminz-db:5432/tournaminz" \
  -e SPRING_DATASOURCE_USERNAME="tournaminz" \
  -e SPRING_DATASOURCE_PASSWORD="minzpostgres" \
  ${BOOT_IMAGE_NAME}