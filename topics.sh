#!/bin/bash

docker run -it --rm \
    --network kafka_poc_app \
    -e KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper:2181 \
    bitnami/kafka:3 kafka-topics.sh --create --topic pkg_gen --partitions 2 \
    --bootstrap-server kafka:9092

docker run -it --rm \
    --network kafka_poc_app \
    -e KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper:2181 \
    bitnami/kafka:3 kafka-topics.sh --create --topic pkg_gen_priority --partitions 2 \
    --bootstrap-server kafka:9092 

docker run -it --rm \
    --network kafka_poc_app \
    -e KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper:2181 \
    bitnami/kafka:3 kafka-topics.sh --create --topic pkg_gen_simulation --partitions 1 \
    --bootstrap-server kafka:9092     

docker run -it --rm \
    --network kafka_poc_app \
    -e KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper:2181 \
    bitnami/kafka:3 kafka-topics.sh --list  --bootstrap-server kafka:9092

