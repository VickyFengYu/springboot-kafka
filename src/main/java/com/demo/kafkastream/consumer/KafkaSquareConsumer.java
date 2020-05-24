package com.demo.kafkastream.consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaSquareConsumer {

  Log log = LogFactory.getLog(KafkaSquareConsumer.class);

  @KafkaListener(topics = "${kafka.topic.even-output}")
  public void consume(Long number) {
    log.info(String.format("Consumer Square =>  %d", number));
  }
}
