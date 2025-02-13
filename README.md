# Criando um Banco Digital com Java e Orientação a Objetos

## Bootcamp Bradesco-Java Cloud Native 

### Desafio: 
- Considerando nosso conhecimento no domínio bancário, iremos abstrair uma solução Orientada a Objetos em Java. 
- Para isso, vamos interpretar o seguinte cenário:
“Um banco oferece aos seus clientes dois tipos de contas (corrente e poupança), as quais possuem as funcionalidades de depósito, saque e transferência (entre contas da própria instituição).”
- Utilizaremos a abordagem dos pilares de POO :
Encapsulamento, Herança, Polimorfismo e Abstração .


### Explicação das Melhorias:

- Banco.java: Adicionamos métodos para gerenciar contas e clientes, além de buscar contas e clientes por número e CPF, respectivamente.

- Cliente.java: Adicionamos CPF e senha ao cliente.

- Conta.java: Adicionamos um método para verificar a senha.

- Main.java: Criamos um terminal interativo onde o usuário pode criar clientes, acessar contas e realizar operações bancárias.

### Funcionalidades Implementadas

- Criação de Cliente: O usuário pode criar um cliente com nome, CPF e senha.

- Criação de Contas: Ao criar um cliente, uma conta corrente e uma poupança são automaticamente criadas com um depósito inicial de $500.

- Acesso à Conta: O usuário pode acessar sua conta inserindo o número da conta e a senha.

- Operações Bancárias: O usuário pode sacar, depositar, transferir e imprimir o extrato da conta.

### Próximos Passos

- Adicionar Funcionalidades de Administrador: Implementar um menu específico para administradores, onde eles possam gerenciar clientes e contas.

- Validações Adicionais: Adicionar validações para evitar erros, como saldo insuficiente para saque ou transferência.

- Persistência de Dados: Implementar persistência de dados para que as informações não sejam perdidas ao fechar o programa.