package dev.gabrielsancho.bcard.resources;

import dev.gabrielsancho.bcard.dtos.UserDTO;
import dev.gabrielsancho.bcard.models.User;
import dev.gabrielsancho.bcard.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserResource {
    final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @PutMapping("/user")
    public UserDTO update(@RequestBody UserDTO userDTO, Principal principal) {
        User user = service.loadUserByEmail(principal.getName());
        userDTO.setId(user.getId());
        if (userDTO.getEmail() == null)
            userDTO.setEmail(principal.getName());
        return new UserDTO(service.save(userDTO));
    }

    @DeleteMapping("/user")
    public void delete(Principal principal) {
        User user = service.loadUserByEmail(principal.getName());
        service.delete(user);
    }

    @GetMapping("/{id}")
    public UserDTO find(@PathVariable String id) {
        return new UserDTO(service.find(id));
    }
}
