package models;

import java.util.Map;
import java.util.Optional;

public record JsonObject(Map<String, JsonNode> fields) implements JsonNode {

    @Override
    public <T> Optional<T> get(String key, Class<T> type) {
        JsonNode node = fields.get(key);
        return convert(node, type);
    }

    @Override
    public Optional<JsonNode> get(String key) {
        JsonNode node = fields.get(key);
        return convert(node);
    }
}
