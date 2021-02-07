package dev.gabrielsancho.bcard.resources;

import dev.gabrielsancho.bcard.dtos.AuthUserDTO;
import dev.gabrielsancho.bcard.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthResource {

    final UserService service;

    public AuthResource(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody AuthUserDTO authUserDTO) {
        service.save(authUserDTO);
    }

//    @PostMapping("/login")
//    public User login(@RequestBody AuthUserDTO authUserDTO) {
//        return service.authenticate(authUserDTO);
//    }
}
