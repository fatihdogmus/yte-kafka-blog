package yte.kafka.blog.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yte.kafka.blog.producer.NativeCartProducer;
import yte.kafka.blog.producer.SpringCartProducer;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartProducerController {

    private final NativeCartProducer nativeCartProducer;
    private final SpringCartProducer springCartProducer;

    @GetMapping("/native")
    public void sendNativeMessage() {
        nativeCartProducer.sendMessage();
    }

    @GetMapping("/spring")
    public void sendSpringMessage() {
        springCartProducer.sendMessages();
    }
}
