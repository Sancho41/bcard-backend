package dev.gabrielsancho.bcard.models;

import dev.gabrielsancho.bcard.dtos.AuthUserDTO;
import dev.gabrielsancho.bcard.dtos.UserDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Document
public class User implements UserDetails {
    @Id
    private String id;

    @Indexed(unique = true)
    private String email;
    private String password;
    private BusinessCard businessCard;

    public User() {
    }

    public User(AuthUserDTO authUserDTO) {
        email = authUserDTO.getEmail();
        password = authUserDTO.getPassword();
        businessCard = new BusinessCard();
    }

    public User(UserDTO userDTO) {
        id = userDTO.getId();
        email = userDTO.getEmail();
        businessCard = new BusinessCard(userDTO.getBusinessCard());
    }

    public BusinessCard getBusinessCard() {
        return businessCard;
    }

    public void setBusinessCard(BusinessCard businessCard) {
        this.businessCard = businessCard;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
