package dev.gabrielsancho.bcard.models;

import dev.gabrielsancho.bcard.dtos.BusinessCardDTO;

public class BusinessCard {
    private String name;
    private String role;
    private String description;
    private String logoB64;

    BusinessCard() {
        name = "";
        role = "";
        description = "";
        logoB64 = "";
    }

    public BusinessCard(BusinessCardDTO businessCardDTO) {
        name = businessCardDTO.getName();
        role = businessCardDTO.getRole();
        description = businessCardDTO.getDescription();
        logoB64 = businessCardDTO.getLogoB64();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoB64() {
        return logoB64;
    }

    public void setLogoB64(String logoB64) {
        this.logoB64 = logoB64;
    }
}
