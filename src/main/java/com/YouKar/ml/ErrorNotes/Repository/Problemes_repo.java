package com.YouKar.ml.ErrorNotes.Repository;

import com.YouKar.ml.ErrorNotes.Models.Problemes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Problemes_repo extends JpaRepository<Problemes, Long> {

    public Problemes findByIdp(Long idp);

    public Problemes findByTitrep(String titrep);

}
