package yte.kafka.blog.consumer;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NativeKafkaCartConsumer {

    private final ConsumerFactory<String, String> consumerFactory;
    private Consumer<String, String> consumer;

    @PostConstruct
    public void initConsumer() {
        consumer = consumerFactory.createConsumer();
        consumer.subscribe(List.of("cart"));
    }
}
