package com.example.contact_manager.repository;

import com.example.contact_manager.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAllByUserId(Long id);
}
