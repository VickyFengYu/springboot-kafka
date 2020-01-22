Springboot Kafka
===================



## <i class="icon-folder-open"></i> Install Kafka

Just follow the official tutorial [Kafka Quickstart](https://kafka.apache.org/quickstart),
Take MAC as example, follow these simple steps: 

Download the 2.4.0 release and un-tar it.


```
tar -xzf kafka_2.12-2.4.0.tgz

cd kafka_2.12-2.4.0
```

### Start ZooKeeper 

```
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```

![enter image description here](https://github.com/VickyFengYu/springboot-kafka/blob/master/image/zookeeper-start.jpg?raw=true)


### Start Kafka

```
$ bin/kafka-server-start.sh config/server.properties
```

![enter image description here](https://github.com/VickyFengYu/springboot-kafka/blob/master/image/kafka-start.jpg?raw=true)


### Create Topic


```
$ bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
Created topic test.

$ bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 5 --topic partitioned
Created topic partitioned.

$ bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic filtered
Created topic filtered.

$ bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic greeting
Created topic greeting.

```


## <i class="icon-folder-open"></i> Run and Test


```
Received Messasge in group 'bar': Hello, World!
Received Messasge: Hello, World! from partition: 0
Received Messasge in group 'foo': Hello, World!
Sent message=[Hello, World!] with offset=[1]
Received Message: Hello To Partioned Topic! from partition: 0
Received Message: Hello To Partioned Topic! from partition: 3
Recieved Message in filtered listener: Hello Test!

```


