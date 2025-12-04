package com.datarango.messaging.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datarango.messaging.dto.ApiResponse;

@RestController
public class HealthController {

  @GetMapping("/")
  public ApiResponse<Object> welcome() {
    return ApiResponse.success("Welcome to Datarango User service", null);
  }

  @GetMapping("/health")
  public ApiResponse<Object> health() {
    return ApiResponse.success("User service is healthy", null);
  }
}