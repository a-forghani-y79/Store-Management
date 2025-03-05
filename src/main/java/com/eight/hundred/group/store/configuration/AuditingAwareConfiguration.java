package com.eight.hundred.group.store.configuration;

import com.eight.hundred.group.store.dao.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "stringAuditorAware")
public class AuditingAwareConfiguration {
    @Bean
    public AuditorAware<String> stringAuditorAware() {
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = "SYSTEM";
            if (authentication != null && authentication.isAuthenticated()) {
                Object principal = authentication.getPrincipal();
                if (principal instanceof User user) {
                    username = user.getUsername();
                }
            }
            return Optional.of(username);
        };
    }
}
