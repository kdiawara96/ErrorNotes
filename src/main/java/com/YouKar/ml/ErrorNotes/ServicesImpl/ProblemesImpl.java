package com.YouKar.ml.ErrorNotes.ServicesImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.YouKar.ml.ErrorNotes.Models.Personnes;
import com.YouKar.ml.ErrorNotes.Models.Problemes;
import com.YouKar.ml.ErrorNotes.Others.Etats;
import com.YouKar.ml.ErrorNotes.Repository.Commentaires_repo;
import com.YouKar.ml.ErrorNotes.Repository.Personnes_repo;
import com.YouKar.ml.ErrorNotes.Repository.Problemes_repo;
import com.YouKar.ml.ErrorNotes.Repository.Solutions_repo;
import com.YouKar.ml.ErrorNotes.Services.ProblemesServices;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor

public class ProblemesImpl implements ProblemesServices {


    @Autowired
    private final Commentaires_repo repo;
    @Autowired
    private  final Personnes_repo personne;
    @Autowired
    private final Solutions_repo sol;
    @Autowired
    private final Problemes_repo blem;



    @Override
    public String DeleteProblemes(String titre, String email, String password) {

       Personnes r = personne.findByEmail(email);



       Problemes tit = blem.findByTitrep(titre);

          long id =   tit.getPersonnesp().getIdpersonnes();

       if( id == r.getIdpersonnes() && r.getPassword().equals(password)){

            blem.deleteById(tit.getIdp());
           return "Suppression";
       }else{
            return "Vous n'avez pas le droit de supprimer";
        }


    }



    @Override
    public Boolean Create(Problemes probleme, String email ,String password) {

        Personnes perso = personne.findByEmail(email);


       // Problemes titrep = pro.findByTitre(titre);

          //verifier si le user == au meme user qui à poster le problème
         // Personnes r = personne.findByEmail(email);
        // Problemes verifier =  blem.findByPersonnesp(r);

        if (personne.findByEmail(email)!= null && sol.findByTitre(probleme.getTitrep()) == null && perso.getPassword().equals(password)){

            probleme.setPersonnesp(perso);
            probleme.setEtats(Etats.INITIAL);
            probleme.setDatep(new Date());

            blem.save(probleme);

            return true;
        }else{

    return false;

        }
    }




    @Override
    public Problemes Update(String titre, Problemes problemes, String email, String password) {

        //verifier si le user == au meme user qui à poster le problème
        /*Personnes r = personne.findByEmail(email);
        Problemes verifier =  blem.findByPersonnesp(r);*/


        Personnes r = personne.findByEmail(email);



        Problemes tit = blem.findByTitrep(titre);

        long id =   tit.getPersonnesp().getIdpersonnes();

        long idp =tit.getIdp();

        if (id == r.getIdpersonnes() && r.getPassword().equals(password)){


            Problemes probl = blem.findByIdp(idp);

            return blem.findById(idp).map(p->{

                p.setDatep(probl.getDatep());

                if(problemes.getDescriptionp() ==null){
                    p.setDescriptionp(p.getDescriptionp());

                }else{
                    p.setDescriptionp(problemes.getDescriptionp());
                }


                if(problemes.getEtats()==null){
                    p.setEtats(p.getEtats());
                }else{
                    p.setEtats(problemes.getEtats());
                }


                if(problemes.getTechnologiep()==null){

                    p.setTechnologiep(p.getTechnologiep());

                }else{
                    p.setTechnologiep(problemes.getTechnologiep());
                }



                if(problemes.getTitrep()==null){

                    p.setTitrep(p.getTitrep());

                }else{
                    p.setTitrep(problemes.getTitrep());
                }


                return blem.save(p);

            }).orElseThrow(()->new RuntimeException("Problème non trouver!"));
        }

   return null;
    }

    @Override
    public List<Object> recherche(String recherche) {

        List<Object> resultat = blem.recherche(recherche);

        if (recherche != null) {
            System.out.println(resultat);
            if (resultat != null) {
                System.out.println("liste vide");
            } else {
                System.out.println("aucun probleme trouvé ");
            }
        }
        return resultat;
    }



}
