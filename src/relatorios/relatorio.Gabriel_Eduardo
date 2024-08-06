1. Introdução

A classe Menu é uma janela principal de uma aplicação Swing que oferece uma interface gráfica para o gerenciamento de passagens aéreas. Ela permite ao usuário realizar operações como cadastrar aeronaves e voos, fazer reservas, consultar lugares vazios e reservas realizadas, e finalizar o sistema. A classe se conecta a um banco de dados por meio de uma camada de persistência, facilitando a comunicação com o backend da aplicação.

2. Estrutura da Classe

A classe Menu estende JFrame e configura uma interface gráfica com um menu que contém várias opções. As funcionalidades principais são acionadas através de itens de menu, que são gerenciados por um ActionListener interno. A classe possui uma forte integração com o backend através de DAOs (Data Access Objects) para operações de CRUD (Create, Read, Update, Delete).

2.1 Componentes da Classe

Construtor Menu(): Inicializa a interface gráfica e configura a conexão com o banco de dados.
Método initComponents(): Configura a barra de menu e adiciona itens de menu com seus respectivos ActionListener.
Classe Interna GerenciadorBotoes: Implementa ActionListener para gerenciar eventos dos itens de menu.
Métodos Privados:
cadastrarAeronave(): Interface para cadastrar aeronaves.
cadastrarVoo(): Interface para cadastrar voos.
fazerReserva(): Interface para fazer reservas.
consultarLugaresVazios(): Interface para consultar lugares vazios em voos.
consultarReservasRealizadas(): Interface para consultar reservas realizadas.
finalizarSistema(): Fecha a conexão com o banco de dados e encerra o sistema.

3. Funcionamento do Código

3.1 Inicialização
Instância do Banco de Dados:

O construtor Menu() cria uma instância de DatabaseHelper, que é responsável por fornecer acesso aos DAOs (AviaoDAO, VooDAO, PassageiroDAO).
Os DAOs são usados para interagir com o banco de dados, facilitando operações de persistência.
Configuração da Interface Gráfica:

O método initComponents() configura a janela principal, criando uma barra de menu com itens para as principais operações da aplicação.

3.2 Gerenciamento de Ações

A classe GerenciadorBotoes é responsável por lidar com os eventos de ação dos itens de menu. Para cada item de menu, um método específico é chamado:

Cadastrar Aeronave (cadastrarAeronave()):

Exibe um diálogo para inserir informações sobre a aeronave (modelo, fileira, assento).
Cria uma nova instância de Aviao e a salva no banco de dados usando AviaoDAO.
Cadastrar Voo (cadastrarVoo()):

Exibe um diálogo para inserir informações sobre o voo (número, data, hora) e seleciona uma aeronave existente.
Cria uma nova instância de Voo e a salva no banco de dados usando VooDAO.
Fazer Reserva (fazerReserva()):

Exibe um diálogo para inserir informações sobre a reserva (nome, CPF, fileira, assento) e seleciona um voo existente.
Cria uma nova instância de Passageiro e adiciona a reserva ao voo selecionado, atualizando o banco de dados.
Consultar Lugares Vazios (consultarLugaresVazios()):

Permite consultar os lugares vazios em voos, mas a implementação específica da interface ainda não está completa.
Consultar Reservas Realizadas (consultarReservasRealizadas()):

Permite consultar as reservas realizadas em voos, mas a implementação específica da interface ainda não está completa.
Finalizar Sistema (finalizarSistema()):

Fecha a conexão com o banco de dados e encerra a aplicação.

4. Interação com o Backend

4.1 Camada de Persistência
DatabaseHelper:

Fornece métodos para acessar os DAOs que realizam operações de CRUD no banco de dados.
É crucial para a inicialização dos DAOs e fechamento da conexão com o banco de dados.
DAOs (AviaoDAO, VooDAO, PassageiroDAO):

Implementam operações específicas para Aviao, Voo e Passageiro.
São responsáveis por interagir com as tabelas correspondentes no banco de dados.

5. Considerações Finais
A classe Menu é uma implementação sólida para a interface de gerenciamento de passagens aéreas, integrando eficientemente a GUI com a camada de persistência. A arquitetura baseada em DAOs e o uso de DatabaseHelper fornecem uma abordagem organizada para o gerenciamento de dados. No entanto, a implementação de algumas funcionalidades (como consulta de lugares vazios e reservas realizadas) precisa ser concluída para garantir uma funcionalidade completa.1. Introdução

