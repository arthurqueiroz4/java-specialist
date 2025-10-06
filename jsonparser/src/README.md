# Relatório de Aprendizado — Parser de JSON em Java
Durante este desafio, desenvolvi um parser de JSON do zero usando Java. O objetivo foi entender como um interpretador funciona internamente, passando pelas etapas de análise léxica (lexer), análise sintática (parser) e modelagem dos dados.
O projeto está dividido em três pacotes principais: lexer, parser e models.
Me baseei na biblioteca Jackson para ter algum rumo de como tal atividade é feita no mundo real.

## Lexer

O pacote lexer é responsável por tokenizar o JSON.
A ideia é percorrer o texto caractere por caractere e gerar uma lista de tokens, que são unidades menores e mais fáceis de interpretar (como {, }, :, ,, strings, números, etc.).
Essa etapa serviu para simplificar a leitura no parser e me fez entender melhor como linguagens de programação processam texto.
Aprendi a lidar com detalhes como escapes de string, números decimais e ignorar espaços em branco.

## Parser

No pacote parser, transformo a lista de tokens em objetos Java que representam a estrutura do JSON.
Usei recursão para montar objetos e arrays de forma hierárquica, o que me ajudou a entender como a pilha de chamadas é usada naturalmente para navegar em estruturas aninhadas.
Essa parte foi a mais desafiadora, principalmente para lidar com a ordem dos tokens e garantir que cada tipo (objeto, array, string, número, boolean, null) fosse interpretado corretamente.

## Models

O pacote models contém as interfaces e classes que representam os valores do JSON, como JsonObject, JsonArray e JsonValue.
Cada classe implementa uma interface comum (JsonNode), o que facilita manipular os dados de forma genérica.

## O que aprendi

Esse projeto me ajudou a entender conceitos que normalmente parecem “mágicos” quando usamos bibliotecas prontas.

Aprendi na prática:

como funciona um lexer e um parser recursivo;

como representar estruturas de dados complexas em Java;

a importância de dividir responsabilidades em pacotes e classes;

e como tratar erros e exceções em análises de texto.
