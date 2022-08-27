package com.YouKar.ml.ErrorNotes.Controllers;

import com.YouKar.ml.ErrorNotes.Models.Commentaires;
import com.YouKar.ml.ErrorNotes.Others.Messages;
import com.YouKar.ml.ErrorNotes.Services.CommentaireService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commentaire")
@AllArgsConstructor
public class CommentairesControllers {

    private CommentaireService service;


    @PostMapping("/create/{email}/{titre}")
    public ResponseEntity<Object> creerCommentaire(Commentaires commentaire, @PathVariable("email") String email, @PathVariable("titre") String titre){

        return Messages.Response("", HttpStatus.OK,service.Create(commentaire, email, titre));
    }



    @PutMapping("/update/{id}")

    public Commentaires updateCommentaires(@PathVariable("idc") Long idc, Commentaires commentaires){
        return service.Update(idc,commentaires);
    }


    @DeleteMapping("/deleteCommentaire/{idc}")
    public String supprimerPays(@PathVariable("idc") Long idc){
        
        return service.DeleteCommentaire(idc);
    }

}
