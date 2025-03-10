package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@FeignClient(name = "train-service")
@Component
public interface TrainServiceClient {
    @GetMapping("/trains/{trainId}/availability")
    int getTrainAvailability(
            @PathVariable long trainId,
            @RequestParam LocalDate date,
            @RequestParam String classType
    );

    @PostMapping("/trains/{trainId}/availability/increase")
    int increaseTrainAvailability(
            @PathVariable long trainId,
            @RequestParam LocalDate date,
            @RequestParam String classType,
            @RequestParam int numSeats
    );

    @GetMapping("/trains/{trainName}/id")
    Long getTrainIdByName(@PathVariable String trainName);
}