package com.YouKar.ml.ErrorNotes.Repository;

import com.YouKar.ml.ErrorNotes.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Users_repo extends JpaRepository<Users, Long> {
}
