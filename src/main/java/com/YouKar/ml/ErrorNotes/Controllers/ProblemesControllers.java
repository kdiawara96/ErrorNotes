package com.YouKar.ml.ErrorNotes.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Object>  creerProblemes(@RequestBody Problemes problemes, @PathVariable("email") String email){


  try{
    return Messages.Response("", HttpStatus.OK,service.Create(problemes, email));

  }catch(Exception e){
    return Messages.Response("Problèmes non créer! ", HttpStatus.OK,null);

  }


            }

            @PutMapping("/update/{titre}/{email}")
    public Boolean modifierProblème( @PathVariable("titre") String titre, @RequestBody Problemes probleme, @PathVariable("email") String email){
                service.Update(titre,probleme, email);
            return null;

      /*  try{
            return Messages.Response("Problèmes modifier avec successss!", HttpStatus.OK, service.Update(idp,probleme));
        }catch (Exception e){
            return Messages.Response("Erreur survenu lors de la modification du problème!", HttpStatus.OK, null);
        }
*/
            }


            @DeleteMapping("/delete/{titre}/{email}")

            public  ResponseEntity<Object> suppression(@PathVariable("titre") String titre, @PathVariable("email") String email){
        try{
           return Messages.Response(null,HttpStatus.OK, service.DeleteProblemes(titre, email));
        }catch (Exception e){
            return Messages.Response("Problèmes de suppression!", HttpStatus.OK, null);

        }

            }




    
}
