package org.example.client;

import org.example.client.dto.ClientRegistrationRequest;
import org.example.client.dto.ClientRegistrationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientServices services;

    public ClientController(ClientServices services) {
        this.services = services;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ClientRegistrationResponse registration(@RequestBody ClientRegistrationRequest request){
        return services.createNewClient(request);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<String>gender(){
        return services.gender();
    }
}
