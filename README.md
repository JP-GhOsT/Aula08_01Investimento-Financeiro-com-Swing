# 💰 Aula08_01_Investimento

Aplicação desktop desenvolvida em **Java com Swing** para simular o rendimento de uma aplicação financeira de acordo com o valor investido, prazo de aplicação e tipo de investimento selecionado.

O sistema permite ao usuário informar o valor inicial, o prazo em meses e escolher entre diferentes modalidades de investimento. A partir dessas informações, a aplicação calcula o montante utilizando a fórmula de **juros compostos**.

---

## 📋 Sumário

- [Sobre o Projeto](#-sobre-o-projeto)
- [Objetivo](#-objetivo)
- [Funcionalidades](#-funcionalidades)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Classes e Interfaces](#-classes-e-interfaces)
- [Taxas de Investimento](#-taxas-de-investimento)
- [Fórmula Utilizada](#-fórmula-utilizada)
- [Validações](#-validações)
- [Interface do Sistema](#-interface-do-sistema)
- [Como Executar](#-como-executar)
- [Participantes](#-participantes)
- [Conceitos Aplicados](#-conceitos-aplicados)

---

## 📌 Sobre o Projeto

O **Aula08_01_Investimento** é uma aplicação desenvolvida em Java utilizando a biblioteca gráfica **Swing**.

O sistema foi desenvolvido com uma separação entre a camada de interface gráfica e a camada responsável pelas regras de negócio.

A interface permite que o usuário forneça os dados necessários para realizar uma simulação de investimento e visualizar o resultado diretamente na janela da aplicação.

---

## 🎯 Objetivo

O principal objetivo do projeto é desenvolver uma aplicação gráfica capaz de:

- Receber o valor inicial de uma aplicação;
- Receber o prazo da aplicação em meses;
- Permitir a seleção do tipo de investimento;
- Aplicar a taxa correspondente ao investimento escolhido;
- Calcular o montante utilizando juros compostos;
- Exibir o resultado para o usuário;
- Validar o preenchimento dos campos antes da realização do cálculo;
- Limpar o resultado quando os dados utilizados no cálculo forem alterados.

O projeto também tem como objetivo aplicar conceitos de **Programação Orientada a Objetos**, **interfaces**, **separação de responsabilidades** e desenvolvimento de interfaces gráficas com **Java Swing**.

---

## ⚙️ Funcionalidades

### 💵 Informar valor inicial

O usuário pode informar o valor que deseja aplicar no investimento através de um `JTextField`.

O campo aceita valores numéricos e ponto decimal.

Exemplo:

    Valor Inicial: 1000

---

### 📅 Informar prazo

O usuário deve informar o período da aplicação em meses.

O campo aceita apenas valores numéricos.

Exemplo:

    Prazo: 12

---

### 📊 Selecionar tipo de investimento

O sistema possui um `JComboBox` que permite selecionar uma das modalidades disponíveis:

- Poupança;
- CDI;
- Tesouro Direto.

Cada opção possui uma taxa mensal diferente.

---

### 🧮 Calcular rendimento

Ao clicar no botão:

    Calcular Rendimento

o sistema utiliza os dados informados pelo usuário para realizar o cálculo do montante.

O cálculo é realizado pela classe `Aplicacao`, responsável pela regra de negócio.

---

### ⚠️ Validação dos campos

Antes de realizar o cálculo, o sistema verifica se os campos obrigatórios foram preenchidos.

Caso algum campo esteja vazio, uma mensagem de aviso é exibida:

    Preencha todos os campos antes de calcular.

---

### 🧹 Limpeza automática do resultado

Depois que um cálculo é realizado, caso o usuário altere:

- o valor inicial;
- o prazo;
- ou o tipo de investimento;

o resultado anterior é automaticamente removido.

Isso evita que um resultado antigo seja confundido com os novos dados informados.

---

### 🔢 Validação dos campos numéricos

Os campos de entrada utilizam `KeyListener` para controlar os caracteres digitados.

O campo de valor permite:

- números;
- ponto decimal.

O campo de prazo permite:

- números inteiros.

Caracteres inválidos são bloqueados durante a digitação.

---

## 🛠️ Tecnologias Utilizadas

O projeto foi desenvolvido utilizando:

- **Java**
- **Java Swing**
- **JFrame**
- **JLabel**
- **JTextField**
- **JButton**
- **JComboBox**
- **ActionListener**
- **KeyListener**
- **Programação Orientada a Objetos**
- **Interfaces Java**
- **Math.pow()**
- **Eclipse IDE**

---

## 📁 Estrutura do Projeto

O projeto está organizado em dois pacotes principais:

    src
    │
    ├── business
    │   ├── IAplicacao.java
    │   └── Aplicacao.java
    │
    └── view
        ├── Formulario.java
        └── Principal.java

### `business`

Contém as classes responsáveis pelas regras de negócio e pelo cálculo do investimento.

### `view`

Contém as classes responsáveis pela interface gráfica e inicialização da aplicação.

Essa organização ajuda a separar a lógica de cálculo da interface apresentada ao usuário.

---

# 🧩 Classes e Interfaces

## `IAplicacao`

A interface `IAplicacao` define o método responsável pelo cálculo do rendimento.

    public interface IAplicacao {

        void calcularRendimento(
            float valorAplicado,
            int prazo,
            float taxa
        );
    }

### Responsabilidade

Define o contrato que a classe responsável pelo cálculo deve seguir.

O método recebe:

| Parâmetro | Tipo | Descrição |
|---|---|---|
| `valorAplicado` | `float` | Valor inicial do investimento |
| `prazo` | `int` | Prazo da aplicação em meses |
| `taxa` | `float` | Taxa mensal utilizada no cálculo |

---

## `Aplicacao`

A classe `Aplicacao` implementa a interface `IAplicacao`.

    public class Aplicacao implements IAplicacao

### Responsabilidade

É a principal classe da camada `business`.

Ela realiza o cálculo do montante utilizando juros compostos e armazena o resultado para posteriormente ser consultado pela interface gráfica.

O resultado pode ser obtido através do método:

    getResultado()

### Cálculo

A classe utiliza:

    Math.pow()

para realizar a potência necessária na fórmula de juros compostos.

---

## `Formulario`

A classe `Formulario` pertence ao pacote `view` e é responsável pela construção e funcionamento da interface gráfica.

### Componentes utilizados

A tela possui:

- `JFrame` para a janela principal;
- `JLabel` para textos e resultado;
- `JTextField` para entrada do valor e prazo;
- `JComboBox` para seleção do investimento;
- `JButton` para executar o cálculo.

### Responsabilidades

A classe:

1. Cria a janela;
2. Configura os componentes gráficos;
3. Recebe os dados do usuário;
4. Identifica o investimento selecionado;
5. Define a taxa correspondente;
6. Envia os dados para a classe `Aplicacao`;
7. Obtém o resultado;
8. Exibe o resultado na tela;
9. Realiza as validações dos campos;
10. Limpa o resultado quando os dados são alterados.

---

## `Principal`

A classe `Principal` é responsável por iniciar a aplicação.

Exemplo:

    public class Principal {

        public static void main(String[] args) {

            new Formulario();

        }
    }

### Responsabilidade

Seu objetivo é servir como ponto de entrada da aplicação Java.

A partir dela, o `Formulario` é instanciado e a interface gráfica é apresentada ao usuário.

---

# 📈 Taxas de Investimento

As taxas utilizadas pelo sistema são:

| Investimento | Taxa mensal |
|---|---:|
| Poupança | 0,38% |
| CDI | 0,53% |
| Tesouro Direto | 0,65% |

> **Observação:** as taxas utilizadas no projeto foram definidas conforme o enunciado da atividade e não representam necessariamente as taxas reais praticadas pelo mercado financeiro.

---

# 🧮 Fórmula Utilizada

O sistema utiliza a fórmula de juros compostos:

    M = C × (1 + i)^t

Onde:

| Símbolo | Significado |
|---|---|
| `M` | Montante final |
| `C` | Capital inicial |
| `i` | Taxa de juros |
| `t` | Tempo da aplicação |

Como as taxas são informadas em porcentagem, o sistema divide a taxa por `100` antes de utilizá-la no cálculo.

Em Java:

    resultado = valorAplicado *
            (float) Math.pow(
                    1 + (taxa / 100),
                    prazo
            );

### Exemplo

Considerando:

    Valor aplicado: R$ 1.000,00
    Prazo: 12 meses
    Investimento: CDI
    Taxa: 0,53% ao mês

O sistema calcula o montante utilizando:

    M = 1000 × (1 + 0,0053)^12

---

# 🔐 Validações

O sistema possui algumas validações para evitar erros durante a utilização.

### Campos obrigatórios

Antes de realizar o cálculo, o sistema verifica se:

- O valor inicial foi preenchido;
- O prazo foi preenchido.

Caso algum deles esteja vazio, o cálculo não é realizado.

---

### Valores inválidos

Caso seja informado algum valor que não possa ser convertido para o tipo numérico esperado, o sistema apresenta uma mensagem de erro.

    Digite valores numéricos válidos.

---

### Alteração dos dados

Quando o usuário altera qualquer campo utilizado no cálculo, o resultado anterior é limpo.

Essa funcionalidade impede que o resultado exibido represente dados diferentes dos atualmente preenchidos.

---

# 🖥️ Interface do Sistema

A interface gráfica é construída utilizando componentes da biblioteca **Java Swing**.

A tela possui:

    +---------------------------------------+
    |       Calculadora de Rendimento       |
    +---------------------------------------+
    |                                       |
    | Valor Inicial:    [______________]    |
    |                                       |
    | Prazo:            [______________]    |
    |                                       |
    | Taxa:             [ CDI          ▼ ]  |
    |                                       |
    | Resultado: R$ 1.065,43                |
    |                                       |
    |       [ Calcular Rendimento ]         |
    |                                       |
    +---------------------------------------+

---

# ▶️ Como Executar

### 1. Clonar o projeto

Clone o repositório utilizando o Git:

    git clone URL_DO_REPOSITORIO

### 2. Abrir no Eclipse

Abra o projeto utilizando o **Eclipse IDE**.

### 3. Verificar a estrutura

Confirme se os pacotes estão organizados da seguinte maneira:

    business
    view

### 4. Executar

Localize:

    view
    └── Principal.java

Clique com o botão direito sobre `Principal.java` e selecione:

    Run As
    → Java Application

A janela da calculadora será aberta.

---

# 👥 Participantes

- **Gustavo Sena de Souza** - [GitHub](https://github.com/gustavosena025-dotcom) | [Linkedin](https://www.linkedin.com/in/gustavo-sena-ads-ia/)
- **João Paulo Zimmermann Matsui** - [GitHub](https://github.com/JP-GhOsT) | [Linkedin](https://linkedin.com/in/joaomatsui)
- **Robson dos Santos Damasceno Lisboa** - [GitHub](https://github.com/RobsonDamsceno) | [Linkedin](https://www.linkedin.com/in/robson-damasceno-b35954356/)

---

## 📚 Conceitos Aplicados

Durante o desenvolvimento foram utilizados conceitos de:

- Programação Orientada a Objetos;
- Interfaces;
- Encapsulamento;
- Separação entre interface e regra de negócio;
- Desenvolvimento de aplicações desktop;
- Java Swing;
- Tratamento de exceções;
- Eventos de interface gráfica;
- Validação de entrada de dados;
- Cálculos matemáticos;
- Juros compostos.

---

## 📌 Considerações Finais

O projeto **Aula08_01_Investimento** demonstra a construção de uma aplicação desktop em Java capaz de realizar uma simulação de investimento através de uma interface gráfica.

A separação entre os pacotes `view` e `business` permite organizar o projeto de forma que a interface gráfica fique responsável pela interação com o usuário, enquanto a classe `Aplicacao` concentra a lógica relacionada ao cálculo do investimento.
