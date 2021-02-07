package dev.gabrielsancho.bcard.dtos;

import dev.gabrielsancho.bcard.models.User;

public class UserDTO {
    private String id;
    private String email;
    private BusinessCardDTO businessCard;

    public UserDTO() {}

    public UserDTO(User user) {
        id = user.getId();
        email = user.getEmail();
        businessCard = new BusinessCardDTO(user.getBusinessCard());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BusinessCardDTO getBusinessCard() {
        return businessCard;
    }

    public void setBusinessCard(BusinessCardDTO businessCard) {
        this.businessCard = businessCard;
    }
}
