package com.enigma.Soal1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_credential")
public class UserCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_credential")
    private Integer idUserCredential;

    @Column(name = "uuid", nullable = false, unique = true, length = 36)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    // Constructors, getters, and setters

    public UserCredential(Integer idUserCredential, String uuid, User user) {
        this.idUserCredential = idUserCredential;
        this.uuid = uuid;
        this.user = user;
    }

    public UserCredential() {
    }

    public Integer getIdUserCredential() {
        return idUserCredential;
    }

    public void setIdUserCredential(Integer idUserCredential) {
        this.idUserCredential = idUserCredential;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
