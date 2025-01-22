package org.example.hairdresserreservationsystem;

import org.example.hairdresserreservationsystem.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hairdresser")
public class HairdresserController {
    private final HairdresserServices services;


    public HairdresserController(HairdresserServices services) {
        this.services = services;

    }

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    RegistrationResponse createNewPerson(@RequestBody HairdresserRegistration registrationDto) {
        return services.createNewPerson(registrationDto);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    List<HairdresserInformation> findAll() {
        return services.getHairdresserInformation();
    }

    @GetMapping("/myAppoinment")
    @ResponseStatus(HttpStatus.OK)
    List<MyVisits> myVisits() {
        return services.findMyVisit();
    }

    @PostMapping("/typeOfVisit")
    @ResponseStatus(HttpStatus.CREATED)
    TypeOfVisitDto addTypeOfVisit(@RequestBody TypeOfVisitDto dto){
        return services.createTypeOfVisit(dto);
    }


}
