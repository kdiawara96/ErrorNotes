package com.YouKar.ml.ErrorNotes.Repository;

import com.YouKar.ml.ErrorNotes.Models.Personnes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Personnes_repo extends JpaRepository<Personnes, Long> {
   // Personnes AjouterPersonne(Personnes personnes);
    public Personnes findByEmail(String email);
}
