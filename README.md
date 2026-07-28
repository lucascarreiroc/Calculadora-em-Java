# 🧮 Calculadora Java

Uma calculadora simples desenvolvida em Java, com interface gráfica construída em **Swing**.

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/status-conclu%C3%ADdo-brightgreen)
![License](https://img.shields.io/badge/licen%C3%A7a-MIT-blue)

## ✨ Funcionalidades

- Operações básicas: adição, subtração, multiplicação e divisão
- Inversão de sinal (±) e porcentagem (%)
- Tratamento de erro para divisão por zero
- Interface gráfica escura, no estilo das calculadoras nativas

## 🖥️ Preview

> Interface com visor destacado e botões numéricos, de operação e de função organizados em grade.

```
┌─────────────────────────┐
│                     0    │
├───────┬───────┬──────┬───┤
│   C   │   ±   │  %   │ / │
├───────┼───────┼──────┼───┤
│   7   │   8   │  9   │ * │
├───────┼───────┼──────┼───┤
│   4   │   5   │  6   │ - │
├───────┼───────┼──────┼───┤
│   1   │   2   │  3   │ + │
├───────┼───────┼──────┼───┤
│   0   │   .   │  =   │   │
└───────┴───────┴──────┴───┘
```

## 🚀 Como executar

Pré-requisito: **JDK 17 ou superior** instalado.

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/calculadora.git
cd calculadora/src

# Compile
javac CalculadoraGUI.java

# Execute
java CalculadoraGUI
```

## 🛠️ Tecnologias

- **Java 21**
- **Swing** (interface gráfica)

## 📁 Estrutura do projeto

```
calculadora/
└── src/
    └── CalculadoraGUI.java
```

## 📌 Próximos passos

- [ ] Adicionar suporte a operações com teclado
- [ ] Histórico de cálculos
- [ ] Testes unitários para a lógica de cálculo

## 📄 Licença

Este projeto está sob a licença MIT. Sinta-se livre para usar e modificar.
