package com.formento.mongodb.repository;

import com.formento.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;

public interface UserRepository extends MongoRepository<User, String> {

//    User findByName(String name);
//
//    Iterable<User> findByLastName(String lastName);

    Iterable<User> findByName(String name);

    @Query("{ 'createdAt' : { $lte: ?0 } }")
    Iterable<User> listByBeforeCreatedAt(Date createdAt);

}
