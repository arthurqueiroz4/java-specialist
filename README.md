# 🏆 Plano de Estudo e Exercícios Avançados em Java

Este roadmap tem como objetivo se aprofundar em Java e se tornar especialista na linguagem.  
Os desafios estão organizados em níveis progressivos, do médio ao hardcore.  

Cada atividade descreve:
- **O que fazer**
- **Conceitos explorados**
- **O que você vai aprender**

---

## 🔹 Nível 1 – Fundamentos Avançados
Explorar recursos modernos da linguagem e consolidar boas práticas.

### 1. Mini-parser JSON/XML
- **O que fazer:**  
  Implementar um parser básico para JSON **ou** XML sem usar bibliotecas externas.  
  - Suportar objetos aninhados.  
  - Suportar arrays/listas.  
  - Converter String → Estrutura de objetos em Java.  
  - Extra: implementar serialização (Java Object → String JSON/XML).  

- **Conceitos explorados:**  
  - Manipulação de Strings.  
  - Recursão.  
  - Estruturas imutáveis vs mutáveis.  
  - API de I/O (`Reader`, `Writer`, `InputStream`).  

- **Você vai aprender:**  
  Como lidar com parsing manual, como funcionam serializadores e por que bibliotecas como Jackson/Gson são tão importantes.  

---

### 2. Streams e Lambdas Avançados
- **O que fazer:**  
  Resolver problemas de manipulação de dados usando apenas `Streams` e `Collectors`.  
  - Criar estatísticas (média, soma, contagem).  
  - Agrupamento de objetos (`groupingBy`).  
  - Particionamento de listas (`partitioningBy`).  
  - Criar `Collector` customizado (ex: para transformar em árvore).  

- **Conceitos explorados:**  
  - Programação funcional em Java.  
  - Imutabilidade.  
  - Pipelines de dados.  

- **Você vai aprender:**  
  Pensar de forma funcional em Java e usar `Streams` para escrever código declarativo, limpo e expressivo.  

---

## 🔹 Nível 2 – Reflexão e Metaprogramação
Aprender a manipular código em tempo de execução.

### 3. Sistema de Plugins
- **O que fazer:**  
  Criar um sistema que carregue classes em runtime de um diretório `/plugins`.  
  - Carregar `.class` dinamicamente.  
  - Usar `Class.forName` e `Method.invoke`.  
  - Executar métodos de objetos sem conhecê-los em tempo de compilação.  

- **Conceitos explorados:**  
  - ClassLoader.  
  - Reflection.  
  - Modularidade.  

- **Você vai aprender:**  
  Como funcionam frameworks que permitem extensibilidade (ex: Spring Boot com starters, Maven com plugins).  

---

### 4. Mini-framework de Injeção de Dependência
- **O que fazer:**  
  Criar um container simples de DI (Dependency Injection).  
  - Usar anotações `@Inject` e `@Component`.  
  - Resolver dependências automaticamente com Reflection.  
  - Suportar escopos `singleton` e `prototype`.  

- **Conceitos explorados:**  
  - Annotations.  
  - Ciclo de vida de objetos.  
  - Reflection avançado.  

- **Você vai aprender:**  
  Como funcionam frameworks como Spring e Guice por baixo dos panos.  

---

## 🔹 Nível 3 – Concorrência e Paralelismo
Dominar programação concorrente em Java.

### 5. Produtor-Consumidor thread-safe
- **O que fazer:**  
  Implementar uma `BlockingQueue` simples.  
  - Métodos `put` (bloqueia se cheio) e `take` (bloqueia se vazio).  
  - Usar `wait()` e `notifyAll()`.  

- **Conceitos explorados:**  
  - `synchronized`.  
  - Comunicação entre threads.  
  - Monitor locks.  

- **Você vai aprender:**  
  A base da programação concorrente em Java, essencial para entender `java.util.concurrent`.  

---

