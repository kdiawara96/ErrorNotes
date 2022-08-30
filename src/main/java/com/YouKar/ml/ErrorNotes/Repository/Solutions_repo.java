package com.YouKar.ml.ErrorNotes.Repository;

import com.YouKar.ml.ErrorNotes.Models.Personnes;
import com.YouKar.ml.ErrorNotes.Models.Problemes;
import com.YouKar.ml.ErrorNotes.Models.Solutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Solutions_repo extends JpaRepository<Solutions, Long> {

    Solutions findByTitre(String titre);
    Solutions findByProbleme(Problemes problemes);
    Solutions findByIds(Long ids);
}
