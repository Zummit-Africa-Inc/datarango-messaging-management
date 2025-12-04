package com.datarango.messaging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datarango.messaging.repository.ReactionRepository;

@Service
public class ReactionService {
  @Autowired
  ReactionRepository reactionRepository;
}
