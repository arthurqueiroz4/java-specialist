package lexer;

public record Token(TokenType type, String value) {
    @Override
    public String toString() {
        return type + (value != null ? "(" + value + ")" : "");
    }
}