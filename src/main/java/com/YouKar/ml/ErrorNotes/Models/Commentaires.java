package com.YouKar.ml.ErrorNotes.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
public class Commentaires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_commentaire;

    @Column(name = "date_commentaire")
    private Date date_commentaire;
}
