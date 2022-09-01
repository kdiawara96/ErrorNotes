package com.YouKar.ml.ErrorNotes.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Commentaires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idc;

    @Column(name = "description_commentaire", nullable = false)
     private String description_commentaire;

    @Column(name = "datecommentaire")
    private Date datecommentaire;

    @Column(name = "aimer", nullable = true)
    private boolean aimer;

    @ManyToOne
    private Personnes personnes;

    @ManyToOne
    private Solutions solution;


}
