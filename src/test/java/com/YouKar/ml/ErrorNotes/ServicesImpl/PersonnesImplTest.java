package com.YouKar.ml.ErrorNotes.ServicesImpl;

import com.YouKar.ml.ErrorNotes.Models.Personnes;
import com.YouKar.ml.ErrorNotes.Models.Solutions;
import com.YouKar.ml.ErrorNotes.Others.Roles;
import com.YouKar.ml.ErrorNotes.Services.PersonnesServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonnesImplTest {
    @Autowired
    private PersonnesServices services;
    @Test
    void connexion() {

        String nom ="Cisse";
        String prenom ="Alba";
        String email ="albacisse@gmail.com";
        String contact ="+223 68295253";
        String password ="Albacisse";
        Enum roles = Roles.USER;

        Personnes per = new Personnes();
        per.setNom(nom);
        per.setPrenom(prenom);
        per.setEmail(email);
        per.setContact(contact);
        per.setPassword(password);


        services.connexion(email, password);
    }

    @Test
    void deleteUser() {
    }
}