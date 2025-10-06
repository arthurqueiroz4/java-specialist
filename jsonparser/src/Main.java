import lexer.JsonTokenizer;
import models.JsonArray;
import parser.JsonParser;

public class Main {
    public static void main(String[] args) {
        String json = """
                    {
                        "name":"Arthur",
                        "age":21,
                        "isPresent":true,
                        "nested":{"inner":"inner"},
                        "tags":["java","golang"],
                        "arrayNested":[{"index":1}, {"index":2}]
                    }
                """;

        // Tokenize
        JsonTokenizer tokenizer = new JsonTokenizer(json);
        var tokens = tokenizer.tokenize();

        // Parse
        JsonParser parser = new JsonParser(tokens);
        var root = parser.parse();

        System.out.println("=== JSON Root Node ===\n");

        // Acessando campos simples
        root.get("name").ifPresent(n -> System.out.println("Name: " + n.value()));
        root.get("age").ifPresent(a -> System.out.println("Age: " + a.value()));
        root.get("isPresent").ifPresent(a -> System.out.println("IsPresent: " + a.value()));

        // Acessando objeto aninhado
        root.get("nested").flatMap(nested -> nested.get("inner")).ifPresent(inner -> System.out.println("Nested.inner: " + inner.value()));

        // Acessando array simples
        root.get("tags", JsonArray.class)
                .ifPresent(tags -> {
                    System.out.println("\nTags:");
                    tags.elements().forEach(t -> System.out.println(" - " + t.value()));
                });

        // Acessando array de objetos aninhados
        root.get("arrayNested", JsonArray.class)
                .ifPresent(arrayNested -> {
                    System.out.println("\nArray Nested:");
                    arrayNested.elements().forEach(node ->
                            node.get("index").ifPresent(index -> System.out.println(" - index: " + index.value()))
                    );
                });

        System.out.println("\n=== Fim do teste ===");
    }
}
