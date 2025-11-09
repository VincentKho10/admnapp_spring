package com.example.admnapp.util;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private int satus;
    private String error;
    
    public ErrorResponse(LocalDateTime timestamp, int satus, String error) {
        this.timestamp = timestamp;
        this.satus = satus;
        this.error = error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public int getSatus() {
        return satus;
    }
    public void setSatus(int satus) {
        this.satus = satus;
    }
    
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
}