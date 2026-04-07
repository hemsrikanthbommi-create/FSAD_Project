package com.example.project.service;

import com.example.project.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public UserService() {
        users.add(new User(nextId.getAndIncrement(), "Alice", "alice@example.com"));
        users.add(new User(nextId.getAndIncrement(), "Bob", "bob@example.com"));
    }

    public List<User> getAllUsers() {
        return users.stream().collect(Collectors.toUnmodifiableList());
    }

    public Optional<User> getUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public User createUser(String name, String email) {
        User user = new User(nextId.getAndIncrement(), name, email);
        users.add(user);
        return user;
    }

    public Map<String, String> echo(String message) {
        return Map.of("echo", message != null ? message : "", "status", "ok");
    }
}
