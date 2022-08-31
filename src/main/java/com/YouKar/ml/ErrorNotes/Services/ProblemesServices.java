package com.YouKar.ml.ErrorNotes.Services;

import com.YouKar.ml.ErrorNotes.Models.Problemes;

import java.util.List;

public interface ProblemesServices {
    
    public String DeleteProblemes(String titre, String email);
    public Boolean Create(Problemes probleme, String email);
    public Problemes Update(String titre , Problemes problemes, String email);


    List<Object> recherche(String recherche);
}
