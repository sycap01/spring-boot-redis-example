package com.example.springbootredisexample.websocket.repository;

import com.example.springbootredisexample.entity.FlipCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlipCurrencyRepository extends JpaRepository<FlipCurrency, Long> {

    List<FlipCurrency> findByFlipExchange_FlipExchangeName(String exchangeName);
}
