package com.alibou.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //kafka dependency
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    public void sendMessage(String message) {
        log.info("send message: {}", message);
        kafkaTemplate.send("alibou", message);
    }
}

// zookeeper: sh bin/zookeeper-server-start.sh config/zookeeper.properties
// server: sh bin/kafka-server-start.sh config/server.properties
// bin/kafka-console-consumer.sh --topic alibou --from-beginning --bootstrap-server localhost:9092
// post http://localhost:8080/api/v1/messages send data