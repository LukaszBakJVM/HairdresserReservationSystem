package org.example.hairdresserreservationsystem.dto;

import java.time.LocalDateTime;

public record BookingAppointment(String firstName, String lastName, String typeOfWork,String clientName, String clientGender,
                                 LocalDateTime start , long duration) {
}
