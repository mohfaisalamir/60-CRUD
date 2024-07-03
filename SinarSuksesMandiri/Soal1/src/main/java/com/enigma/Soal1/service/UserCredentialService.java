package com.enigma.Soal1.service;

import com.enigma.Soal1.entity.UserCredential;
import com.enigma.Soal1.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCredentialService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    // Operasi Create
    public UserCredential saveUserCredential(UserCredential userCredential) {
        return userCredentialRepository.save(userCredential);
    }

    // Operasi Read
    public Optional<UserCredential> getUserCredentialById(Integer id) {
        return userCredentialRepository.findById(id);
    }

    // Metode pencarian berdasarkan UUID
    public Optional<UserCredential> getUserCredentialByUuid(String uuid) {
        return userCredentialRepository.findByUuid(uuid);
    }

    // Metode pencarian berdasarkan ID user
    public Optional<UserCredential> getUserCredentialByUserId(Long userId) {
        return userCredentialRepository.findByUserId(userId);
    }

    // Operasi Delete
    public void deleteUserCredentialById(Integer id) {
        userCredentialRepository.deleteById(id);
    }

    // Anda dapat menambahkan metode lain sesuai kebutuhan aplikasi
}
