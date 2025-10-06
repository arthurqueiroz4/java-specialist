package models;

import java.util.List;
import java.util.Optional;

public record JsonArray(List<JsonNode> elements) implements JsonNode {
    @Override
    public <T> Optional<T> get(int index, Class<T> type) {
        JsonNode node = elements.get(index);
        return convert(node, type);
    }

    @Override
    public Optional<JsonNode> get(int index) {
        JsonNode node = elements.get(index);
        return convert(node);
    }
}
