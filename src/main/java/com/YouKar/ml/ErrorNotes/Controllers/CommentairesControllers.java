package com.YouKar.ml.ErrorNotes.Controllers;

import com.YouKar.ml.ErrorNotes.Models.Commentaires;
import com.YouKar.ml.ErrorNotes.Others.Messages;
import com.YouKar.ml.ErrorNotes.Services.CommentaireService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commentaires")
@AllArgsConstructor

public class CommentairesControllers {

    private CommentaireService service;


    @PostMapping("/create/{email}/{titre}")
    public ResponseEntity<Object> creerCommentaire(@RequestBody Commentaires commentaire, @PathVariable("email") String email, @PathVariable("titre") String titre){

        return Messages.Response("", HttpStatus.OK,service.Create(commentaire, email, titre));
    }



    @PutMapping("/update/{idc}/{email}")

    public ResponseEntity<Object> updateCommentaires(@PathVariable("idc") Long idc, @RequestBody Commentaires commentaires, @PathVariable("email") String email){

        try{
           return Messages.Response("Modifier avec success", HttpStatus.OK, service.Update(idc,commentaires, email));
        }catch(Exception e){
            return Messages.Response("Erreur survenu lors de la modification du commentaire", HttpStatus.OK, null);
        }

    }



    @DeleteMapping("/delete/{idc}/{email}")
    public ResponseEntity<Object> supprimerPays(@PathVariable("idc") Long idc, @PathVariable("email") String email){
    
        try {
            return Messages.Response("Commentaire supprimer avec succès!", HttpStatus.OK, service.DeleteCommentaire(idc, email)) ;
        }catch (Exception e) {
            return Messages.Response("Commentaire non supprimer!", HttpStatus.OK,null) ;

        }

}
}