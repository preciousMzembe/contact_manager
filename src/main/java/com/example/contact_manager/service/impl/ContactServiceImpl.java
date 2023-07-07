package com.example.contact_manager.service.impl;

import com.example.contact_manager.dto.ContactDto;
import com.example.contact_manager.models.Contact;
import com.example.contact_manager.repository.ContactRepository;
import com.example.contact_manager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;
    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<ContactDto> findContactsByUserId(long userId) {
        List<Contact> contacts = contactRepository.findAllByUserId(userId);
        return contacts.stream().map(contact -> mapToDto(contact)).collect(Collectors.toList());
    }

    private ContactDto mapToDto(Contact contact) {
        ContactDto contactDto = ContactDto.builder()
                .id(contact.getId())
                .name(contact.getName())
                .phone(contact.getPhone())
                .email(contact.getEmail())
                .createdAt(contact.getCreatedAt())
                .build();
        return contactDto;
    }

    private Contact mapToEntity(ContactDto contactDto){
        Contact contact = Contact.builder()
                .id(contactDto.getId())
                .name(contactDto.getName())
                .phone(contactDto.getPhone())
                .email(contactDto.getEmail())
                .createdAt(contactDto.getCreatedAt())
                .build();
        return contact;
    }
}
