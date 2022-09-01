package com.YouKar.ml.ErrorNotes.ServicesImpl;

import com.YouKar.ml.ErrorNotes.Models.Personnes;
import com.YouKar.ml.ErrorNotes.Others.Roles;
import com.YouKar.ml.ErrorNotes.Repository.Personnes_repo;
import com.YouKar.ml.ErrorNotes.Services.PersonnesServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PersonnesImpl implements PersonnesServices {

    private final Personnes_repo repo;

    @Override
    public Personnes connexion(String email, String password) {



        Personnes mail = repo.findByEmail(email);
       Personnes pass = repo.findByPassword(password);

        if (mail != null && pass != null){

        //  Long id =  mail.getIdpersonnes();
        //repo.findById(id);
            return mail;
        }else {
            return null;
        }

    }

    @Override
    public String DeleteUser(Long id, String email) {

        Personnes mail = repo.findByEmail(email);
     if (mail != null && mail.getStatus()== Roles.ADMIN ){
         repo.deleteById(id);
         return "Supprimer avec succès!";
     }else{
         return "User non supprimer!";
     }

    }
}
