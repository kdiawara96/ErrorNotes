package com.YouKar.ml.ErrorNotes.Repository;

import com.YouKar.ml.ErrorNotes.Models.Personnes;
import com.YouKar.ml.ErrorNotes.Models.Problemes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Problemes_repo extends JpaRepository<Problemes, Long> {

    public Problemes findByIdp(Long idp);

    public Problemes findByTitrep(String titrep);

    public Problemes findByPersonnesp(Personnes personne);


    @Query(value = "SELECT * FROM problemes WHERE   ((problemes.titrep LIKE %:recherche%) OR (problemes.technologiep LIKE %:recherche%) OR (problemes.descriptionp LIKE %:recherche%))  ORDER BY idp DESC", nativeQuery = true)
    List<Object> recherche(@Param("recherche") String recherche);
}
