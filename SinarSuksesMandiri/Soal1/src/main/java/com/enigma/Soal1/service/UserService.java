package com.enigma.Soal1.service;

import com.enigma.Soal1.entity.User;
import com.enigma.Soal1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Operasi Create
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Operasi Read
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Metode pencarian berdasarkan username
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Metode pencarian berdasarkan email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Operasi Update (tidak disediakan dalam contoh ini)
    // Operasi Delete
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
