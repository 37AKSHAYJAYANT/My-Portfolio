package com.akshay.portfolio.controller;

import com.akshay.portfolio.dto.ApiResponse;
import com.akshay.portfolio.dto.ContactRequest;
import com.akshay.portfolio.entity.ContactMessage;
import com.akshay.portfolio.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ContactMessage>> submitContactMessage(
            @Valid @RequestBody ContactRequest request) {
        ContactMessage saved = contactService.saveMessage(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Thank you! Your message has been received.", saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ContactMessage>>> getAllMessages() {
        List<ContactMessage> messages = contactService.getAllMessages();
        return ResponseEntity.ok(ApiResponse.success("Messages retrieved successfully", messages));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<ContactMessage>> updateMessageStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        ContactMessage updated = contactService.updateStatus(id, status);
        return ResponseEntity.ok(ApiResponse.success("Message status updated to " + status, updated));
    }
}
