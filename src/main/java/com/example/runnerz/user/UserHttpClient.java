package com.example.runnerz.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface UserHttpClient {

    @GetExchange("/users")
    List<User> finaAll();

    @GetExchange("/users/{id}")
    User findById(@PathVariable Integer id);
}
