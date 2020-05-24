Springboot Kafka
===================



## <i class="icon-folder-open"></i> Install Kafka

Just follow the official tutorial [Kafka Quickstart](https://kafka.apache.org/quickstart),
Take MAC as example, follow these simple steps: 

Download the 2.4.0 release and un-tar it.


```
tar -xzf kafka_2.12-2.5.0.tgz

cd kafka_2.12-2.5.0
```


### Running a Multi-Broker Apache Kafka Cluster on a Single Node

### Configure and start Multiple Kafka Brokers on a Single Node

#### The first broker:
```
#broker-1
$ cp config/server.properties config/server1.properties
```

Edit config/server1.properties

```
broker.id=1
listeners=PLAINTEXT://:9091
log.dirs=/tmp/kafka-logs-1
```

#### The second broker:
```
#broker-2
$ cp config/server.properties config/server2.properties
```

Edit config/server2.properties

```
broker.id=2
listeners=PLAINTEXT://:9092
log.dirs=/tmp/kafka-logs-2
```

#### The third broker:
```
#broker-3
$ cp config/server.properties config/server3.properties
```
Edit config/server3.properties

```
broker.id=3
listeners=PLAINTEXT://:9093
log.dirs=/tmp/kafka-logs-3
```

### Start ZooKeeper 

```
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```

### Start Kafka
#### first broker 
```
$ env JMX_PORT=9999  bin/kafka-server-start.sh config/server1.properties
```
> [2020-05-24 11:08:42,885] INFO [GroupMetadataManager brokerId=1] Finished loading offsets and group metadata from __consumer_offsets-48 in 0 milliseconds. (kafka.coordinator.group.GroupMetadataManager)


#### second broker 
```
$ env JMX_PORT=10000  bin/kafka-server-start.sh config/server2.properties
```
> [2020-05-24 11:09:04,089] INFO [GroupMetadataManager brokerId=2] Finished loading offsets and group metadata from __consumer_offsets-19 in 0 milliseconds. (kafka.coordinator.group.GroupMetadataManager)


#### third broker 
```
$ env JMX_PORT=1001  bin/kafka-server-start.sh config/server3.properties
```
> [2020-05-24 11:08:52,408] INFO [GroupMetadataManager brokerId=3] Finished loading offsets and group metadata from __consumer_offsets-47 in 0 milliseconds. (kafka.coordinator.group.GroupMetadataManager)


### Create Topic Example
```
$ bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
```

## <i class="icon-folder-open"></i> Run Application

```
2020-05-24 12:38:34.519  INFO 14540 --- [   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 5
2020-05-24 12:38:34.524  INFO 14540 --- [-StreamThread-1] c.d.k.processor.OddNumberProcessor       : Handle Odd multiply(V,2) => 5
2020-05-24 12:38:34.637  INFO 14540 --- [ntainer#0-0-C-1] c.d.k.consumer.KafkaDoubleConsumer       : Consumer Double Odd => 10
2020-05-24 12:38:35.517  INFO 14540 --- [   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 6
2020-05-24 12:38:35.524  INFO 14540 --- [-StreamThread-1] c.d.k.processor.EvenNumberProcessor      : Handle Even Sqrt(V)   => 6
2020-05-24 12:38:35.633  INFO 14540 --- [ntainer#1-0-C-1] c.d.k.consumer.KafkaSquareConsumer       : Consumer Square =>  36
2020-05-24 12:38:36.517  INFO 14540 --- [   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 7
2020-05-24 12:38:36.524  INFO 14540 --- [-StreamThread-1] c.d.k.processor.OddNumberProcessor       : Handle Odd multiply(V,2) => 7
2020-05-24 12:38:36.635  INFO 14540 --- [ntainer#0-0-C-1] c.d.k.consumer.KafkaDoubleConsumer       : Consumer Double Odd => 14
2020-05-24 12:38:37.518  INFO 14540 --- [   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 8
2020-05-24 12:38:37.527  INFO 14540 --- [-StreamThread-1] c.d.k.processor.EvenNumberProcessor      : Handle Even Sqrt(V)   => 8
2020-05-24 12:38:37.638  INFO 14540 --- [ntainer#1-0-C-1] c.d.k.consumer.KafkaSquareConsumer       : Consumer Square =>  64
2020-05-24 12:38:38.518  INFO 14540 --- [   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 9
2020-05-24 12:38:38.524  INFO 14540 --- [-StreamThread-1] c.d.k.processor.OddNumberProcessor       : Handle Odd multiply(V,2) => 9
2020-05-24 12:38:38.635  INFO 14540 --- [ntainer#0-0-C-1] c.d.k.consumer.KafkaDoubleConsumer       : Consumer Double Odd => 18
2020-05-24 12:38:39.517  INFO 14540 --- [   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 10
2020-05-24 12:38:39.523  INFO 14540 --- [-StreamThread-1] c.d.k.processor.EvenNumberProcessor      : Handle Even Sqrt(V)   => 10
2020-05-24 12:38:39.636  INFO 14540 --- [ntainer#1-0-C-1] c.d.k.consumer.KafkaSquareConsumer       : Consumer Square =>  100
2020-05-24 12:38:40.518  INFO 14540 --- [   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 11
2020-05-24 12:38:40.524  INFO 14540 --- [-StreamThread-1] c.d.k.processor.OddNumberProcessor       : Handle Odd multiply(V,2) => 11
2020-05-24 12:38:40.637  INFO 14540 --- [ntainer#0-0-C-1] c.d.k.consumer.KafkaDoubleConsumer       : Consumer Double Odd => 22
2020-05-24 12:38:41.518  INFO 14540 --- [   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 12
2020-05-24 12:38:41.524  INFO 14540 --- [-StreamThread-1] c.d.k.processor.EvenNumberProcessor      : Handle Even Sqrt(V)   => 12
```


