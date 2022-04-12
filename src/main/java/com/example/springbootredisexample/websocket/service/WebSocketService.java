package com.example.springbootredisexample.websocket.service;

import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.util.HashMap;

@Service
public interface WebSocketService {
    Session upbitWebSocket();
}
