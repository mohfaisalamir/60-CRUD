package com.enigma.Soal1.controller;

import com.enigma.Soal1.entity.UserCredential;
import com.enigma.Soal1.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user-credentials")
public class UserCredentialController {

    @Autowired
    private UserCredentialService userCredentialService;

    // Endpoint untuk Create
    @PostMapping
    public UserCredential createUserCredential(@RequestBody UserCredential userCredential) {
        return userCredentialService.saveUserCredential(userCredential);
    }

    // Endpoint untuk Read
    @GetMapping("/{id}")
    public Optional<UserCredential> getUserCredentialById(@PathVariable Integer id) {
        return userCredentialService.getUserCredentialById(id);
    }

    // Endpoint untuk pencarian berdasarkan UUID
    @GetMapping("/uuid/{uuid}")
    public Optional<UserCredential> getUserCredentialByUuid(@PathVariable String uuid) {
        return userCredentialService.getUserCredentialByUuid(uuid);
    }

    // Endpoint untuk pencarian berdasarkan ID user
    @GetMapping("/user/{userId}")
    public Optional<UserCredential> getUserCredentialByUserId(@PathVariable Long userId) {
        return userCredentialService.getUserCredentialByUserId(userId);
    }

    // Endpoint untuk Delete
    @DeleteMapping("/{id}")
    public void deleteUserCredentialById(@PathVariable Integer id) {
        userCredentialService.deleteUserCredentialById(id);
    }

}
