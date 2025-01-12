package org.example.hairdresserreservationsystem;

import org.example.hairdresserreservationsystem.dto.*;
import org.example.hairdresserreservationsystem.visit.Visit;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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


}
