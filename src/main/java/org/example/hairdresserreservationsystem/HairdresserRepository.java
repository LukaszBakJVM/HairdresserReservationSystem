package org.example.hairdresserreservationsystem;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HairdresserRepository extends CrudRepository<Hairdresser, Long> {
    Optional<Hairdresser> findByUsername(String name);

    Optional<Hairdresser> findByFirstNameAndLastName(String firstname, String lastname);


}
