# 🚍 Sistema de Gerenciamento de Rotas de Transporte

Este projeto em Java simula um sistema de **consulta de rotas de transporte público** (como ônibus, trem e metrô), utilizando como estrutura de dados uma **lista duplamente encadeada**.

O objetivo é **filtrar as rotas de acordo com o tipo de transporte ou região atendida**, armazenar os dados dinamicamente, e permitir a exibição tanto em ordem normal quanto reversa.

---

## 🧠 Lógica do Funcionamento

### 1. **Modelagem dos dados com `No`**

Cada rota de transporte é representada por um **objeto da classe `No`**, que funciona como um **nó da lista duplamente encadeada**. Cada nó contém:

- `id`: Identificador da linha de transporte.
- `nomeLinha`: Nome da linha (ex: Linha Azul).
- `tipoTransporte`: Tipo (Ônibus, Metrô, Trem).
- `regiaoAtendida`: Região onde essa linha opera.
- `anterior`: Referência ao **nó anterior** da lista.
- `proximo`: Referência ao **nó seguinte** da lista.

Essa estrutura forma uma **sequência de elementos conectados para frente e para trás**, permitindo percursos em ambas as direções.

---

### 📄 2. Leitura dos dados com `LeitorArquivo`

Antes de montar a lista, os dados são lidos de um arquivo chamado `rotas_de_transportes.txt`. Cada linha representa uma rota de transporte, separada por ponto e vírgula:

```java
String[] partes = linha.split(";");
```

Com base nas partes (id, nome da linha, tipo de transporte e região), é criado um novo nó `No`, que será **inserido dinamicamente** na lista duplamente encadeada.

A inserção só ocorre se os dados da linha **corresponderem ao filtro escolhido pelo usuário**.

---

### 🏗️ 3. Estrutura com `ListaDuplamenteEncadeada`

Para armazenar os dados de forma dinâmica e flexível, foi implementada uma **lista duplamente encadeada**, onde **cada nó aponta para o próximo e também para o anterior**.

---

#### 🧱 Composição da estrutura

- `inicio`: Referência para o primeiro nó da lista.
- `fim`: Referência para o último nó da lista.

Essa estrutura permite:

- Inserção sequencial.
- Percurso da lista do início ao fim **(ordem normal)**.
- Percurso do fim ao início **(ordem reversa)**.

---

#### ➕ Como funciona a inserção?

A lógica de inserção adiciona os novos nós **ao final da lista**, mantendo a ordem de leitura do arquivo.

##### 🧠 Código simplificado:

```java
public void inserir(String id, String nomeLinha, String tipoTransporte, String regiaoAtendida) {
    No novo = new No(id, nomeLinha, tipoTransporte, regiaoAtendida);

    if (inicio == null) {
        inicio = fim = novo; // Primeiro nó da lista
    } else {
        fim.proximo = novo;
        novo.anterior = fim;
        fim = novo; // Atualiza o último elemento
    }
}
```

---

#### 🔄 Exemplo visual com 3 elementos:

```text
[inicio] ← [Rota 1] ⇄ [Rota 2] ⇄ [Rota 3] → [fim]
```

Cada nova rota é ligada ao fim da lista, mantendo a sequência. O ponteiro `fim` é sempre atualizado para o último nó.

---

### 🔍 4. Exibição das rotas

Após a construção da lista, o sistema permite exibir as rotas de duas formas:

#### 🔸 Em ordem normal (do início ao fim):

```java
No atual = inicio;
while (atual != null) {
    // Exibe dados
    atual = atual.proximo;
}
```

#### 🔹 Em ordem inversa (do fim ao início):

```java
No atual = fim;
while (atual != null) {
    // Exibe dados
    atual = atual.anterior;
}
```

Isso é possível graças à estrutura **duplamente encadeada**, onde cada nó sabe tanto quem é seu próximo quanto quem é seu anterior.

---

### 🧹 5. Liberação da lista

Ao final da execução, os ponteiros entre os nós são quebrados para **liberar a memória**:

```java
public void liberarLista() {
    No atual = inicio;
    while (atual != null) {
        No temp = atual;
        atual = atual.proximo;
        temp.anterior = null;
        temp.proximo = null;
    }
    inicio = fim = null;
}
```

---

### 🧑‍💻 6. Interação com o usuário em `Main`

A classe `Main` controla o fluxo principal da aplicação:

1. Exibe um menu com opções de filtro:
   - Filtrar por **tipo de transporte**.
   - Filtrar por **região atendida**.

2. Lê a entrada do usuário.
3. Passa o filtro para o `LeitorArquivo`.
4. Exibe as rotas encontradas na ordem direta e reversa.
5. Libera a memória utilizada.

---

## 🔄 Fluxo Lógico Resumido

```text
Arquivo .txt
   ↓
Leitura linha por linha
   ↓
Criação de nós com os dados filtrados
   ↓
Inserção em uma lista duplamente encadeada
   ↓
Usuário escolhe exibição em ordem direta ou reversa
   ↓
Liberação da memória da lista
```

---

## 🎯 Por que usar lista **duplamente encadeada**?

Optou-se por uma lista duplamente encadeada para:

- **Permitir percorrer em duas direções**, útil para exibir rotas de diferentes formas.
- Manter **inserção dinâmica** sem limitar o tamanho.
- **Refinar o aprendizado sobre estruturas de dados**, como ponteiros duplos, alocação dinâmica e gerenciamento de memória.

Essa abordagem favorece a prática de **conceitos fundamentais de algoritmos**, como encadeamento, navegação reversa e controle de fluxo.
