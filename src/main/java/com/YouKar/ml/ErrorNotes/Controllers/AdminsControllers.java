package com.YouKar.ml.ErrorNotes.Controllers;

import com.YouKar.ml.ErrorNotes.Models.Admins;
import com.YouKar.ml.ErrorNotes.Others.Messages;
import com.YouKar.ml.ErrorNotes.Services.AdminsServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/admins")
@RestController
@AllArgsConstructor

public class AdminsControllers {

    private final AdminsServices adService;

    @PostMapping("/create")
    public ResponseEntity<Object> AjouterAdmins(@RequestBody Admins admin){
        try{
            return Messages.Response("", HttpStatus.OK,adService.AjouterAdmin(admin));

        }catch (Exception e){
            return Messages.Response("Error", HttpStatus.OK,null);
        }
         }



}
