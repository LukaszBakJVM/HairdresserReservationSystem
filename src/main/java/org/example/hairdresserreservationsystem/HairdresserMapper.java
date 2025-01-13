package org.example.hairdresserreservationsystem;

import org.example.hairdresserreservationsystem.dto.*;
import org.example.hairdresserreservationsystem.visit.Visit;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HairdresserMapper {
    private final PasswordEncoder passwordEncoder;

    public HairdresserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    Hairdresser registration(HairdresserRegistration dto) {
        String role = "hairdresser";
        Hairdresser hairdresser = new Hairdresser();
        hairdresser.setUsername(dto.username());
        hairdresser.setFirstName(dto.firstName());
        hairdresser.setLastName(dto.lastName());
        String password = passwordEncoder.encode(dto.password());
        hairdresser.setPassword(password);
        hairdresser.setRole(role);
        return hairdresser;
    }

    RegistrationResponse registrationResponse(Hairdresser hairdresser) {
        return new RegistrationResponse(hairdresser.getUsername(), hairdresser.getFirstName(), hairdresser.getLastName());
    }

    HairdresserLogin login(Hairdresser hairdresser) {
        return new HairdresserLogin(hairdresser.getFirstName(), hairdresser.getPassword(), hairdresser.getRole());
    }

    HairdresserInformation information(Hairdresser hairdresser) {
        List<VisitDto> visitsDto = hairdresser.getVisits().stream().map(this::visitDto).toList();
        return new HairdresserInformation(hairdresser.getFirstName(), hairdresser.getLastName(), visitsDto);
    }

    private VisitDto visitDto(Visit visit) {
        return new VisitDto(visit.getStart(), visit.getEnd());
    }
    Hairdresser createAppointment(BookingAppointment booking){
        Hairdresser hairdresser = new Hairdresser();
        Visit visit = new Visit();
        hairdresser.setFirstName(booking.firstName());
        hairdresser.setLastName(booking.lastName());
        visit.setTypeOfWork(booking.typeOfWork());
        visit.setClientName(booking.clientName());
        visit.setClientGender(booking.clientGender());
        LocalDateTime start = booking.start();
        visit.setStart(start);
        LocalDateTime end = start.plusMinutes(booking.duration());
        visit.setEnd(end);
        hairdresser.getVisits().add(visit);
        return hairdresser;
    }
    BookingAppointment createAppointmentResponse(Hairdresser hairdresser){
        Visit last = hairdresser.getVisits().getLast();
        long minutes = Duration.between(last.getStart(), last.getEnd()).toMinutes();
        return new BookingAppointment(hairdresser.getFirstName(), hairdresser.getLastName(), last.getTypeOfWork(),
                last.getClientName(), last.getClientGender(), last.getStart(),minutes);
    }


}
