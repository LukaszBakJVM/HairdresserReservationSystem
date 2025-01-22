package org.example.client.typeofvisit;

import org.example.client.dto.TypeOfVisitFromKafka;
import org.example.client.typeofvisit.dto.TypeOfVisitDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class TypeOfVisitServices {
    private final TypeOfVisitRepository repository;

    public TypeOfVisitServices(TypeOfVisitRepository repository) {
        this.repository = repository;
    }

    List<TypeOfVisitDto> getAllTypeOfVisit() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).map(this::entityToDto).toList();


    }

    public void addNewTypOfVisit(TypeOfVisitFromKafka type) {
        TypeOfVisit kafka = kafka(type);
        repository.save(kafka);

    }


    TypeOfVisit kafka(TypeOfVisitFromKafka visit) {
        TypeOfVisit type = new TypeOfVisit();
        type.setGender(visit.gender());
        type.setTypeOfWork(visit.typeOfWork());
        type.setDuration(visit.duration());
        type.setPrice(visit.price());
        return type;
    }


    private TypeOfVisitDto entityToDto(TypeOfVisit type) {
        return new TypeOfVisitDto(type.getId(), type.getGender(), type.getTypeOfWork(), type.getDuration(), type.getPrice());
    }


}


