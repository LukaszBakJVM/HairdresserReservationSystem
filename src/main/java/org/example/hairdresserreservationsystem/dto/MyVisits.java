package org.example.hairdresserreservationsystem.dto;

import java.time.LocalDateTime;

public record MyVisits(LocalDateTime start ,LocalDateTime end,String typeOfWork,String clientName,String gender) {
}
