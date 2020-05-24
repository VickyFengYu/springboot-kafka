package com.demo.kafkastream;

import com.demo.kafkastream.handler.EvenNumberHandler;
import com.demo.kafkastream.handler.OddNumberHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@EnableKafkaStreams
public class KStreamConfig {

  Log log = LogFactory.getLog(KStreamConfig.class);

  @Value("${kafka.topic.input}")
  private String inputTopic;

  @Autowired
  private OddNumberHandler oddNumberHandler;

  @Autowired
  private EvenNumberHandler evenNumberHandler;

  @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
  public KafkaStreamsConfiguration kStreamsConfigs(KafkaProperties kafkaProperties) {
    Map<String, Object> config = new HashMap<>();
    config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
    config.put(StreamsConfig.APPLICATION_ID_CONFIG, kafkaProperties.getClientId());
    config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
    config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.Long().getClass());
    return new KafkaStreamsConfiguration(config);
  }

  @Bean
  public KStream<String, Long> kStream(StreamsBuilder kStreamBuilder) {
    log.info("inputTopic => " + inputTopic);
    KStream<String, Long> stream = kStreamBuilder.stream(inputTopic);
    this.oddNumberHandler.process(stream);
    this.evenNumberHandler.process(stream);

    return stream;
  }
}
