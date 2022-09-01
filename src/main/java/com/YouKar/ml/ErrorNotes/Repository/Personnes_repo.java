package com.YouKar.ml.ErrorNotes.Repository;

import com.YouKar.ml.ErrorNotes.Models.Personnes;
import com.YouKar.ml.ErrorNotes.Models.Problemes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Personnes_repo extends JpaRepository<Personnes, Long> {
   // Personnes AjouterPersonne(Personnes personnes);
    public Personnes findByEmail(String email);
    public Personnes findByPassword(String password);
    //public Personnes findByIdpersonnes(Long id);

    Personnes findByEmailAndPassword(String email, String password);

}
