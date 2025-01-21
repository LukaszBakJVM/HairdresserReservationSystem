package org.example.client.dto;

import java.math.BigDecimal;

public record TypeOfVisitFromKafka(String gender, String typeOfWork, long duration, BigDecimal price) {
}
