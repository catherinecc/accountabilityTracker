package org.catherine.accountabilitytracker.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/")
    public String login() {
        // This method can be used to handle login requests
        // For now, it simply returns a welcome message
        return "Welcome to the Accountability Tracker!";
    }
    @GetMapping("/token")
    public CsrfToken getToken(HttpServletRequest request){

        CsrfToken csrf = (CsrfToken) request.getAttribute("_csrf");
        System.out.println(">>>>>>>"+csrf.toString());
        return csrf;
    }
}
