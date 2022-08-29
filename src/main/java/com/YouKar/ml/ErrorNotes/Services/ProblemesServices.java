package com.YouKar.ml.ErrorNotes.Services;

import com.YouKar.ml.ErrorNotes.Models.Problemes;

public interface ProblemesServices {
    
    public String DeleteProblemes(Long idp, String email);
    public Boolean Create(Problemes probleme, String email);
    public Problemes Update(Long idp , Problemes problemes);
}
