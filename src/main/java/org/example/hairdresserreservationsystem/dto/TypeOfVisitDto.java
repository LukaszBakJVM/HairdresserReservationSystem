package org.example.hairdresserreservationsystem.dto;

import java.math.BigDecimal;

public record TypeOfVisitDto(String gender, String typeOfWork, long duration, BigDecimal price) {
}
