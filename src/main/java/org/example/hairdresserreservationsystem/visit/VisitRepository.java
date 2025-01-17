package org.example.hairdresserreservationsystem.visit;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VisitRepository extends CrudRepository<Visit,Long> {
    List<Visit>findVisitByHairdressersUsername(String username);
}
