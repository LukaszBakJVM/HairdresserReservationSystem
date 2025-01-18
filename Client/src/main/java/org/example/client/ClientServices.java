package org.example.client;

import org.example.client.dto.ClientLogin;
import org.example.client.dto.ClientRegistrationRequest;
import org.example.client.dto.ClientRegistrationResponse;
import org.example.client.enums.Gender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServices {
    private final ClientRepository repository;
    private final ClientMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public ClientServices(ClientRepository repository, ClientMapper mapper, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    ClientRegistrationResponse createNewClient(ClientRegistrationRequest request) {
        String password = passwordEncoder.encode(request.password());
        ClientEntity client = mapper.registrationRequest(request, password);
        ClientEntity save = repository.save(client);
        return mapper.registrationResponse(save);
    }
    public Optional<ClientLogin> login(String username){
        return repository.findByUsername(username).map(mapper::login);
    }
    List<String>gender(){
        return Arrays.stream(Gender.values()).map(Gender::getGender).toList();
    }
}
