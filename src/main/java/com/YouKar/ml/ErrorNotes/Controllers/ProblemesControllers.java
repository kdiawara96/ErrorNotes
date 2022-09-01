package com.YouKar.ml.ErrorNotes.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.YouKar.ml.ErrorNotes.Models.Problemes;
import com.YouKar.ml.ErrorNotes.Others.Messages;
import com.YouKar.ml.ErrorNotes.Services.ProblemesServices;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/problemes")
@AllArgsConstructor

public class ProblemesControllers {

    @Autowired
    private ProblemesServices service;


    @PostMapping("/create/{email}/{password}")
    public ResponseEntity<Object>  creerProblemes(@RequestBody Problemes problemes, @PathVariable("email") String email, @PathVariable("password") String password){


  try{
    return Messages.Response("", HttpStatus.OK,service.Create(problemes, email, password));

  }catch(Exception e){
    return Messages.Response("Problèmes non créer! ", HttpStatus.OK,null);

  }


            }

            @PutMapping("/update/{titre}/{email}/{password}")
    public Boolean modifierProblème( @PathVariable("titre") String titre, @RequestBody Problemes probleme, @PathVariable("email") String email, @PathVariable("password") String password){
                service.Update(titre,probleme, email,password);
            return null;

      /*  try{
            return Messages.Response("Problèmes modifier avec successss!", HttpStatus.OK, service.Update(idp,probleme));
        }catch (Exception e){
            return Messages.Response("Erreur survenu lors de la modification du problème!", HttpStatus.OK, null);
        }
*/
            }


        /*    @DeleteMapping("/delete/{titre}/{email}/{password}")

            public  ResponseEntity<Object> suppression(@PathVariable("titre") String titre, @PathVariable("email") String email, @PathVariable("password") String password){
        try{
           return Messages.Response(null,HttpStatus.OK, service.DeleteProblemes(titre, email,password));
        }catch (Exception e){
            return Messages.Response("Problèmes de suppression!", HttpStatus.OK, null);

        }

            }*/

    @DeleteMapping("/delete/{titre}/{email}/{password}")

    public  String suppression(@PathVariable("titre") String titre, @PathVariable("email") String email, @PathVariable("password") String password){
       service.DeleteProblemes(titre, email,password);
      return null;
    }

    @GetMapping("/recherche/{recherche}")
    List<Object> recherche(@PathVariable("recherche") String recherche){

        return service.recherche(recherche);
    }




    
}
