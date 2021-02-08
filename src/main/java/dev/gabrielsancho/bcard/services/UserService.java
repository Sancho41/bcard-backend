package dev.gabrielsancho.bcard.services;

import dev.gabrielsancho.bcard.dao.UserDAO;
import dev.gabrielsancho.bcard.dtos.AuthUserDTO;
import dev.gabrielsancho.bcard.dtos.UserDTO;
import dev.gabrielsancho.bcard.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    final UserDAO dao;
    final PasswordEncoder passwordEncoder;

    public UserService(UserDAO dao, PasswordEncoder passwordEncoder) {
        this.dao = dao;
        this.passwordEncoder = passwordEncoder;
    }

    public User authenticate(AuthUserDTO authUserDTO) {
        return dao.findByEmail(authUserDTO.getEmail());
    }

    public void save(AuthUserDTO authUserDTO) {
        User user = new User(authUserDTO);
        user.setPassword(passwordEncoder.encode(authUserDTO.getPassword()));
        dao.save(user);
    }

    public User save(UserDTO userDTO) {
        User user = new User(userDTO);
        dao.save(user);
        return user;
    }

    public User loadUserByEmail(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return dao.findByEmail(email);
    }

    public void delete(User user) {
        dao.delete(user);
    }

    public User find(String id) {

        Optional<User> userOptional = dao.findById(id);
        if (userOptional.isPresent())
            return userOptional.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
