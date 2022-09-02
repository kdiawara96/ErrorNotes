package com.YouKar.ml.ErrorNotes.ServicesImpl;

import com.YouKar.ml.ErrorNotes.Models.Commentaires;
import com.YouKar.ml.ErrorNotes.Models.Personnes;
import com.YouKar.ml.ErrorNotes.Models.Solutions;
import com.YouKar.ml.ErrorNotes.Services.CommentaireService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentairesImplTest {

    @Autowired
    private CommentaireService service;

    @Test
    void deleteCommentaire() {
        Long id = 1L;
        String email = "youssoufdj123@gmail.com";
        String password = "Youskdjire";

        service.DeleteCommentaire(id,email,password);
    }

    @Test
    void create() {

        String commentaire = "voici le commentaire que j'ai inserer";
        String email = "youssoufdj123@gmail.com";
        String password = "Youskdjire";
        String titreSolution = "error Port";
        Boolean aimer = true;
        Long personnesId = 1L;
        Date date = new Date();


        Personnes per = new Personnes();
        per.setIdpersonnes(personnesId);

        Solutions sol = new Solutions();
        sol.setTitre(titreSolution);

        Commentaires com = new Commentaires();

        com.setDescription_commentaire(commentaire);
        com.setAimer(aimer);
        com.setPersonnes(per);
        com.setDatecommentaire(date);
        com.setSolution(sol);

        service.Create(com, email, titreSolution, password);
    }

    @Test
    void update() {

        Long idc = 3L;
        String email = "youssoufdj123@gmail.com";
        String password = "Youskdjire";
        String commentaire = "voici le commentaire que j'ai mis a jour";
        Boolean aimer = true;
        Long personnesId = 1L;
        Date date = new Date();

        Personnes per = new Personnes();
        per.setIdpersonnes(personnesId);

        Commentaires com = new Commentaires();

        com.setDescription_commentaire(commentaire);
        com.setAimer(aimer);
        com.setPersonnes(per);
        com.setDatecommentaire(date);



        service.Update(idc, com, email, password);
    }
}