package lexer;

import java.util.ArrayList;
import java.util.List;

public class JsonTokenizer {
    private final String input;
    private int pos = 0;

    public JsonTokenizer(String input) {
        this.input = input.trim();
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();

        while (pos < input.length()) {
            char c = input.charAt(pos);

            switch (c) {
                case '{' -> {
                    tokens.add(new Token(TokenType.LEFT_BRACE, null));
                    pos++;
                }
                case '}' -> {
                    tokens.add(new Token(TokenType.RIGHT_BRACE, null));
                    pos++;
                }
                case '[' -> {
                    tokens.add(new Token(TokenType.LEFT_BRACKET, null));
                    pos++;
                }
                case ']' -> {
                    tokens.add(new Token(TokenType.RIGHT_BRACKET, null));
                    pos++;
                }
                case ':' -> {
                    tokens.add(new Token(TokenType.COLON, null));
                    pos++;
                }
                case ',' -> {
                    tokens.add(new Token(TokenType.COMMA, null));
                    pos++;
                }
                case '"' -> tokens.add(readString());
                case ' ', '\n', '\t', '\r' -> pos++; // ignora whitespace
                default -> {
                    if (Character.isDigit(c) || c == '-') {
                        tokens.add(readNumber());
                    } else if (input.startsWith("true", pos) || input.startsWith("false", pos)) {
                        tokens.add(readBoolean());
                    } else if (input.startsWith("null", pos)) {
                        tokens.add(readNull());
                    } else {
                        throw new IllegalArgumentException("Caractere inesperado: " + c);
                    }
                }
            }
        }
        return tokens;
    }

    private Token readString() {
        pos++;
        var sb = new StringBuilder();
        while (pos < input.length() && input.charAt(pos) != '"') {
            sb.append(input.charAt(pos++));
        }
        pos++;
        return new Token(TokenType.STRING, sb.toString());
    }

    private Token readNumber() {
        StringBuilder sb = new StringBuilder();
        while (pos < input.length() && (Character.isDigit(input.charAt(pos)) || input.charAt(pos) == '.' || input.charAt(pos) == '-')) {
            sb.append(input.charAt(pos++));
        }
        return new Token(TokenType.NUMBER, sb.toString());
    }

    private Token readBoolean() {
        if (input.startsWith("true", pos)) {
            pos += 4;
            return new Token(TokenType.BOOLEAN, "true");
        } else {
            pos += 5;
            return new Token(TokenType.BOOLEAN, "false");
        }
    }

    private Token readNull() {
        pos += 4;
        return new Token(TokenType.NULL, "null");
    }
}
