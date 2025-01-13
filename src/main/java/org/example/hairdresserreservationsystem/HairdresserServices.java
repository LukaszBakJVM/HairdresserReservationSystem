package org.example.hairdresserreservationsystem;

import org.example.hairdresserreservationsystem.dto.*;
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
    BookingAppointment createAppointment(BookingAppointment booking){
        Hairdresser appointment = mapper.createAppointment(booking);
        Hairdresser save = repository.save(appointment);
        return mapper.createAppointmentResponse(save);

    }

}


