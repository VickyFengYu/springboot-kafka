package com.demo.kafkastream.consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaDoubleConsumer {

  Log log = LogFactory.getLog(KafkaDoubleConsumer.class);

  @KafkaListener(topics = "${kafka.topic.odd-output}")
  public void consume(Long number) {
    log.info(String.format("Consumer Double Odd => %d", number));
  }
}
