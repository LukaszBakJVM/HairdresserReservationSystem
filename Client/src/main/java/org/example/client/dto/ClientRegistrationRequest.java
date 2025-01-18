package org.example.client.dto;

public record ClientRegistrationRequest(String username, String firstName, String lastName, String password, String role,
                                        String telephoneNumber) {
}
