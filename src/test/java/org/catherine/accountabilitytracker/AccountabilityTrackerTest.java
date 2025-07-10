package org.catherine.accountabilitytracker;

import org.catherine.accountabilitytracker.Controllers.AccountabilityController;
import org.catherine.accountabilitytracker.security.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountabilityController.class) // Controller class to be tested
@Import(SecurityConfig.class) // Import the SecurityConfig to apply security configurations during tests

public class AccountabilityTrackerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UserDetailsService userDetailsService;

    @Test
    public void testAddGoal() throws Exception {
        mockMvc.perform(post("/accountability/")
                .contentType("application/json")
                .content("{\"name\":\"Test Goal\", \"targetDate\":\"2023-12-31\"}"))
                .andExpect(status().isCreated());
        // This method will be used to test the addGoal endpoint
        // You can use mockMvc to perform requests and verify responses
        // For example, you can create a mock Goal object and send it in a POST request
        // Then verify that the response status is CREATED (201)

        // Example code to be implemented here
    }




}
