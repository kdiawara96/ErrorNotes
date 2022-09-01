package com.YouKar.ml.ErrorNotes.Services;

import com.YouKar.ml.ErrorNotes.Models.Problemes;

import java.util.List;

public interface ProblemesServices {
    
    public String DeleteProblemes(String titre, String email, String password);
    public Boolean Create(Problemes probleme, String email, String password);
    public Problemes Update(String titre , Problemes problemes, String email, String password);


    List<Object> recherche(String recherche);
}
