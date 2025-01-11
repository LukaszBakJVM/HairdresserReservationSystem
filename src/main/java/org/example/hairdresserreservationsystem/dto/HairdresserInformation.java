package org.example.hairdresserreservationsystem.dto;

import java.time.LocalDateTime;

public record HairdresserInformation(String firstName, String lastName, LocalDateTime start,LocalDateTime end) {
}
