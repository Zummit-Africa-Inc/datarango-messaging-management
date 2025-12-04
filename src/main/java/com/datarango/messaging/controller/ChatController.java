package com.datarango.messaging.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datarango.messaging.dto.ApiResponse;

@RestController
@RequestMapping("/chat")
public class ChatController {

  @PostMapping
  public ResponseEntity<ApiResponse<Object>> createChat() {
    return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("", null));
  }

  @GetMapping
  public ResponseEntity<ApiResponse<Object>> getChats() {
    return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("", null));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<Object>> getChatsByUser() {
    return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("", null));
  }

  @GetMapping("/messages")
  public ResponseEntity<ApiResponse<Object>> getMessages() {
    return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("", null));
  }
}
