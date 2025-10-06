package parser;

import lexer.Token;
import lexer.TokenType;
import models.JsonArray;
import models.JsonNode;
import models.JsonObject;
import models.JsonValue;

import java.util.*;

public class JsonParser {
    private final List<Token> tokens;
    private int pos = 0;

    public JsonParser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public JsonNode parse() {
        return parseValue();
    }

    private JsonNode parseValue() {
        Token token = current();

        return switch (token.type()) {
            case LEFT_BRACE -> parseObject();
            case LEFT_BRACKET -> parseArray();
            case STRING, NUMBER, BOOLEAN, NULL -> {
                pos++;
                yield new JsonValue(parsePrimitive(token));
            }
            default -> throw new IllegalArgumentException("Unexpected token: " + token);
        };
    }

    private JsonObject parseObject() {
        consume(TokenType.LEFT_BRACE);
        Map<String, JsonNode> fields = new LinkedHashMap<>();

        while (current().type() != TokenType.RIGHT_BRACE) {
            String key = expect(TokenType.STRING).value();
            consume(TokenType.COLON);
            JsonNode value = parseValue();
            fields.put(key, value);

            if (current().type() == TokenType.COMMA) {
                consume(TokenType.COMMA);
            }
        }

        consume(TokenType.RIGHT_BRACE);
        return new JsonObject(fields);
    }

    private JsonArray parseArray() {
        consume(TokenType.LEFT_BRACKET);
        List<JsonNode> elements = new ArrayList<>();

        while (current().type() != TokenType.RIGHT_BRACKET) {
            elements.add(parseValue());
            if (current().type() == TokenType.COMMA) {
                consume(TokenType.COMMA);
            }
        }

        consume(TokenType.RIGHT_BRACKET);
        return new JsonArray(elements);
    }

    private Object parsePrimitive(Token token) {
        return switch (token.type()) {
            case STRING -> token.value();
            case NUMBER -> token.value().contains(".")
                    ? Double.parseDouble(token.value())
                    : Integer.parseInt(token.value());
            case BOOLEAN -> Boolean.parseBoolean(token.value());
            case NULL -> null;
            default -> throw new IllegalArgumentException("Invalid primitive: " + token);
        };
    }

    private Token current() {
        if (pos >= tokens.size()) {
            throw new IllegalStateException("Unexpected end of input");
        }
        return tokens.get(pos);
    }

    private Token expect(TokenType type) {
        Token token = current();
        if (token.type() != type) {
            throw new IllegalArgumentException("Expected " + type + " but found " + token.type());
        }
        pos++;
        return token;
    }

    private void consume(TokenType type) {
        expect(type);
    }
}
