package dev.gabrielsancho.bcard.dtos;

import dev.gabrielsancho.bcard.models.BusinessCard;

public class BusinessCardDTO {
    private String name;
    private String role;
    private String description;
    private String logoB64;

    BusinessCardDTO() {}

    BusinessCardDTO(BusinessCard businessCard) {
        name = businessCard.getName();
        role = businessCard.getRole();
        description = businessCard.getDescription();
        logoB64 = businessCard.getLogoB64();
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
