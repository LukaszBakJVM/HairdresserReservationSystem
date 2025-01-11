package org.example.hairdresserreservationsystem;

import org.example.hairdresserreservationsystem.dto.HairdresserLogin;
import org.example.hairdresserreservationsystem.dto.HairdresserRegistration;
import org.example.hairdresserreservationsystem.dto.RegistrationResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HairdresserMapper {
  private final   PasswordEncoder passwordEncoder;

    public HairdresserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    Hairdresser registration(HairdresserRegistration dto){
        String role = "hairdresser";
       Hairdresser hairdresser = new Hairdresser();
       hairdresser.setName(dto.name());
        String password = passwordEncoder.encode(dto.password());
        hairdresser.setPassword(password);
       hairdresser.setRole(role);
       return hairdresser;
    }
    RegistrationResponse registrationResponse (Hairdresser hairdresser){
        return new RegistrationResponse(hairdresser.getName());
    }
    HairdresserLogin login(Hairdresser hairdresser){
        return new HairdresserLogin(hairdresser.getName(), hairdresser.getPassword(), hairdresser.getRole());    }

}
