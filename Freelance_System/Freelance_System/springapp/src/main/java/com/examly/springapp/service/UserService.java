package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User addUser(User user) {
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long userId) {
        return repository.findById(userId).orElse(null);
    }

    public User updateUser(Long userId, User updatedUser) {
    return repository.findById(userId).map(existing -> {

        if (updatedUser.getUsername() != null)
            existing.setUsername(updatedUser.getUsername());

        if (updatedUser.getEmail() != null)
            existing.setEmail(updatedUser.getEmail());

        if (updatedUser.getPhoneNumber() != null)
            existing.setPhoneNumber(updatedUser.getPhoneNumber());

        if (updatedUser.getRole() != null)
            existing.setRole(updatedUser.getRole());

        return repository.save(existing);
    }).orElse(null);
}

}
