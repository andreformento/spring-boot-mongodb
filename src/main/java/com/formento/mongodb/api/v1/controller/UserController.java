package com.formento.mongodb.api.v1.controller;

import com.formento.mongodb.model.User;
import com.formento.mongodb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("/v1/users")
@Api(value = "User API", description = "User API", basePath = "/v1/users", produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Create an user", notes = "Create and return an user", response = User.class)
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Resource<User>> create(@RequestBody User user) {
        User saved = userService.create(user);
        return new ResponseEntity<>(new Resource<>(saved, linkTo(UserController.class).slash(saved.getId()).withSelfRel()), HttpStatus.OK);
    }

    @ApiOperation(value = "List all users", notes = "List all users", response = User.class)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Resources<User>> listAll() {
        Iterable<User> users = userService.listAll();
        return new ResponseEntity<>(new Resources<>(users, linkTo(UserController.class).withSelfRel()), HttpStatus.OK);
    }

}
