package yte.kafka.blog.events;

public record CartEvent(String id, String itemId, Double price, Long count) {
}
