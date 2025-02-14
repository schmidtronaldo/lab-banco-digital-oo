# Criando um Banco Digital com Java e Orientação a Objetos

## Bootcamp Bradesco-Java Cloud Native 

### Desafio: 
- Considerando nosso conhecimento no domínio bancário, iremos abstrair uma solução Orientada a Objetos em Java. 
- Para isso, vamos interpretar o seguinte cenário:
“Um banco oferece aos seus clientes dois tipos de contas (corrente e poupança), as quais possuem as funcionalidades de depósito, saque e transferência (entre contas da própria instituição).”
- Utilizaremos a abordagem dos pilares de POO :
Encapsulamento, Herança, Polimorfismo e Abstração .


### Explicação das Melhorias:

- Adicionamos métodos para gerenciar contas e clientes, além de buscar contas e clientes por número e CPF, respectivamente.

- Adicionamos CPF e senha ao cliente.

- Adicionamos um método para verificar a senha.

- Criamos um terminal interativo onde o usuário pode criar clientes, acessar contas e realizar operações bancárias.

### Funcionalidades Implementadas

- O usuário pode criar um cliente com nome, CPF e senha.

- Ao criar um cliente, ele tem opçao de escolher entre uma conta corrente ou uma conta poupança e fazer um depósito inicial de no minimo $500.

- O usuário pode acessar sua conta inserindo o nome ou cpf  e a senha.

- O usuário pode sacar, depositar, transferir e imprimir o extrato da conta.

### Próximos Passos

- Implementar um menu específico para administradores, onde eles possam gerenciar clientes e contas.

- Adicionar validações para evitar erros, como saldo insuficiente para saque ou transferência.

- Implementar persistência de dados para que as informações não sejam perdidas ao fechar o programa.

- Verificar se o CPF já está cadastrado antes de criar um novo cliente.

- Validar o formato do CPF.

- Garantir que o valor inicial da conta seja um número válido (positivo e maior ou igual a 500).

- Criar um menu específico para administradores, onde eles possam:

> Listar todos os clientes e contas.

> Remover clientes ou contas.

> Verificar informações relacionadas aos clientes

- Visualizar o saldo total do banco.(apenas administradores)

- Salvar os dados dos clientes e contas em um arquivo (por exemplo, JSON ou CSV) para que as informações não sejam perdidas ao fechar o programa e futuramente conectar em um banco de dados.

- Carregar os dados ao iniciar o programa.

- Criptografar senhas antes de armazená-las.

- Implementar um limite de tentativas de login para evitar ataques de força bruta.

- Adicionar data e hora das transações

- Criar uma interface gráfica (usando JavaFX, Swing ou outra biblioteca) para tornar o sistema mais amigável.

- Armazenar e exibir um histórico de transações (saques, depósitos e transferências) para cada conta.

- Implementar taxas para a conta corrente (por exemplo, taxa de manutenção).

- Adicionar rendimentos para a conta poupança (por exemplo, juros mensais).

### Conclusão

 Gostei muito de desenvolver este projeto e sei que ele tem muito a ser explorado e me ajudou a entender os pilares principais da orientação a objetos e como a linguagem java funciona.
 Agradeço a todos os professores e o banco Bradesco e Digital Innovation One pela iniciativa.
 Há muito a ser melhorado e estou feliz com o resultado até aqui...
 Obrigado.