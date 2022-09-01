package com.YouKar.ml.ErrorNotes.ServicesImpl;

import com.YouKar.ml.ErrorNotes.Models.Admins;
import com.YouKar.ml.ErrorNotes.Models.Personnes;
import com.YouKar.ml.ErrorNotes.Others.Roles;
import com.YouKar.ml.ErrorNotes.Services.AdminsServices;
import com.YouKar.ml.ErrorNotes.Services.PersonnesServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class AdminsImplTest {
    @Autowired
   private AdminsServices services;

    @Test
    void ajouterAdmin() {
        Admins per = new Admins();
        per.setNom("Keita");

        per.setEmail("kmahamadou@gmail.com");
        per.setStatus(Roles.USER);
        per.setPassword("AZERTY1243");
        per.setContact("+223 83918699");
        per.setPrenom("Mahamadou");

        Admins insert = services.AjouterAdmin(per);

        assertNotNull(insert);
        assertEquals(per.getNom(), insert.getNom());
        assertEquals(per.getPrenom(), insert.getPrenom());
        assertEquals(per.getEmail(), insert.getEmail());
        assertEquals(per.getStatus(), insert.getStatus());
        assertEquals(per.getPassword(), insert.getPassword());
        assertEquals(per.getContact(), insert.getContact());

    }

}