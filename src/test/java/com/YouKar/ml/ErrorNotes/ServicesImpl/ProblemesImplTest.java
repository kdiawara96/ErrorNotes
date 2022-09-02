package com.YouKar.ml.ErrorNotes.ServicesImpl;

import com.YouKar.ml.ErrorNotes.Models.Personnes;
import com.YouKar.ml.ErrorNotes.Models.Problemes;
import com.YouKar.ml.ErrorNotes.Others.Etats;
import com.YouKar.ml.ErrorNotes.Services.ProblemesServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProblemesImplTest {


    @Autowired
    private ProblemesServices services;
    @Test
    void deleteProblemes() {
        String titre ="error Been";
        String email ="youssoufdj123@gmail.com";
        String password ="Youskdjire";

        services.DeleteProblemes(titre, email, password);
    }

    @Test
    void create() {
        String  probleme ="Beans";
        String email="youssoufdj123@gmail.com";
        String password="Youskdjire";
        String titrep ="Java JDK";
        String technologiep = "Google";
        Date datep = new Date();
        Long personneId = 1L;
        Enum etat = Etats.ENCOURS;

        Personnes per = new Personnes();
        per.setIdpersonnes(personneId);

        Problemes bleme= new Problemes();
        bleme.setDescriptionp(probleme);
        bleme.setTechnologiep(technologiep);
        bleme.setTitrep(titrep);
        bleme.setDatep(datep);
        bleme.setPersonnesp(per);
        bleme.setEtats((Etats) etat);

        services.Create(bleme, email, password);


    }

    @Test
    void update() {

        String titrep ="Java JDK";
        String probleme ="Beans";
        String email ="youssoufdj123@gmail.com";
        String password ="Youskdjire";
        String technologiep = "Yousking";
        Date datep = new Date();
        Long personneId = 1L;
        Enum etat = Etats.ENCOURS;

        Personnes per = new Personnes();
        per.setIdpersonnes(personneId);


        Problemes bleme= new Problemes();
        bleme.setDescriptionp(probleme);
        bleme.setTechnologiep(technologiep);
        bleme.setTitrep(titrep);
        bleme.setEtats((Etats) etat);

        services.Update(titrep,bleme, email, password);



    }

    @Test
    void recherche() {
        String recherche = "Beans";

        services.recherche(recherche);
    }
}