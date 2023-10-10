package yte.kafka.blog.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;
import yte.kafka.blog.events.CartEvent;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NativeCartProducer {

    private final ProducerFactory<String, String> producerFactory;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void sendMessage() {
        Producer<String, String> producer = producerFactory.createProducer();
        CartEvent cartEvent = new CartEvent(UUID.randomUUID().toString(), "item_id_1", 250D, 3L);
        producer.send(new ProducerRecord<>("cart", objectMapper.writeValueAsString(cartEvent)));
    }
}
