package com.enigma.Soal1.repository;

import com.enigma.Soal1.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer> {

    // Metode pencarian berdasarkan UUID
    Optional<UserCredential> findByUuid(String uuid);

    // Metode pencarian berdasarkan ID user
    Optional<UserCredential> findByUserId(Long userId);

    // Metode pencarian berdasarkan UUID dan ID user
    Optional<UserCredential> findByUuidAndUserId(String uuid, Long userId);

    // Metode pencarian berdasarkan ID user (menggunakan query method)
    Optional<UserCredential> findByUser_Id(Long userId);

}
