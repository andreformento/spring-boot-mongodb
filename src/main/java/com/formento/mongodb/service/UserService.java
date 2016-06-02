package com.formento.mongodb.service;

import com.formento.mongodb.model.User;

import java.time.LocalDateTime;

public interface UserService {

    User create(User user);

    Iterable<User> listAll();

    Iterable<User> listByBeforeCreatedAt(LocalDateTime createdAt);
}