### 6. Framework de Tarefas Assíncronas
- **O que fazer:**  
  Implementar algo parecido com `CompletableFuture`.  
  - Permitir encadear tarefas (`thenApply`, `thenCombine`).  
  - Suporte para exceções.  

- **Conceitos explorados:**  
  - Futures.  
  - Programação assíncrona.  
  - Encadeamento de callbacks.  

- **Você vai aprender:**  
  Como criar abstrações sobre concorrência, fundamentais para arquiteturas reativas.  

---

### 7. Servidor HTTP básico com NIO
- **O que fazer:**  
  Criar um servidor HTTP simples usando `ServerSocket` (bloqueante) ou `NIO` (não bloqueante).  
  - Responder GET e POST.  
  - Suporte múltiplas conexões simultâneas.  

- **Conceitos explorados:**  
  - Sockets.  
  - Non-blocking I/O.  
  - Protocolos de rede.  

- **Você vai aprender:**  
  Como funciona um servidor web na prática e a base de bibliotecas como Netty, Undertow e Tomcat.  

---

## 🔹 Nível 4 – Arquitetura e Persistência
Construir frameworks e sistemas de armazenamento.

### 8. Mini-ORM
- **O que fazer:**  
  Criar um ORM simples (Object-Relational Mapping).  
  - Usar anotações `@Entity`, `@Id`, `@Column`.  
  - Mapear objetos Java para tabelas SQL.  
  - Suportar CRUD básico (`insert`, `findById`, `update`, `delete`).  

- **Conceitos explorados:**  
  - Reflection para mapear campos ↔ colunas.  
  - JDBC para acessar banco.  
  - SQL dinâmico.  

- **Você vai aprender:**  
  Como funcionam frameworks como Hibernate e JPA.  

---

### 9. Cache distribuído simplificado
- **O que fazer:**  
  Criar um cache em memória acessível por rede.  
  - Operações: `SET`, `GET`, `DEL`.  
  - Usar Sockets TCP.  
  - Suportar múltiplos clientes simultâneos.  

- **Conceitos explorados:**  
  - Serialização.  
  - Concorrência em rede.  
  - Protocolos binários simples.  

- **Você vai aprender:**  
  A base de sistemas como Redis e Memcached.  

---

## 🔹 Nível 5 – JVM Hardcore
Explorar o funcionamento interno da JVM.

### 10. Interpretador de Bytecode
- **O que fazer:**  
  Ler arquivos `.class` e interpretar algumas instruções do bytecode.  
  - Carregar constantes.  
  - Executar operações aritméticas simples.  
  - Invocar métodos básicos.  

- **Conceitos explorados:**  
  - Estrutura do `.class` file.  
  - Stack-based machine.  
  - ClassFileParser.  

- **Você vai aprender:**  
  Como a JVM realmente executa código Java.  

---

### 11. Compilador Dinâmico (mini-JIT)
- **O que fazer:**  
  Criar classes dinamicamente em runtime.  
  - Usar `ASM` ou `MethodHandles`.  
  - Gerar métodos em tempo de execução.  

- **Conceitos explorados:**  
  - Bytecode generation.  
  - ClassLoader customizado.  
  - Unsafe API.  

- **Você vai aprender:**  
  Como a JVM faz JIT (Just-In-Time Compilation).  

---

### 12. Motor de Regras (Rules Engine)
- **O que fazer:**  
  Criar um sistema que permita definir regras em uma DSL simples.  
  - Carregar regras de um arquivo.  
  - Avaliar condições dinamicamente.  
  - Executar ações se as condições forem verdadeiras.  

- **Conceitos explorados:**  
  - Parsing.  
  - Reflection.  
  - Execução dinâmica.  

- **Você vai aprender:**  
  A base de motores de regras como Drools e sistemas de business logic complexos.  

---

# 📌 Como usar este roadmap
1. Siga a ordem dos desafios (não pule etapas).  
2. Documente suas soluções no repositório com testes unitários.  
3. Ao finalizar cada nível, escreva um resumo do que aprendeu.  
4. Refatore desafios antigos aplicando novos conceitos.  

---
