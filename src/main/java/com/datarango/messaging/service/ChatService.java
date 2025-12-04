package com.datarango.messaging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datarango.messaging.repository.ChatRepository;

@Service
public class ChatService {
  @Autowired
  ChatRepository chatRepository;
}
