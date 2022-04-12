package com.example.springbootredisexample.websocket.service;

import com.example.springbootredisexample.websocket.exchange.upbit.UpbitWebSocketClientEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class WebSocketClientEndpointService {
    private final UpbitWebSocketClientEndpoint upbitWebSocketClientEndpoint;

    public UpbitWebSocketClientEndpoint startUpbitWebsocket() {
        return upbitWebSocketClientEndpoint;
    }

}
