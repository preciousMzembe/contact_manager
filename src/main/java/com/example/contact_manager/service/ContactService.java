package com.example.contact_manager.service;

import com.example.contact_manager.dto.ContactDto;

import java.util.List;

public interface ContactService {
    List<ContactDto> findContactsByUserId(long userId);
    List<ContactDto> searchContact(long userId, String name);
    ContactDto createContact(long userId, ContactDto contactDto);
    ContactDto updateContact(long userId, long contactId, ContactDto contactDto);
    void deleteContact(long userId, long contactId);
}
