package com.YouKar.ml.ErrorNotes.Services;

import com.YouKar.ml.ErrorNotes.Models.Commentaires;
import com.YouKar.ml.ErrorNotes.Models.Solutions;

public interface SolutionServices {

    public String DeleteSolution(String titre, String email);
    public Boolean Create(Solutions solution, String email, String titre);
    public Solutions Update(String titre , Solutions solution, String email);
}
