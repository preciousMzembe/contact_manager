package com.example.contact_manager.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contacts/")
public class ContactController {
    @GetMapping("all")
    public ResponseEntity<String> getContacts(){
        return ResponseEntity.ok("contact created");
    }
}
