package org.example.client.appconfig;

import org.example.client.ClientServices;
import org.example.client.dto.ClientLogin;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final ClientServices services;

    public CustomUserDetailsService(ClientServices services) {
        this.services = services;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return services.login(username).map(this::createUserDetails).orElseThrow(() -> new UsernameNotFoundException("User not found"));


    }

    private UserDetails createUserDetails(ClientLogin login) {
        return User.builder()
                .username(login.username())
                .password(login.password())
                .roles(login.role()).build();

    }
}
