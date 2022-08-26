package com.YouKar.ml.ErrorNotes.Models;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;


import lombok.*;

import javax.persistence.*;


@Data
@Entity

public class Solutions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_solutions ;

    @Column(name = "description_solution",length = 255, nullable = false)
    private String description_solution;

    @Column(name = "methode_recherche", nullable = true)
    private String methode_recherche;

    @Column(name = "ressource_solution",nullable = true)
    private String ressource_solution;

    @Column(name = "temps_consacrer", nullable = false)
    private String temps_consacrer;

}
