package com.YouKar.ml.ErrorNotes.Controllers;


import com.YouKar.ml.ErrorNotes.Models.Personnes;
import com.YouKar.ml.ErrorNotes.Services.PersonnesServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personnes")
@AllArgsConstructor
public class PersonnesControllers {

    @Autowired
    private PersonnesServices service;

    @GetMapping("/read/{email}/{password}")
    public Personnes AfficherUser(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password){
       return service.connexion(email, password);
    }


    @DeleteMapping("/deleteUser/{id}/{email}")
    public String deleteUser(@PathVariable("id") long id, @PathVariable("email") String email){

                service.DeleteUser(id,email);
                return "ok";
    }

}
