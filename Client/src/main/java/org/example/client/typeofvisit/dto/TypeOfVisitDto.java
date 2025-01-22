package org.example.client.typeofvisit.dto;

import java.math.BigDecimal;

public record TypeOfVisitDto(int id,String gender, String typeOfWork, long duration, BigDecimal price) {
}
