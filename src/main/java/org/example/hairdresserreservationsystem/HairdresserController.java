package org.example.hairdresserreservationsystem;

import org.example.hairdresserreservationsystem.dto.HairdresserRegistration;
import org.example.hairdresserreservationsystem.dto.RegistrationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


}
