package com.example.contact_manager.controllers;

import com.example.contact_manager.dto.ContactDto;
import com.example.contact_manager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ResponseEntity<List<ContactDto>> getContacts(){
        String username = getUsernameFromSecurity();
        List<ContactDto> contacts = contactService.findContactsByUserId(1);
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("search/{name}")
    public ResponseEntity<List<ContactDto>> searchContact(@PathVariable("name") String name){
        String username = getUsernameFromSecurity();
        List<ContactDto> contacts = contactService.searchContact(1, name);
        return ResponseEntity.ok(contacts);
    }

    @PostMapping("/create")
    public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto contactDto){
        String username = getUsernameFromSecurity();
        ContactDto newContact = contactService.createContact(1, contactDto);
        return ResponseEntity.ok(newContact);
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ContactDto> updateContact(@RequestBody ContactDto contactDto, @PathVariable("contactId") long contactId){
        String username = getUsernameFromSecurity();
        ContactDto updatedContact = contactService.updateContact(1, contactId, contactDto);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("delete/{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable("contactId") long contactId){
        String username = getUsernameFromSecurity();
        contactService.deleteContact(1, contactId);
        return ResponseEntity.ok("contact deleted");
    }

    private String getUsernameFromSecurity(){
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if(principle instanceof UserDetails){
            username = ((UserDetails) principle).getUsername();
        }else {
            username = principle.toString();
        }

        return username;
    }
}
