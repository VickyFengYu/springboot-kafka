package com.demo.kafkastream.producer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KafkaNumberProducer {

  Log log = LogFactory.getLog(KafkaNumberProducer.class);

  private long counter = 0;

  @Autowired
  private KafkaTemplate<String, Long> kafkaTemplate;

  @Scheduled(fixedRate = 1000)
  public void produce() {
    log.info("Produced => " + counter);
    this.kafkaTemplate.sendDefault(counter++);
  }
}
