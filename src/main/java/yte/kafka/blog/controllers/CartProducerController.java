package yte.kafka.blog.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yte.kafka.blog.producer.NativeKafkaProducer;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartProducerController {

    private final NativeKafkaProducer nativeKafkaProducer;

    @GetMapping("/native")
    public void sendNativeMessage() {
        nativeKafkaProducer.sendMessage();
    }
}
