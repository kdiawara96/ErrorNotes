package com.YouKar.ml.ErrorNotes.ServicesImpl;

import com.YouKar.ml.ErrorNotes.Models.Problemes;
import com.YouKar.ml.ErrorNotes.Models.Solutions;
import com.YouKar.ml.ErrorNotes.Others.Etats;
import com.YouKar.ml.ErrorNotes.Repository.Problemes_repo;
import com.YouKar.ml.ErrorNotes.Services.ProblemesServices;
import com.YouKar.ml.ErrorNotes.Services.SolutionServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SolutionsImplTest {


    @Autowired
    private SolutionServices services;
    @Autowired
    private Problemes_repo problemesServices;
    @Test
    void deleteSolution() {

        String titre ="error Pp";
        String email ="youssoufdj123@gmail.com";
        String password ="Youskdjire";
        //Long ids= 1L;

       // Solutions sol = new Solutions();
       // sol.setIds(ids);

        services.DeleteSolution(titre, email,  password);

    }

    @Test
    void create() {


       String solution ="un probleme( hibernate ne crée pas de tables)";
        String email ="youssoufdj123@gmail.com";
        String titre ="ERROR";
        String titreProbleme = "error JavaScript";
        String password ="Youskdjire";
        String methode_recherche ="Youtube";
        String ressource_solution ="Google";
        Date datesolution = new Date();
        Enum etat = Etats.INITIAL;
        Long idp = 1L;
       // String temps_consacrer

        //Problemes bleme= problemesServices.findByTitrep(titreProbleme);
        //bleme.setIdp(idp);

        Solutions sol = new Solutions();

        sol.setTitre(titre);
        sol.setDescription_solution(solution);
        sol.setDatesolution(datesolution);
        //sol.setProbleme(bleme);
        sol.setRessource_solution(ressource_solution);
        sol.setMethode_recherche(methode_recherche);





        services.Create(sol,email,titreProbleme, password);
    }

    @Test
    void update() {

        String solution ="un probleme( hibernate ne crée pas de tables)";
        String email ="youssoufdj123@gmail.com";
        String titre ="ERROR__PPPP";
        String titreProbleme = "error JavaScript";
        String password ="Youskdjire";
        String methode_recherche ="Youtube";
        String ressource_solution ="Google";
        Date datesolution = new Date();
        Enum etat = Etats.INITIAL;
        Long idp = 1L;

        Solutions sol = new Solutions();

        sol.setTitre(titre);
        sol.setDescription_solution(solution);
        sol.setDatesolution(datesolution);
        //sol.setProbleme(bleme);
        sol.setRessource_solution(ressource_solution);
        sol.setMethode_recherche(methode_recherche);

        services.Create(sol,email,titreProbleme, password);
    }
}