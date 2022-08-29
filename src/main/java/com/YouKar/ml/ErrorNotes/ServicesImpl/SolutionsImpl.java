package com.YouKar.ml.ErrorNotes.ServicesImpl;

import com.YouKar.ml.ErrorNotes.Models.Personnes;
import com.YouKar.ml.ErrorNotes.Models.Problemes;
import com.YouKar.ml.ErrorNotes.Models.Solutions;
import com.YouKar.ml.ErrorNotes.Repository.Commentaires_repo;
import com.YouKar.ml.ErrorNotes.Repository.Personnes_repo;
import com.YouKar.ml.ErrorNotes.Repository.Problemes_repo;
import com.YouKar.ml.ErrorNotes.Repository.Solutions_repo;
import com.YouKar.ml.ErrorNotes.Services.SolutionServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Data
@AllArgsConstructor

public class SolutionsImpl implements SolutionServices {

    @Autowired
    private final Commentaires_repo repo;
    @Autowired
    private  final Personnes_repo personne;
    @Autowired
    private final Solutions_repo sol;
    @Autowired
    private final Problemes_repo blem;




    @Override
    public String DeleteSolution(Long id, String email) {

        return null;
    }


    @Override
    public Boolean Create(Solutions solution, String email, String titre) {


        Problemes r =   blem.findByTitrep(titre);

       String verifier =  r.getPersonnesp().getEmail();

        Solutions solu = sol.findByProbleme(r);

       if (email.equals(verifier) && solu == null){

           solution.setDatesolution(new Date());

           Date dateProbleme =  r.getDatep();

           Date newdate = new Date();

           //Nous alons calculer le temps consacrer
           final long  minute = 1000 * 60;
           final long heure = minute * 60;
           final long jour = heure * 24;
            final long annee = jour * 365;

           /*  long l = 0;

          long dateannes = (newdate.getTime() - dateProbleme.getTime())/annee;
           long datemois = (newdate.getTime() - dateProbleme.getTime())/jour/30;
           long datejours = (newdate.getTime() - dateProbleme.getTime())/jour;
           long dateheures = (newdate.getTime() - dateProbleme.getTime())/heure;
           long dateminutes = (newdate.getTime() - dateProbleme.getTime())/heure/60;


           if(dateannes > 0  ){
               l=dateannes;
           }else{
               if (datemois > 0){
                   l=datemois;
               }else{
                   if (datejours > 0){
                       l=datejours;
                   }else{
                       if (dateheures > 0){
                           l=dateheures;
                       }else{
                           if (dateminutes > 0){
                               l=dateminutes;
                           }else{
                               System.err.println("Erreur d'heure");
                           }
                       }

                   }

               }
           }
           */


           long l = (newdate.getTime() - dateProbleme.getTime())/heure/60;


           System.err.println(l);

           solution.setTemps_consacrer(l);
           solution.setProbleme(r);

           sol.save(solution);

       }else{
           return null;
       }

        return null;
    }

    @Override
    public Solutions Update(Long id, Solutions solution, String email) {
        return null;
    }


}
