package com.YouKar.ml.ErrorNotes.ServicesImpl;

import com.YouKar.ml.ErrorNotes.Models.Users;
import com.YouKar.ml.ErrorNotes.Others.Roles;
import com.YouKar.ml.ErrorNotes.Repository.Personnes_repo;
import com.YouKar.ml.ErrorNotes.Repository.Users_repo;
import com.YouKar.ml.ErrorNotes.Services.UsersServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Data
public class UsersImpl implements UsersServices{


    @Autowired
    private final Users_repo User_Service;

    @Override
    public Users AjouterUsers(Users users) {
        Users user = new Users();

        String aa = users.getNom().trim();

        System.err.println(aa);

        user.setNom(users.getNom());
        user.setPrenom(users.getPrenom());
        user.setContact(users.getContact());
        user.setEmail(users.getEmail());
        user.setStatus(Roles.USER);

        int a = users.getPassword().length();

        System.err.println(a);

        if(a>=8){
            user.setPassword(users.getPassword());
        }
        return User_Service.save(user);
    }
}
