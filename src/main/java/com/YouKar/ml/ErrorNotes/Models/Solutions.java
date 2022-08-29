package com.YouKar.ml.ErrorNotes.Models;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


import lombok.*;

import javax.persistence.*;


@Data
@Entity

public class Solutions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ids ;

    @Column(name = "titre",length = 70, nullable = false, unique = true)
    private String titre;

    @Column(name = "description_solution",length = 255, nullable = false)
    private String description_solution;

    @Column(name = "methode_recherche",length = 70, nullable = true)
    private String methode_recherche;

    @Column(name = "ressource_solution",length = 50,nullable = true)
    private String ressource_solution;

    @Column(name="datesolution")
    private Date datesolution;

    @Column(name = "temps_consacrer", length = 20, nullable = false)
    private long temps_consacrer;

    @Column(name = "etoiles", length = 9)
    private int etoiles;

    @OneToOne
    private Problemes probleme;

    @OneToMany(mappedBy = "solution")
    private Collection<Commentaires> commentaire = new ArrayList<>();
}
