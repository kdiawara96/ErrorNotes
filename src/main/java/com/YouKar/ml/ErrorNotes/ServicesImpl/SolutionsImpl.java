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
    public String DeleteSolution(String titre, String email) {

        Personnes r = personne.findByEmail(email);

        Problemes tit = blem.findByTitrep(titre);

        Solutions ttt = sol.findByTitre(titre);

       long id = ttt.getProbleme().getPersonnesp().getIdpersonnes();

       // long id =   tit.getPersonnesp().getId();

        long ids = ttt.getIds();


      if (id == r.getIdpersonnes()) {
        sol.deleteById(ids);
    
    }else{
        return null;
    }
        return null;
    }


    @Override
    public Boolean Create(Solutions solution, String email, String titre) {


        Personnes r = personne.findByEmail(email);

        Problemes tit = blem.findByTitrep(titre);

        long id =   tit.getPersonnesp().getIdpersonnes();

        long idp =tit.getIdp();





        Problemes rr =   blem.findByTitrep(titre);

       //String verifier =  rr.getPersonnesp().getEmail();

        Solutions solu = sol.findByProbleme(rr);



        if (id == r.getIdpersonnes() && solu == null){

           solution.setDatesolution(new Date());

           Date dateProbleme =  rr.getDatep();

           Date newdate = new Date();

           //Nous alons calculer le temps consacrer
           final long  minute = 1000 * 60;
           final long heure = minute * 60;
           final long jour = heure * 24;
            final long annee = jour * 365;

            long l = 0;

          long dateannes = (newdate.getTime() - dateProbleme.getTime())/86400000*30*365;
           long datemois = (newdate.getTime() - dateProbleme.getTime())/86400000*30;
           long datejours = (newdate.getTime() - dateProbleme.getTime())/86400000;
           long dateheures = (newdate.getTime() - dateProbleme.getTime())/3600000;
           long dateminutes = (newdate.getTime() - dateProbleme.getTime())/60000;

            if(dateannes >= 1  ){
               l=dateannes;
               solution.setTemps_consacrer(l+" ANNEES");
           }else{
               if (datemois >= 1){
                   l=datemois;
                   solution.setTemps_consacrer(l+" MOIS");
               }else{
                   if (datejours >= 1){
                       l=datejours;
                       solution.setTemps_consacrer(l+" JOURS");
                   }else{
                       if (dateheures >= 1){
                           l=dateheures;
                           solution.setTemps_consacrer(l+" HEURES");
                       }else{
                           if (dateminutes >= 1){
                               l=dateminutes;
                               solution.setTemps_consacrer(l+" MINUTES");
                           }else{
                                       solution.setTemps_consacrer(l+" SECONDES");
                           }
                       }

                   }

               }
           }



          /* long l = (newdate.getTime() - dateProbleme.getTime())/(1000 * 60);

           solution.setTemps_consacrer(l+" MINUTES");
           */
           solution.setProbleme(rr);

           //solution.setEtoiles(solution.getEtoiles());

           sol.save(solution);

       }else{
           return null;
       }

        return null;
    }



    @Override
    public Solutions Update(String titre, Solutions solution, String email) {


    /*    Personnes r = personne.findByEmail(email);

        Problemes tit = blem.findByTitrep(titre);

        long id =   tit.getPersonnesp().getIdpersonnes();

        long idp =tit.getIdp();
*/



       // Personnes r = personne.findByEmail(email);
       // Problemes verifier =  blem.findByPersonnesp(r);


        Personnes r = personne.findByEmail(email);

        Problemes tit = blem.findByTitrep(titre);

        Solutions ttt = sol.findByTitre(titre);

        long id = ttt.getProbleme().getPersonnesp().getIdpersonnes();



        long ids = ttt.getIds();



        if (id == r.getIdpersonnes()){

         // Solutions tion = sol.findByIds(id);

          return sol.findById(ids).map(p->{

                 if (solution.getTitre() != null){
                     p.setTitre(solution.getTitre());
                 }else{
                     p.setTitre(p.getTitre());
                 }

              if (solution.getDescription_solution() != null){
                  p.setDescription_solution(solution.getDescription_solution());
              }else{
                  p.setDescription_solution(p.getDescription_solution());
              }

              if (solution.getRessource_solution() != null){
                  p.setRessource_solution(solution.getRessource_solution());
              }else{
                  p.setRessource_solution(p.getRessource_solution());
              }

              if (solution.getMethode_recherche() != null){
                  p.setMethode_recherche(solution.getMethode_recherche());
              }else{
                  p.setMethode_recherche(p.getMethode_recherche());
              }



              p.setEtoiles(p.getEtoiles());

              p.setTemps_consacrer(p.getTemps_consacrer());

              p.setDatesolution(p.getDatesolution());


          return sol.save(p);

          }).orElseThrow(()->new RuntimeException("Solution non trouver!"));
        }
        return null;
    }


}
