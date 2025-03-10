package com.example.dto;

import java.util.List;

public class TrainDTO {
    private Long trainId;

    private String trainNumber;

    private String trainName;

    private String trainType;

    private String source;

    private String destination;

    private List<SeatAvailabilityDTO> seatAvailabilities;

    private List<ScheduleDTO> schedules;

    private List<FareDTO> fares;

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<SeatAvailabilityDTO> getSeatAvailabilities() {
        return seatAvailabilities;
    }

    public void setSeatAvailabilities(List<SeatAvailabilityDTO> seatAvailabilities) {
        this.seatAvailabilities = seatAvailabilities;
    }

    public List<ScheduleDTO> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleDTO> schedules) {
        this.schedules = schedules;
    }

    public List<FareDTO> getFares() {
        return fares;
    }

    public void setFares(List<FareDTO> fares) {
        this.fares = fares;
    }
}
