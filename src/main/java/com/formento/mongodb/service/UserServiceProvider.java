package com.formento.mongodb.service;

import com.formento.mongodb.model.User;
import com.formento.mongodb.repository.UserRepository;
import com.formento.mongodb.util.LocalDateTimeUtil;
import com.formento.mongodb.util.TimezoneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceProvider implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(new User
                .Builder(user)
                .withCreatedAt(LocalDateTime.now())
                .build()
        );
    }

    @Override
    public Iterable<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<User> listByBeforeCreatedAt(LocalDateTime createdAt) {
        return userRepository.listByBeforeCreatedAt(TimezoneUtil.changeTimezoneToUTC(LocalDateTimeUtil.toDate(createdAt)));
    }

}
