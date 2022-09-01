package com.YouKar.ml.ErrorNotes.ServicesImpl;

import com.YouKar.ml.ErrorNotes.Models.Admins;
import com.YouKar.ml.ErrorNotes.Models.Users;
import com.YouKar.ml.ErrorNotes.Others.Roles;
import com.YouKar.ml.ErrorNotes.Services.UsersServices;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersImplTest {
    @Autowired
private UsersServices services;
    @Test
    void ajouterUsers() {
        Users per = new Users();
        per.setNom("Keita");
        per.setEmail("kmahamadou@gmail.com");
        per.setStatus(Roles.USER);
        per.setPassword("AZERTY1243");
        per.setContact("+223 83918699");
        per.setPrenom("Mahamadou");
        services.AjouterUsers(per);
    }
}