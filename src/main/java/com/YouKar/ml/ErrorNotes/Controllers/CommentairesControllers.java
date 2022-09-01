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


    @PostMapping("/create/{email}/{password}/{titre}")
    public ResponseEntity<Object> creerCommentaire(@RequestBody Commentaires commentaire, @PathVariable("email") String email, @PathVariable("password") String password,@PathVariable("titre") String titre){

        return Messages.Response("", HttpStatus.OK,service.Create(commentaire, email,password, titre));
    }



    @PutMapping("/update/{idc}/{email}/{password}")

    public ResponseEntity<Object> updateCommentaires(@PathVariable("idc") Long idc, @RequestBody Commentaires commentaires, @PathVariable("email") String email, @PathVariable("password") String password){

        try{
           return Messages.Response("Modifier avec success", HttpStatus.OK, service.Update(idc,commentaires, email, password));
        }catch(Exception e){
            return Messages.Response("Erreur survenu lors de la modification du commentaire", HttpStatus.OK, null);
        }

    }



    @DeleteMapping("/delete/{idc}/{email}/{password}")
    public ResponseEntity<Object> supprimerPays(@PathVariable("idc") Long idc, @PathVariable("email") String email, @PathVariable("password") String password){
    
        try {
            return Messages.Response("Commentaire supprimer avec succès!", HttpStatus.OK, service.DeleteCommentaire(idc, email, password)) ;
        }catch (Exception e) {
            return Messages.Response("Commentaire non supprimer!", HttpStatus.OK,null) ;

        }

}
}