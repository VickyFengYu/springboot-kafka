package com.demo.kafkastream.processor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OddNumberProcessor {

  Log log = LogFactory.getLog(OddNumberProcessor.class);

  @Value("${kafka.topic.odd-output}")
  private String oddOutput;

  public void process(KStream<String, Long> stream) {
    stream
        .filter((k, v) -> v % 2 != 0)
        .mapValues(
            v -> {
              log.info("Handle Odd multiply(V,2) => " + v);
              return v * 2;
            })
        .to(oddOutput);
  }
}
