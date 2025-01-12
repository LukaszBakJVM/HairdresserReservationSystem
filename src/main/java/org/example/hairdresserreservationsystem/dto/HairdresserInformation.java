package org.example.hairdresserreservationsystem.dto;

import java.util.List;

public record HairdresserInformation(String firstName, String lastName, List<VisitDto> visits) {
}
