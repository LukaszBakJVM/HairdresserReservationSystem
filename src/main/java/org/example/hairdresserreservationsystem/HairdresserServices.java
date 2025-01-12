package org.example.hairdresserreservationsystem;

import org.example.hairdresserreservationsystem.dto.HairdresserInformation;
import org.example.hairdresserreservationsystem.dto.HairdresserLogin;
import org.example.hairdresserreservationsystem.dto.HairdresserRegistration;
import org.example.hairdresserreservationsystem.dto.RegistrationResponse;
import org.example.hairdresserreservationsystem.visit.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HairdresserServices {
    private final HairdresserRepository repository;
    private final HairdresserMapper mapper;
    private final VisitRepository visitRepository;

    public HairdresserServices(HairdresserRepository repository, HairdresserMapper mapper, VisitRepository visitRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.visitRepository = visitRepository;
    }

    RegistrationResponse createNewPerson(HairdresserRegistration registrationDto) {
        Hairdresser registration = mapper.registration(registrationDto);
        Hairdresser save = repository.save(registration);
        return mapper.registrationResponse(save);
    }

    public Optional<HairdresserLogin> login(String name) {
        return repository.findByUsername(name).map(mapper::login);
    }

    public List<HairdresserInformation> getHairdresserInformation() {
        return repository.findAll().stream().map(mapper::information).toList();

    }

}