A classe Menu é uma janela principal de uma aplicação Swing que oferece uma interface gráfica para o gerenciamento de passagens aéreas. Ela permite ao usuário realizar operações como cadastrar aeronaves e voos, fazer reservas, consultar lugares vazios e reservas realizadas, e finalizar o sistema. A classe se conecta a um banco de dados por meio de uma camada de persistência, facilitando a comunicação com o backend da aplicação.

2. Estrutura da Classe

A classe Menu estende JFrame e configura uma interface gráfica com um menu que contém várias opções. As funcionalidades principais são acionadas através de itens de menu, que são gerenciados por um ActionListener interno. A classe possui uma forte integração com o backend através de DAOs (Data Access Objects) para operações de CRUD (Create, Read, Update, Delete).

2.1 Componentes da Classe

Construtor Menu(): Inicializa a interface gráfica e configura a conexão com o banco de dados.
Método initComponents(): Configura a barra de menu e adiciona itens de menu com seus respectivos ActionListener.
Classe Interna GerenciadorBotoes: Implementa ActionListener para gerenciar eventos dos itens de menu.
Métodos Privados:
cadastrarAeronave(): Interface para cadastrar aeronaves.
cadastrarVoo(): Interface para cadastrar voos.
fazerReserva(): Interface para fazer reservas.
consultarLugaresVazios(): Interface para consultar lugares vazios em voos.
consultarReservasRealizadas(): Interface para consultar reservas realizadas.
finalizarSistema(): Fecha a conexão com o banco de dados e encerra o sistema.

3. Funcionamento do Código

3.1 Inicialização
Instância do Banco de Dados:

O construtor Menu() cria uma instância de DatabaseHelper, que é responsável por fornecer acesso aos DAOs (AviaoDAO, VooDAO, PassageiroDAO).
Os DAOs são usados para interagir com o banco de dados, facilitando operações de persistência.
Configuração da Interface Gráfica:

O método initComponents() configura a janela principal, criando uma barra de menu com itens para as principais operações da aplicação.

3.2 Gerenciamento de Ações
A classe GerenciadorBotoes é responsável por lidar com os eventos de ação dos itens de menu. Para cada item de menu, um método específico é chamado:

Cadastrar Aeronave (cadastrarAeronave()):

Exibe um diálogo para inserir informações sobre a aeronave (modelo, fileira, assento).
Cria uma nova instância de Aviao e a salva no banco de dados usando AviaoDAO.
Cadastrar Voo (cadastrarVoo()):

Exibe um diálogo para inserir informações sobre o voo (número, data, hora) e seleciona uma aeronave existente.
Cria uma nova instância de Voo e a salva no banco de dados usando VooDAO.
Fazer Reserva (fazerReserva()):

Exibe um diálogo para inserir informações sobre a reserva (nome, CPF, fileira, assento) e seleciona um voo existente.
Cria uma nova instância de Passageiro e adiciona a reserva ao voo selecionado, atualizando o banco de dados.
Consultar Lugares Vazios (consultarLugaresVazios()):

Permite consultar os lugares vazios em voos, mas a implementação específica da interface ainda não está completa.
Consultar Reservas Realizadas (consultarReservasRealizadas()):

Permite consultar as reservas realizadas em voos, mas a implementação específica da interface ainda não está completa.
Finalizar Sistema (finalizarSistema()):

Fecha a conexão com o banco de dados e encerra a aplicação.

4. Interação com o Backend

4.1 Camada de Persistência
DatabaseHelper:

Fornece métodos para acessar os DAOs que realizam operações de CRUD no banco de dados.
É crucial para a inicialização dos DAOs e fechamento da conexão com o banco de dados.
DAOs (AviaoDAO, VooDAO, PassageiroDAO):

Implementam operações específicas para Aviao, Voo e Passageiro.
São responsáveis por interagir com as tabelas correspondentes no banco de dados.

5. Considerações Finais
A classe Menu é uma implementação sólida para a interface de gerenciamento de passagens aéreas, integrando eficientemente a GUI com a camada de persistência. A arquitetura baseada em DAOs e o uso de DatabaseHelper fornecem uma abordagem organizada para o gerenciamento de dados. No entanto, a implementação de algumas funcionalidades (como consulta de lugares vazios e reservas realizadas) precisa ser concluída para garantir uma funcionalidade completa.
