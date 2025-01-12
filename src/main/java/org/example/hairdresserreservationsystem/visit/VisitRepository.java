package org.example.hairdresserreservationsystem.visit;

import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
    Visit findByHairdressersId(long  id);
}
