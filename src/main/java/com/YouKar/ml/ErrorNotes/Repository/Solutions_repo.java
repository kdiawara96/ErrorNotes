package com.YouKar.ml.ErrorNotes.Repository;

import com.YouKar.ml.ErrorNotes.Models.Personnes;
import com.YouKar.ml.ErrorNotes.Models.Problemes;
import com.YouKar.ml.ErrorNotes.Models.Solutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Solutions_repo extends JpaRepository<Solutions, Long> {

    Solutions findByTitre(String titres);
    Solutions findByIds(Long ids);
    Solutions findByProbleme(Problemes problemes);


    //@Query(value = "UPDATE solutions SET  etoiles=:etoiles  WHERE ids=:ids", nativeQuery = true)
    //Solutions addOrSousEtoile(int value,long ids);




}
