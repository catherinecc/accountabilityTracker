package org.catherine.accountabilitytracker.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
//for disabling csrf protection
//CSRF - a malicious user can use a browser cookie to perform actions on behalf of a user without their consent.
// This happens because browsers dont check the origin of a request before attaching cookies to it.
//by default, Spring Security enables CSRF protection for all HTTP methods except GET, HEAD, TRACE, and OPTIONS.

//In spring security, on login a JSession is created and a cookie is sent to the browser.

    /* Just keep in mind of what you need to do
     * 1. choose whether or not yiu need csrf protection
     * 2. define the url patterns for which you want to enable authorization
     * 3. define what needs to be done for the urls that dont match
     * 4. define session management. For code you can refer here*/

    //why we autowire UserDetailsService?
    // 1. we need no custom field values to be set explicitly in bean creation
    // 2. we can use the custom implementation which we have created in the project
    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain defaultSecurity(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ✅ disable CSRF for APIs
                .authorizeHttpRequests(auth ->  { auth
                        .requestMatchers( "/token/**").authenticated()
                        .anyRequest().permitAll();
                });

        http.httpBasic(Customizer.withDefaults()); // ✅ use HTTP Basic authentication
        http.sessionManagement(session -> session
                .sessionCreationPolicy(org.springframework.security.config.http.SessionCreationPolicy.STATELESS)); // ✅ use stateless session management




        return http.build();
    }
    
    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder()); // no encoding for simplicity
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }



}
