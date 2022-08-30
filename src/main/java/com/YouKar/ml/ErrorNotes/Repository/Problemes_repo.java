package com.YouKar.ml.ErrorNotes.Repository;

import com.YouKar.ml.ErrorNotes.Models.Personnes;
import com.YouKar.ml.ErrorNotes.Models.Problemes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Problemes_repo extends JpaRepository<Problemes, Long> {

    public Problemes findByIdp(Long idp);

    public Problemes findByTitrep(String titrep);

    public Problemes findByPersonnesp(Personnes personne);


    @Query(name = "SELECT * FROM problemes WHERE   problemes.titrep LIKE '%?%' OR problemes.technologiep LIKE '%?%' OR problemes.descriptionp LIKE '%?%' ORDER BY idp DESC", nativeQuery = true)
    List<Problemes> recherche(String recherche);
}
