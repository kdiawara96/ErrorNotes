package com.YouKar.ml.ErrorNotes.Models;


import com.YouKar.ml.ErrorNotes.Others.Etats;
import com.YouKar.ml.ErrorNotes.Others.Roles;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_utilisateur", discriminatorType = DiscriminatorType.STRING)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Admins.class, name = "Admins"),
        @JsonSubTypes.Type(value = Users.class, name = "Users")
})

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

    @Enumerated(EnumType.STRING)
    private Roles role;


    @OneToMany(mappedBy = "utilisateur")
    private Collection<Problemes> probleme = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur")
    private Collection<Commentaires> commentaire = new ArrayList<>();


}
