Springboot Kafka
===================

![enter image description here](https://github.com/VickyFengYu/springboot-kafka/blob/master/image/kafka.png?raw=true)

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
[   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 3
[-StreamThread-1] c.d.k.handler.OddNumberHandler           : Handle Odd multiply(V,2) => 3
[ntainer#0-0-C-1] c.d.k.consumer.KafkaDoubleConsumer       : Consumer Double Odd => 6
[   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 4
[-StreamThread-1] c.d.k.handler.EvenNumberHandler          : Handle Even Sqrt(V)   => 4
[ntainer#1-0-C-1] c.d.k.consumer.KafkaSquareConsumer       : Consumer Square =>  16
[   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 5
[-StreamThread-1] c.d.k.handler.OddNumberHandler           : Handle Odd multiply(V,2) => 5
[ntainer#0-0-C-1] c.d.k.consumer.KafkaDoubleConsumer       : Consumer Double Odd => 10
[   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 6
[-StreamThread-1] c.d.k.handler.EvenNumberHandler          : Handle Even Sqrt(V)   => 6
[ntainer#1-0-C-1] c.d.k.consumer.KafkaSquareConsumer       : Consumer Square =>  36
[   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 7
[-StreamThread-1] c.d.k.handler.OddNumberHandler           : Handle Odd multiply(V,2) => 7
[ntainer#0-0-C-1] c.d.k.consumer.KafkaDoubleConsumer       : Consumer Double Odd => 14
[   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 8
[-StreamThread-1] c.d.k.handler.EvenNumberHandler          : Handle Even Sqrt(V)   => 8
[ntainer#1-0-C-1] c.d.k.consumer.KafkaSquareConsumer       : Consumer Square =>  64
[   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 9
[-StreamThread-1] c.d.k.handler.OddNumberHandler           : Handle Odd multiply(V,2) => 9
[ntainer#0-0-C-1] c.d.k.consumer.KafkaDoubleConsumer       : Consumer Double Odd => 18
[   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 10
[-StreamThread-1] c.d.k.handler.EvenNumberHandler          : Handle Even Sqrt(V)   => 10
[ntainer#1-0-C-1] c.d.k.consumer.KafkaSquareConsumer       : Consumer Square =>  100
[   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 11
[-StreamThread-1] c.d.k.handler.OddNumberHandler           : Handle Odd multiply(V,2) => 11
[ntainer#0-0-C-1] c.d.k.consumer.KafkaDoubleConsumer       : Consumer Double Odd => 22
[   scheduling-1] c.d.k.producer.KafkaNumberProducer       : Produced => 12
[-StreamThread-1] c.d.k.handler.EvenNumberHandler          : Handle Even Sqrt(V)   => 12
[ntainer#1-0-C-1] c.d.k.consumer.KafkaSquareConsumer       : Consumer Square =>  144
```

### <i class="icon-folder-open"></i> Reference

[http://kafka.apache.org/quickstart#quickstart_multibroker](http://kafka.apache.org/quickstart#quickstart_multibroker)

[https://blog.parse.ly/post/3886/pykafka-now/](https://blog.parse.ly/post/3886/pykafka-now/r)



