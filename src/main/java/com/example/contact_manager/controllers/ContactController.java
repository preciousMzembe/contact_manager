package com.example.contact_manager.controllers;

import com.example.contact_manager.dto.ContactDto;
import com.example.contact_manager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts/")
public class ContactController {
    private ContactService contactService;
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("all")
    public ResponseEntity<String> getContacts(){
        List<ContactDto> contacts = contactService.findContactsByUserId(1);
        return ResponseEntity.ok("All contacts");
    }

    @GetMapping("search/{name}")
    public ResponseEntity<String> searchContact(){
        return ResponseEntity.ok("search contact");
    }

    @PostMapping("/create")
    public ResponseEntity<String> createContact(){
        return ResponseEntity.ok("contact created");
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<String> updateContact(){
        return ResponseEntity.ok("contact updated");
    }

    @DeleteMapping("delete/{contactId}")
    public ResponseEntity<String> deleteContact(){
        return ResponseEntity.ok("contact deleted");
    }
}
