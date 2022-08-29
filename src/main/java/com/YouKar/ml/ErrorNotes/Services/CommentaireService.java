package com.YouKar.ml.ErrorNotes.Services;

import com.YouKar.ml.ErrorNotes.Models.Commentaires;

public interface CommentaireService {

    public String DeleteCommentaire(Long id_commentaire, String email);
    public Boolean Create(Commentaires commentaire, String email, String titre);
    public Commentaires Update(Long id_commentaire , Commentaires commentaire, String email);

    //public Commentaires getDateCommentaire(Date datecommentaire);


}
