#Sistema de Controle de Despesas:

#Descrição:
Este sistema de controle de despesas em Java permite aos usuários gerenciar suas finanças, incluindo o registro de despesas, pagamentos, tipos de despesas, e usuários. O sistema utiliza conceitos de Programação Orientada a Objetos (POO), como herança, interfaces, polimorfismo, e criptografia de senhas.

#Funcionalidades:
*1. *Entrar Despesa*: Permite que o usuário consiga registrar novas despesas no sistema.
*2. *Anotar Pagamento*: Permite registrar o pagamento de uma despesa qualquer, seja casa, carro ou etc.. E marcar como paga.
*3. *Listar Despesas em Aberto no Período*: Lista todas as despesas que estão em aberto dentro de um período específico (assim, todas que ainda estiverem como não pagas estaram listadas como pagas: false).
*4. *Listar Despesas Pagas no Período*: Lista todas as despesas pagas dentro de um período específico (assim, todas as despesas que já forem pagas estaram listadas como pagas: true).
*5. *Gerenciar Tipos de Despesa*: Permite adicionar, editar, listar e excluir os tipos de despesas.
*6. *Gerenciar Usuários*: Permite cadastrar novos usuários e listar todos os usuários cadastrados (possuíndo senhas criptografadas).

#Estrutura do Código:
O sistema é dividido em várias classes que representam as diferentes entidades e funcionalidades:

*- *Main.java*: Classe principal que contém o método main e os métodos de interação com o usuário.
*- *Despesa.java*: Classe abstrata que define a estrutura de uma despesa.
*- *TransporteDespesa.java*: Uma subclasse da classe Despesa para representar despesas de transporte.
*- *Pagamento.java*: Classe que representa o pagamento de uma despesa.
*- *TipoDespesa.java*: Classe que representa diferentes tipos de despesas.
*- *Usuario.java*: Classe que representa um usuário do sistema.

#Estratégia de Construção:
#1. Programação Orientada a Objetos (POO):
*O sistema foi desenvolvido utilizando os princípios de POO para garantir modularidade, reusabilidade e manutenibilidade do código. Cada entidade principal (como despesas, pagamentos, tipos de despesas, usuários) é representada por uma classe respectiva.

*- *Herança*: A classe Despesa é uma classe abstrata, e suas subclasses herdam seus atributos e métodos.
*- *Polimorfismo*: Métodos como listarDespesas() permitem a manipulação de diferentes tipos de despesas de maneira uniforme.
*- *Interfaces*: Utilizadas para definir comportamentos comuns entre diferentes entidades (se necessário).
*- *Criptografia de Senhas*: Implementada para garantir a segurança dos dados dos usuários.

#2. Controle de Fluxo:
*O fluxo principal do sistema é controlado por um loop do-while que exibe um menu interativo para o usuário e invoca métodos apropriados com base na entrada do usuário.

#3. Persistência de Dados:
*Os dados, como despesas e usuários, são armazenados em listas (ArrayList). Em um cenário de produção, seria ideal implementar persistência em banco de dados para salvar e recuperar informações entre execuções do programa.
