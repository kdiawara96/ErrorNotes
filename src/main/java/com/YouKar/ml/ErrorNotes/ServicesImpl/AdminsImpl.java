package com.YouKar.ml.ErrorNotes.ServicesImpl;

import com.YouKar.ml.ErrorNotes.Models.Admins;
import com.YouKar.ml.ErrorNotes.Others.Messages;
import com.YouKar.ml.ErrorNotes.Repository.Personnes_repo;
import com.YouKar.ml.ErrorNotes.Services.AdminsServices;
import com.YouKar.ml.ErrorNotes.Services.PersonnesServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class AdminsImpl implements AdminsServices {

    @Autowired
    private final Personnes_repo perService;

    @Override
    public Admins AjouterAdmin(Admins admins) {

        Admins admin = new Admins();
        String aa = admins.getNom().trim();

        System.err.println(aa);

        admin.setNom(admins.getNom());
        admin.setPrenom(admins.getPrenom());
        admin.setContact(admins.getContact());
        admin.setEmail(admins.getEmail());


          int a = admins.getPassword().length();

           System.err.println(a);

          if(a>=8){
              admin.setPassword(admins.getPassword());
          }
        return perService.save(admin);
    }
}
