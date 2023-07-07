package com.example.contact_manager.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Data
@Builder
public class ContactDto {
    private long id;
    private String name;
    private String phone;
    private String email;
    private LocalDateTime createdAt;
}
