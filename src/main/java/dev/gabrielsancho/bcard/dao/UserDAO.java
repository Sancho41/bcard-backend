package dev.gabrielsancho.bcard.dao;

import dev.gabrielsancho.bcard.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDAO extends MongoRepository<User, String> {

    @Query("{email : ?0}")
    public User findByEmail(String email);
}
