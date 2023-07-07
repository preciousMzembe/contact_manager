package com.example.contact_manager.service;

import com.example.contact_manager.dto.ContactDto;

import java.util.List;

public interface ContactService {
    List<ContactDto> findContactsByUserId(long userId);
}
