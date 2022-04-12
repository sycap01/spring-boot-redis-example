package com.example.springbootredisexample.websocket.service.impl;

import com.example.springbootredisexample.websocket.service.WebSocketClientEndpointService;
import com.example.springbootredisexample.websocket.service.WebSocketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.net.URI;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebSocketServiceImpl implements WebSocketService {

    private final WebSocketClientEndpointService webSocketClientEndpointService;

    @Override
    public Session upbitWebSocket() {
        try {
            String uri = "wss://api.upbit.com/websocket/v1";
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            final Session session = container.connectToServer(webSocketClientEndpointService.startUpbitWebsocket(), URI.create(uri));
            return session;
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
