package yte.kafka.blog.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfiguration {

    @Bean
    NewTopic cartTopic() {
        return TopicBuilder.name("cart")
                .partitions(10)
                .build();
    }

    @Bean
    NewTopic userTopic() {
        return TopicBuilder.name("user")
                .partitions(5)
                .replicas(1)
                .build();
    }
}
