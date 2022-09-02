package com.YouKar.ml.ErrorNotes.Controllers;

import com.YouKar.ml.ErrorNotes.Models.Problemes;
import com.YouKar.ml.ErrorNotes.Models.Solutions;
import com.YouKar.ml.ErrorNotes.Others.Messages;
import com.YouKar.ml.ErrorNotes.Repository.Solutions_repo;
import com.YouKar.ml.ErrorNotes.Services.SolutionServices;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solutions")
@AllArgsConstructor

public class SolutionControllers {
    private SolutionServices  service;

    @PostMapping("/create/{email}/{password}/{titre}")
    public ResponseEntity<Object> ajouterSolution(@RequestBody Solutions solution, @PathVariable("email") String email, @PathVariable("titre") String titre , @PathVariable("password") String password){
        try {
            return Messages.Response(null, HttpStatus.OK, service.Create(solution, email,titre,password));
        }catch (Exception e){
            return Messages.Response("Problème non commenter", HttpStatus.OK, null);
        }
    }


    @DeleteMapping("/delete/{titre}/{email}/{password}")
    public  ResponseEntity<Object> suppression(@PathVariable("titre") String titre, @PathVariable("email") String email, @PathVariable("password") String password){
        try{
            return Messages.Response(null,HttpStatus.OK, service.DeleteSolution(titre, email,password));
        }catch (Exception e){
            return Messages.Response("Problèmes de suppression du problème!", HttpStatus.OK, null);

        }

    }

    @PutMapping("/update/{titre}/{email}/{password}")
    public Boolean modifierSolution(@PathVariable("titre") String titre, @RequestBody Solutions solution, @PathVariable("email") String email, @PathVariable("password") String password){
        service.Update(titre,solution, email, password);

        return null;

      /*  try{
            return Messages.Response("Problèmes modifier avec successss!", HttpStatus.OK, service.Update(idp,probleme));
        }catch (Exception e){
            return Messages.Response("Erreur survenu lors de la modification du problème!", HttpStatus.OK, null);
        }
*/
    }



}
