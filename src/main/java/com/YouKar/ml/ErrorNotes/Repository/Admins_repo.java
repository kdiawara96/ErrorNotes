package com.YouKar.ml.ErrorNotes.Repository;

import com.YouKar.ml.ErrorNotes.Models.Admins;
import com.YouKar.ml.ErrorNotes.Models.Commentaires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Admins_repo extends JpaRepository<Admins, Long> {
}
