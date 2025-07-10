package org.catherine.accountabilitytracker.Entity;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record Goal( @NotBlank(message = "Title is required")
                    String name,  @NotBlank(message = "Date is required" )String targetDate) {
}
