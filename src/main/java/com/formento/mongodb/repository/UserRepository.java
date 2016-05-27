package com.formento.mongodb.repository;

import com.formento.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

//    User findByName(String name);
//
//    Iterable<User> findByLastName(String lastName);

    Iterable<User> findByName(String name);

}
