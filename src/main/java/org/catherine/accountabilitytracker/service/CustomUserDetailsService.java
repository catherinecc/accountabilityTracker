package org.catherine.accountabilitytracker.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    Map<String, String> users = Map.of(
            "user", "password",
            "admin", "admin"
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(users.entrySet().stream().anyMatch(e-> e.getKey().equals(username))) {
            return org.springframework.security.core.userdetails.User
                    .withUsername(username)
                    .password(users.get(username))
                    .authorities("ROLE_USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }

    }
}
