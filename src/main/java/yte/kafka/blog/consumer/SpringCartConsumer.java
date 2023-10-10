package yte.kafka.blog.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import yte.kafka.blog.events.CartEvent;

@Controller
@RequiredArgsConstructor
public class SpringCartConsumer {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "cart")
    @SneakyThrows
    public void consumeCartEvent(final String event) {
        CartEvent cartEvent = objectMapper.readValue(event, CartEvent.class);
        System.out.println(cartEvent);
    }
}
