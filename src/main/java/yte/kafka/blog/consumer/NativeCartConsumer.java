package yte.kafka.blog.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.core.ConsumerFactory;
import yte.kafka.blog.events.CartEvent;

import java.time.Duration;
import java.util.List;

//@Service
@RequiredArgsConstructor
public class NativeCartConsumer {

    private final ConsumerFactory<String, String> consumerFactory;
    private final ObjectMapper objectMapper;
    private Consumer<String, String> consumer;

    @PostConstruct
    public void initConsumer() {
        consumer = consumerFactory.createConsumer();
        consumer.subscribe(List.of("cart"));
        Thread runnerThread = new Thread(this::executeMainLoop);
        runnerThread.start();
    }

    @SneakyThrows
    private void executeMainLoop() {
        while (true) {
            try {
                ConsumerRecords<String, String> messages = consumer.poll(Duration.ofSeconds(1));
                for (ConsumerRecord<String, String> record : messages.records("cart")) {
                    CartEvent cartEvent = objectMapper.readValue(record.value(), CartEvent.class);
                    //Process message
                    System.out.println(cartEvent);
                }
            } catch (IllegalStateException e) {
                break;
            }
            Thread.sleep(1000);
        }
    }

    @PreDestroy
    public void closeConsumer() {
        consumer.close(Duration.ofSeconds(5));
    }
}
