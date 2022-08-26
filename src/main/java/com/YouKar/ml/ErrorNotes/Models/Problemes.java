package com.YouKar.ml.ErrorNotes.Models;

import com.YouKar.ml.ErrorNotes.Others.Etats;
import lombok.Data;

import javax.persistence.*;
import java.security.PrivateKey;


@Entity
@Data
public class Problemes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_problemes;

    @Column(name = "titre",nullable = false, length = 50)
    private String titre_prolemes;

    @Column(name = "description", nullable = false)
    private String description_problemes;

    @Column(name = "technologie",nullable = false,length = 50)
    private String technologie;

    @Enumerated(EnumType.STRING)
    private Etats etats;

    @ManyToOne
    private Utilisateurs utilisateur;

    @OneToOne(mappedBy = "probleme")
    private Solutions solutions;



}
