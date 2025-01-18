package org.example.client;

import org.example.client.dto.ClientLogin;
import org.example.client.dto.ClientRegistrationRequest;
import org.example.client.dto.ClientRegistrationResponse;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {

    ClientEntity registrationRequest(ClientRegistrationRequest registration, String password) {
        ClientEntity client = new ClientEntity();
        client.setUsername(registration.username());
        client.setFirstName(registration.firstName());
        client.setLastName(registration.lastName());
        client.setPassword(password);
        String clientRole = "client";
        client.setRole(clientRole);
        client.setTelephoneNumber(registration.telephoneNumber());
        return client;
    }

    ClientRegistrationResponse registrationResponse(ClientEntity client) {
        return new ClientRegistrationResponse(client.getUsername(), client.getFirstName(), client.getLastName(), client.getTelephoneNumber());
    }

    ClientLogin login(ClientEntity client) {
        return new ClientLogin(client.getUsername(), client.getPassword(), client.getRole());
    }
}
