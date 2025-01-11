package org.example.hairdresserreservationsystem.appconfig;

import org.example.hairdresserreservationsystem.HairdresserServices;
import org.example.hairdresserreservationsystem.dto.HairdresserLogin;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final HairdresserServices services;

    public CustomUserDetailsService(HairdresserServices services) {
        this.services = services;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return services.login(username).map(this::createUserDetails).orElseThrow(() -> new UsernameNotFoundException("aaaaaaaaa"));


    }

    private UserDetails createUserDetails(HairdresserLogin login) {
        return User.builder()
                .username(login.username())
                .password(login.password())
                .roles(login.role()).build();

    }
}
