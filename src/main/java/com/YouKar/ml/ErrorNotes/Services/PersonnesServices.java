package com.YouKar.ml.ErrorNotes.Services;

import com.YouKar.ml.ErrorNotes.Models.Personnes;

public interface PersonnesServices {

    public Personnes connexion(String email, String password);
    public String DeleteUser(Long id , String email);
}
