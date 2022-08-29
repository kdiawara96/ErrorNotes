package com.YouKar.ml.ErrorNotes.Controllers;

import com.YouKar.ml.ErrorNotes.Models.Users;
import com.YouKar.ml.ErrorNotes.Others.Messages;
import com.YouKar.ml.ErrorNotes.Services.UsersServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersControllers {

    private final UsersServices userService;

    @PostMapping("/create")
    public ResponseEntity<Object> AjouterUsers(@RequestBody Users users){
        try{
            System.err.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            return Messages.Response("User is create", HttpStatus.OK, userService.AjouterUsers(users));
                 
        }catch (Exception e){
            System.err.println("erroorrrrrrrrrrrrrrrrrrrrrrrrrr");
            return Messages.Response("Error", HttpStatus.OK,null);
        }
    }

}
