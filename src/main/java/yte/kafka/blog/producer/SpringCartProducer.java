package yte.kafka.blog.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import yte.kafka.blog.events.CartEvent;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SpringCartProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void sendMessages() {
        CartEvent cartEvent = new CartEvent(UUID.randomUUID().toString(), "item_id_1", 250D, 3L);
        kafkaTemplate.err
        kafkaTemplate.send("cart", objectMapper.writeValueAsString(cartEvent));
    }
}
