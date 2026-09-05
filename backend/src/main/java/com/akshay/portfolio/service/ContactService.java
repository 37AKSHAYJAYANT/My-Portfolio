package com.akshay.portfolio.service;

import com.akshay.portfolio.dto.ContactRequest;
import com.akshay.portfolio.entity.ContactMessage;
import com.akshay.portfolio.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactService {

    private final ContactMessageRepository contactMessageRepository;

    public ContactService(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    @Transactional
    public ContactMessage saveMessage(ContactRequest request) {
        ContactMessage message = new ContactMessage(
                request.getName().trim(),
                request.getEmail().trim(),
                request.getPhone() != null ? request.getPhone().trim() : null,
                request.getMessage().trim()
        );
        return contactMessageRepository.save(message);
    }

    public List<ContactMessage> getAllMessages() {
        return contactMessageRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional
    public ContactMessage updateStatus(Long id, String status) {
        ContactMessage message = contactMessageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found with id: " + id));
        message.setStatus(status.toUpperCase());
        return contactMessageRepository.save(message);
    }
}
