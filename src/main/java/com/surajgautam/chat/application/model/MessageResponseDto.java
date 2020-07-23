package com.surajgautam.chat.application.model;

import java.time.LocalDateTime;

public class MessageResponseDto {
    private String message;
    private LocalDateTime createdTime;

    public MessageResponseDto() {
    }

    public MessageResponseDto(String message, LocalDateTime createdTime) {
        this.message = message;
        this.createdTime = createdTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}
