package org.example.hairdresserreservationsystem;

import org.example.hairdresserreservationsystem.dto.HairdresserInformation;
import org.example.hairdresserreservationsystem.dto.HairdresserLogin;
import org.example.hairdresserreservationsystem.dto.HairdresserRegistration;
import org.example.hairdresserreservationsystem.dto.RegistrationResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
    HairdresserInformation information(Hairdresser hairdresser, LocalDateTime start,LocalDateTime end){
        return new HairdresserInformation(hairdresser.getFirstName(), hairdresser.getLastName(), start,end);

    }

}
