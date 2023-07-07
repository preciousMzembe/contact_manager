package com.example.contact_manager.controllers;

import com.example.contact_manager.dto.ContactDto;
import com.example.contact_manager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
