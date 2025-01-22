package org.example.hairdresserreservationsystem;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServices {
    private final KafkaTemplate<String, Object> kafkaTemplate;


    public KafkaServices(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    void sendMessage(String topic, String key, Object body) {
        kafkaTemplate.send(topic, key, body);
    }

}
