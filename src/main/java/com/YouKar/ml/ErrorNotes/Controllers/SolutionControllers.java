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

    @PostMapping("/create/{email}/{titre}")
    public ResponseEntity<Object> ajouterSolution(@RequestBody Solutions solution, @PathVariable("email") String email, @PathVariable("titre") String titre){
        try {
            return Messages.Response(null, HttpStatus.OK, service.Create(solution, email,titre));
        }catch (Exception e){
            return Messages.Response("Problème non commenter", HttpStatus.OK, service.Create(solution, email,titre));
        }
    }


    @DeleteMapping("/delete/{titre}/{email}")
    public  ResponseEntity<Object> suppression(@PathVariable("titre") String titre, @PathVariable("email") String email){
        try{
            return Messages.Response(null,HttpStatus.OK, service.DeleteSolution(titre, email));
        }catch (Exception e){
            return Messages.Response("Problèmes de suppression du problème!", HttpStatus.OK, null);

        }

    }

    @PutMapping("/update/{titre}/{email}")
    public Boolean modifierSolution(@PathVariable("titre") String titre, @RequestBody Solutions solution, @PathVariable("email") String email){
        service.Update(titre,solution, email);

        return null;

      /*  try{
            return Messages.Response("Problèmes modifier avec successss!", HttpStatus.OK, service.Update(idp,probleme));
        }catch (Exception e){
            return Messages.Response("Erreur survenu lors de la modification du problème!", HttpStatus.OK, null);
        }
*/
    }



}
