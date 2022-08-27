package com.YouKar.ml.ErrorNotes.Services;

import com.YouKar.ml.ErrorNotes.Models.Commentaires;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface CommentaireService {

    public String DeleteCommentaire(Long id_commentaire);
    public Boolean Create(Commentaires commentaire, String email, String titre);
    public Commentaires Update(Long id_commentaire , Commentaires commentaire);

    //public Commentaires getDateCommentaire(Date datecommentaire);


}
