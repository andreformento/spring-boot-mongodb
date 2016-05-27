package com.formento.mongodb.service;

import com.formento.mongodb.model.User;

public interface UserService {

    User create(User user);

    Iterable<User> listAll();
}
