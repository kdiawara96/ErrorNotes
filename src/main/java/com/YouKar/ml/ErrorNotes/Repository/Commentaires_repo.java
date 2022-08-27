package com.YouKar.ml.ErrorNotes.Repository;

import com.YouKar.ml.ErrorNotes.Models.Commentaires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface Commentaires_repo extends JpaRepository<Commentaires,Long> {

    //public Commentaires findByDatecommentaire();

    public Commentaires findByIdc(Long idc);
}
