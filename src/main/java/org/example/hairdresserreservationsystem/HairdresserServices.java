package org.example.hairdresserreservationsystem;

import org.example.hairdresserreservationsystem.dto.HairdresserLogin;
import org.example.hairdresserreservationsystem.dto.HairdresserRegistration;
import org.example.hairdresserreservationsystem.dto.RegistrationResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HairdresserServices {
    private final HairdresserRepository repository;
    private final HairdresserMapper mapper;

    public HairdresserServices(HairdresserRepository repository, HairdresserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    RegistrationResponse createNewPerson(HairdresserRegistration registrationDto) {
        Hairdresser registration = mapper.registration(registrationDto);
        Hairdresser save = repository.save(registration);
        return mapper.registrationResponse(save);
    }

    public Optional<HairdresserLogin> login(String name) {
        return repository.findByName(name).map(mapper::login);
    }
}
