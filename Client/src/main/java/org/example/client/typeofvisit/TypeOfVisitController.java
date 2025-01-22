package org.example.client.typeofvisit;

import org.example.client.typeofvisit.dto.TypeOfVisitDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/typeOfVisits")
public class TypeOfVisitController {
    private final TypeOfVisitServices services;

    public TypeOfVisitController(TypeOfVisitServices services) {
        this.services = services;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<TypeOfVisitDto> allTypeOfVisits() {
        return services.getAllTypeOfVisit();
    }


}
