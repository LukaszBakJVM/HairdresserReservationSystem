package org.example.client;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<ClientEntity,Long> {
    Optional<ClientEntity>findByUsername(String username);
}
