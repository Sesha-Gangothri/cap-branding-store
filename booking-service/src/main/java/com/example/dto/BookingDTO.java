package com.example.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class BookingDTO {

    @NotNull(message = "PNR cannot be null")
    @Size(min = 6, max = 6, message = "PNR must be exactly 6 characters")
    private String pnr;

    @NotNull(message = "User ID cannot be null")
    @Positive(message = "User ID must be positive")
    private Long userId;

    @NotNull(message = "Train ID cannot be null")
    @Positive(message = "Train ID must be positive")
    private Long trainId;

    @NotNull(message = "Booking date cannot be null")
    @FutureOrPresent(message = "Date must be today or in the future")
    private LocalDate date;

    @NotNull(message = "Class type cannot be null")
    @Size(min = 1, max = 50, message = "Class type must be between 1 and 50 characters")
    private String classType;

    @NotNull(message = "Number of seats cannot be null")
    @Positive(message = "Number of seats must be positive")
    private int numSeats;

    @NotNull(message = "Status cannot be null")
    @Size(min = 1, max = 20, message = "Status must be between 1 and 20 characters")
    private String status;

    // Getters and setters
    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
