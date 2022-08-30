package com.YouKar.ml.ErrorNotes.Models;

import com.YouKar.ml.ErrorNotes.Others.Etats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problemes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idp;

    @Column(name = "titrep",nullable = false, length = 50, unique = true)
    private String titrep;

    @Column(name = "descriptionp", nullable = false)
    private String descriptionp;

    @Column(name = "technologiep",nullable = false,length = 50)
    private String technologiep;

    @Column(name = "datep",nullable = false)
    private Date datep;


    @Enumerated(EnumType.ORDINAL)
    private Etats etats;

    @ManyToOne
    private Personnes personnesp;

    @OneToOne(mappedBy = "probleme")
    private Solutions solutions;

    //public Object map(Object object) {
      //  return null;
    //}



}
