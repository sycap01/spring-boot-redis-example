package com.example.springbootredisexample;

import com.example.springbootredisexample.entity.Product;
import com.example.springbootredisexample.repository.ProductDao;
import com.example.springbootredisexample.websocket.domain.WebSocketOrderbook;
import com.example.springbootredisexample.websocket.repository.WebSocketOrderbookRepository;
import com.example.springbootredisexample.websocket.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import javax.websocket.DeploymentException;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringBootRedisExampleApplication {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private WebSocketOrderbookRepository webSocketOrderbookRepository;
    private final WebSocketService webSocketService;

    public SpringBootRedisExampleApplication(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }

    @PostMapping
    public List<Product> save(@RequestBody List<Product> product) {

        for (int i = 0; i < product.size(); i++) {
            productDao.save(product.get(i));
        }

        return product;
    }

    @GetMapping
    public List<WebSocketOrderbook> getAllProducts() {
        return webSocketOrderbookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable int id) {
        return productDao.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id) {
        return productDao.deleteProduct(id);
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisExampleApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    void applicaitonReady() throws DeploymentException, IOException, InterruptedException {

        webSocketService.upbitWebSocket();
//        botInitialization.initialize();
    }
}
