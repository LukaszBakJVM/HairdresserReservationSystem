package org.example.client.enums;

public enum Gender {
    MALE("Male"),FEMALE("Female"),CHILD("Child");
    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
