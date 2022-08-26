package com.YouKar.ml.ErrorNotes.Models;

import com.YouKar.ml.ErrorNotes.Others.Etats;
import com.YouKar.ml.ErrorNotes.Others.Roles;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Utilisateurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "nom", nullable = false, length = 25)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 25)
    private String prenom;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "contact", nullable = false, length = 20, unique = true)
    private String contact;

    @Column(name = "password", nullable = false, length = 10, unique = true)
    private String password;

    @Column(name = "role", nullable = false)
    private Roles role;



}
