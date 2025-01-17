package org.example.hairdresserreservationsystem;

import org.example.hairdresserreservationsystem.dto.*;
import org.example.hairdresserreservationsystem.visit.Visit;
import org.example.hairdresserreservationsystem.visit.VisitRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

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

        return StreamSupport.stream(repository.findAll().spliterator(), false).map(mapper::information).toList();

    }

    BookingAppointment createAppointment(BookingAppointment booking) {

        Hairdresser hairdresser = repository.findByFirstNameAndLastName(booking.firstName(), booking.lastName()).orElseThrow();
        Visit appointment = mapper.createAppointment(hairdresser, booking);
        Visit save = visitRepository.save(appointment);
        return mapper.createAppointmentResponse(booking.firstName(), booking.lastName(), save);

    }

    List<MyVisits> findMyVisit() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return visitRepository.findVisitByHairdressersUsername(username).stream().map(mapper::myVisits).toList();
    }

}


