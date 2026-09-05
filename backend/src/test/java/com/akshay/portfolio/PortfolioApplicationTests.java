package com.akshay.portfolio;

import com.akshay.portfolio.dto.ContactRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class PortfolioApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetProjects_ReturnsSeededProjects() throws Exception {
        mockMvc.perform(get("/api/projects"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.data", hasSize(greaterThanOrEqualTo(4))))
                .andExpect(jsonPath("$.data[0].title", notNullValue()));
    }

    @Test
    void testGetProjectsByCategory() throws Exception {
        mockMvc.perform(get("/api/projects?category=SOFTWARE_ENGINEERING"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.data[*].category", everyItem(is("SOFTWARE_ENGINEERING"))));
    }

    @Test
    void testSubmitContactMessage_Success() throws Exception {
        ContactRequest request = new ContactRequest(
                "Jane Doe",
                "janedoe@example.com",
                "(555) 123-4567",
                "Hi Akshay, I saw your portfolio and would love to connect about a full-stack role!"
        );

        mockMvc.perform(post("/api/contact")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.data.name", is("Jane Doe")))
                .andExpect(jsonPath("$.data.email", is("janedoe@example.com")))
                .andExpect(jsonPath("$.data.status", is("UNREAD")));
    }

    @Test
    void testSubmitContactMessage_ShortMessage_Success() throws Exception {
        ContactRequest shortMsgRequest = new ContactRequest(
                "Akshay Kumar",
                "akshay@example.com",
                "+91 9876543210",
                "Hello" // short message allowed
        );

        mockMvc.perform(post("/api/contact")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(shortMsgRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.data.name", is("Akshay Kumar")))
                .andExpect(jsonPath("$.data.phone", is("+91 9876543210")))
                .andExpect(jsonPath("$.data.message", is("Hello")));
    }

    @Test
    void testSubmitContactMessage_ValidationFailure() throws Exception {
        ContactRequest invalidRequest = new ContactRequest(
                "", // empty name
                "invalid-email", // invalid email
                "",
                "" // empty message
        );

        mockMvc.perform(post("/api/contact")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success", is(false)))
                .andExpect(jsonPath("$.data.name", notNullValue()))
                .andExpect(jsonPath("$.data.email", notNullValue()))
                .andExpect(jsonPath("$.data.message", notNullValue()));
    }
}
