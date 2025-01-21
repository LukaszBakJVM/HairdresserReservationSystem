package org.example.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.client.dto.TypeOfVisitFromKafka;
import org.example.client.typeofvisit.TypeOfVisitServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaServices {
    private final Logger logger = LoggerFactory.getLogger(KafkaServices.class);
    private final TypeOfVisitServices services;

    public KafkaServices(TypeOfVisitServices services) {
        this.services = services;
    }


    @KafkaListener(topics = "typOfVisit", groupId = "your-consumer-group")
    private void listenTeacherTopic(ConsumerRecord<String, String> record) {
        String topicKey = "create";
        String key = record.key();
        if (key.equals(topicKey)) {
            logger.info("Received Person: {}", record.value());
            TypeOfVisitFromKafka deserialization = deserialization(record.value());
            services.addNewTypOfVisit(deserialization);

        } else {
            logger.info("my key  {} , received key {}", topicKey, key);
        }

    }

    private TypeOfVisitFromKafka deserialization(String json) {

        ObjectMapper obj = new ObjectMapper();
        try {

            return obj.readValue(json, TypeOfVisitFromKafka.class);


        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);

        }

    }
}
