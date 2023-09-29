package yte.kafka.blog.producer;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NativeKafkaProducer {

    private final ProducerFactory<String, String> producerFactory;

    public void sendMessage() {
        try(Producer<String, String> producer = producerFactory.createProducer()) {
            producer.initTransactions();
        }

    }
}
