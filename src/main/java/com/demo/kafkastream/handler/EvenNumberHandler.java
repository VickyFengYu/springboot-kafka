package com.demo.kafkastream.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EvenNumberHandler {

  Log log = LogFactory.getLog(EvenNumberHandler.class);

  @Value("${kafka.topic.even-output}")
  private String evenOutput;

  public void process(KStream<String, Long> stream) {
    stream
        .filter((k, v) -> v % 2 == 0)
        .mapValues(
            v -> {
              log.info("Handle Even Sqrt(V)   => " + v);

              return v * v;
            })
        .to(evenOutput);
  }
}
