package com.YouKar.ml.ErrorNotes.ServicesImpl;

import com.YouKar.ml.ErrorNotes.Models.Commentaires;
import com.YouKar.ml.ErrorNotes.Models.Personnes;
import com.YouKar.ml.ErrorNotes.Models.Problemes;
import com.YouKar.ml.ErrorNotes.Models.Solutions;
import com.YouKar.ml.ErrorNotes.Repository.Commentaires_repo;
import com.YouKar.ml.ErrorNotes.Repository.Personnes_repo;
import com.YouKar.ml.ErrorNotes.Repository.Solutions_repo;
import com.YouKar.ml.ErrorNotes.Services.CommentaireService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Data
@AllArgsConstructor

public class CommentairesImpl implements CommentaireService {

    @Autowired
    private final Commentaires_repo repo;
    @Autowired
    private  final Personnes_repo personne;
    @Autowired
    private final Solutions_repo sol;


    @Override
    public String DeleteCommentaire(Long idc, String email, String password) {

      /*  Personnes r = personne.findByEmail(email);
        Commentaires verifier =  repo.findByPersonnes(r);

        if(verifier!= null){
*/


            Personnes r = personne.findByEmail(email);

            long idcc =  r.getIdpersonnes();

            Commentaires idp =  repo.findByIdc(idc);

            long idpp = idp.getPersonnes().getIdpersonnes();


            if (idcc == idpp && r.getPassword().equals(password)){

            repo.deleteById(idc);
            return "Supprimer avec success!";
        }else{
           return "Commentaire non supprimer!";
        }

    }




    @Override
    public Boolean Create(Commentaires commentaire, String email, String titre, String password) {

        Personnes r = personne.findByEmail(email);
        Commentaires verifier =  repo.findByPersonnes(r);

        Personnes perso = personne.findByEmail(email);
        Solutions solu = sol.findByTitre(titre);




      //tout le monde peux commenter les solutions

       if (personne.findByEmail(email) != null || solu != null && r.getPassword().equals(password)){

           //Ajouter un à étoile de solution si user donne true comme valeur en commentaire

           long ids =solu.getIds();

           if (commentaire.isAimer()){

               solu.setEtoiles(solu.getEtoiles()+1);

              // int a = solu.getEtoiles();

               //int value = a+1;

              // System.err.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz "+ids);


               //sol.addOrSousEtoile(value,ids);

           }else {
               solu.setEtoiles(solu.getEtoiles()+1);

              // int a = solu.getEtoiles();

               //int value = a-1;

               //sol.addOrSousEtoile(value,ids);
           }

           sol.save(solu);
        // Fin instruction

        commentaire.setSolution(solu);
        commentaire.setPersonnes(perso);
        commentaire.setDatecommentaire(new Date());
        repo.save(commentaire);

        return true;

       }else{
        
           return false;
       }

    }




    @Override
    public Commentaires Update(Long idc, Commentaires commentaire,String email, String password) {

        Personnes r = personne.findByEmail(email);


      long idcc =  r.getIdpersonnes();

       Commentaires idp =  repo.findByIdc(idc);

       long idpp = idp.getPersonnes().getIdpersonnes();


        if (idcc == idpp && r.getPassword().equals(password)){

            return repo.findById(idc).map(up->{


                if(commentaire.getDescription_commentaire() == null){

                    up.setDescription_commentaire(up.getDescription_commentaire());

                }else{

                    up.setDescription_commentaire(commentaire.getDescription_commentaire());

                }



                // up.setDatecommentaire(commentaire.getDatecommentaire());

                up.setDatecommentaire(new Date());
                return repo.save(up);

            }).orElseThrow(()->new RuntimeException("Commentaire non trouver!"));
        }
        return commentaire;

    }





}
