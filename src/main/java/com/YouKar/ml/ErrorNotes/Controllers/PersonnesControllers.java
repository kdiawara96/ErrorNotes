package com.YouKar.ml.ErrorNotes.Controllers;


import com.YouKar.ml.ErrorNotes.Models.Personnes;
import com.YouKar.ml.ErrorNotes.Models.Problemes;
import com.YouKar.ml.ErrorNotes.Others.Messages;
import com.YouKar.ml.ErrorNotes.Services.PersonnesServices;
import com.YouKar.ml.ErrorNotes.Services.ProblemesServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personnes")
@AllArgsConstructor
public class PersonnesControllers {

    @Autowired
    private PersonnesServices service;

    @GetMapping("/read/{email}/{password}")
    public Personnes AfficherUser(@PathVariable("email") String email, @PathVariable("password") String password){
       return service.connexion(email, password);
        }


}
