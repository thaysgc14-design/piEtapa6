# etapa6
Este repositório contém a versão web do sistema BeeFly, desenvolvido originalmente como uma aplicação Desktop (Java Swing). O projeto foi refatorado como parte da Etapa 6 do Projeto Integrador, com o objetivo de separar as responsabilidades, extrair regras de negócio da interface gráfica e preparar a arquitetura para o ambiente Web.

O sistema permite o gerenciamento básico de uma empresa, incluindo o controle de acesso de usuários e o cadastro e listagem de clientes.
# 🔄 Refatoração e Princípios SOLID
Durante a transição do ambiente Desktop para Web, as seguintes melhorias foram implementadas no código base:

Princípio da Responsabilidade Única (SRP):

As regras de negócio e validações (como checagem de CPF e formatação de datas) foram removidas das antigas telas (CadastroClientes e CadastroUsuario).

A lógica de acesso a dados foi estritamente isolada nas classes ClienteDAO e UsuarioDao.

Correção de Code Smells:

Lógica na UI (God Class): Eliminação das validações de negócio dentro dos eventos de botões (ActionPerformed).

Thread-Safety: Correção das classes DAO. Os objetos PreparedStatement e ResultSet passaram a ser instanciados localmente dentro dos métodos (e não mais como atributos globais da classe), evitando colisões e vazamento de memória em acessos simultâneos na Web.

# 🚀 Funcionalidades
[x] Autenticação de Usuários (Login)

[x] Cadastro de novos Usuários com nível de acesso (Função)

[x] Cadastro de Clientes (Nome, CPF, Data de Nascimento, Telefone)

[x] Listagem de Clientes cadastrados
