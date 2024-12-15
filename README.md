LINUX


```
docker network create kafka-network
```



```
docker run -itd \
  --name zookeeper \
  --network kafka-network \
  -e ZOOKEEPER_CLIENT_PORT=2181 \
  confluentinc/cp-zookeeper
```




```
HOST_IP=$(hostname -I | awk '{print $1}')
docker run -itd \
  --name kafka \
  --network kafka-network \
  -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 \
  -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://{HOST_IP}:9092 \
  -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
  -p 9092:9092 \
  confluentinc/cp-kafka
```




```
docker exec kafka kafka-topics --create \
  --topic user-create-topic \
  --bootstrap-server localhost:9092 \
  --partitions 1 \
  --replication-factor 1
```






[FILE CONFIG REDIS TẢI VỀ](assets/redis.conf)
```
docker run -d --name redis-stack -p 6379:6379 -p 8001:8001 -v <Nơi lưu file redis.conf>:/etc/redis/redis.conf redis/redis-stack:latest
```
