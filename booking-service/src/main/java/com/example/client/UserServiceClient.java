package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
@Component
public interface UserServiceClient {
    @GetMapping("/users/{username}/id")
    Long getUserIdByUsername(@PathVariable String username);
}