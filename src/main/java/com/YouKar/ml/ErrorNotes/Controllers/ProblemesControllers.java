package com.YouKar.ml.ErrorNotes.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.YouKar.ml.ErrorNotes.Models.Problemes;
import com.YouKar.ml.ErrorNotes.Others.Messages;
import com.YouKar.ml.ErrorNotes.Services.ProblemesServices;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/problemes")
@AllArgsConstructor

public class ProblemesControllers {

    private ProblemesServices service;


    @PostMapping("/create/{email}")
    public ResponseEntity<Object> creerProblemes(Problemes problemes, @PathVariable("email") String email){
  try{
    return Messages.Response("Problèmes créer avec successs", HttpStatus.OK,service.Create(problemes, email));

  }catch(Exception e){
    return Messages.Response("Problèmes non créer! ", HttpStatus.OK,null);

  }
            }


    
}
