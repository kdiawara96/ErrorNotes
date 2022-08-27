package com.YouKar.ml.ErrorNotes.ServicesImpl;

import com.YouKar.ml.ErrorNotes.Models.Commentaires;
import com.YouKar.ml.ErrorNotes.Models.Personnes;
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
    public String DeleteCommentaire(Long id_commentaire) {
         repo.deleteById(id_commentaire);
        return null;
    }

    @Override
    public Boolean Create(Commentaires commentaire, String email, String titre) {

        Personnes perso = personne.findByEmail(email);
        Solutions solu = sol.findByTitre(titre);


       if (personne.findByEmail(email) == null || sol.findByTitre(titre) == null){
           return false;
       }else{
           commentaire.setSolution(solu);
           commentaire.setPersonnes(perso);
           commentaire.setDatecommentaire(new Date());
           repo.save(commentaire);

           return true;
       }

    }


    @Override
    public Commentaires Update(Long idc, Commentaires commentaire) {
        Commentaires com = repo.findByIdc(idc);
        //com.getDatecommentaire()

        return repo.findById(idc).map(up->{
            up.setDescription_commentaire(commentaire.getDescription_commentaire());
            up.setDatecommentaire(commentaire.getDatecommentaire());
            up.setDatecommentaire(up.getDatecommentaire());
            return repo.save(up);
        }).orElseThrow(()->new RuntimeException("Commentaire non trouver!"));
    }

}
