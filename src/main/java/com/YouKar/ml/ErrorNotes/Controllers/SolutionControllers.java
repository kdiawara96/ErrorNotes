package com.YouKar.ml.ErrorNotes.Controllers;

import com.YouKar.ml.ErrorNotes.Models.Solutions;
import com.YouKar.ml.ErrorNotes.Others.Messages;
import com.YouKar.ml.ErrorNotes.Repository.Solutions_repo;
import com.YouKar.ml.ErrorNotes.Services.SolutionServices;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solutions")
@AllArgsConstructor

public class SolutionControllers {
    private SolutionServices  service;

    @PostMapping("/create/{email}/{titre}")
    public ResponseEntity<Object> ajouterSolution(@RequestBody Solutions solution, @PathVariable("email") String email, @PathVariable("titre") String titre){
        try {
            return Messages.Response("Solutionner avec success!", HttpStatus.OK, service.Create(solution, email,titre));
        }catch (Exception e){
            return Messages.Response("Problème non commenter", HttpStatus.OK, service.Create(solution, email,titre));
        }
    }




}
