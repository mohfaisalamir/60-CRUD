package com.enigma.Soal1.repository;

import com.enigma.Soal1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Metode pencarian berdasarkan username
    Optional<User> findByUsername(String username);

    // Metode pencarian berdasarkan email
    Optional<User> findByEmail(String email);

    // Metode pencarian berdasarkan username dan password
    Optional<User> findByUsernameAndPassword(String username, String password);

}
