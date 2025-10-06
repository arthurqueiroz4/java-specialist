package models;

import java.util.Optional;

public interface JsonNode {
    default <T> Optional<T> get(String key, Class<T> type) {
        return Optional.empty();
    }

    default Object value() {
        System.out.println(this instanceof JsonValue);
        if (this instanceof JsonValue(Object value)) {
            return value;
        }
        return null;
    }

    default Optional<JsonNode> get(String key) {
        return Optional.empty();
    }

    default <T> Optional<T> get(int index, Class<T> type) {
        return Optional.empty();
    }

    default Optional<JsonNode> get(int index) {
        return Optional.empty();
    }

    @SuppressWarnings("unchecked")
    default <T> Optional<T> convert(JsonNode node, Class<T> type) {
        if (node == null) return Optional.empty();
        if (node instanceof JsonValue)
            return Optional.of((T) node.value());
        return type.isInstance(node) ? Optional.of((T) node) : Optional.empty();
    }

    default Optional<JsonNode> convert(JsonNode node) {
        return node != null ? Optional.of(node) : Optional.empty();
    }
}
