Sou o aluno Matheus Teles e fiquei encarregado com a parte de fazer o front-end do projeto.Quando criamos o grupo,fui designado ao papel de líder e documentador,no entanto,devido a algumas situações ao qual meu grupo foi passando acabei mudando de função e nessa reta final acabei me consolidando na tarefa, auxiliando também meus companheiros em suas atividades.Assim como todo front-end, fiquei encarregado de desenvolver a interface gráfica da aplicação de passagens aéreas,incorporando elementos do javafx e ormlite.Devido a dificuldade que não só eu como outros do meu grupo sentiram de criar interfaces no scene builder busquei outros meios,tentando e pesquisando até mesmo sobre java swing e outros recursos para desenvolvê-las.A seguir, vou apresentar algumas das minhas participações no projeto:

Primeiramente, com o código fornecido pelo Gabriel Eduardo (back-end)- que já estava no formato MVC mas ele não havia feito o commit - eu acabei comitando o código que ele me enviou já incorporando partes do ormlite em algumas classes como voo e avião e desenvolvendo os DAO para encapsular a lógica do acesso ao banco de dados.Assim, a parte de cadastro de aeronave e voos já estava funcional.Além disso na classe menu já desenvolvi o padrão da interface com a segmentação nas operações: cadastro de aeronaves, cadastro de voos, reserva, consultar lugares vazios, consultar reservas realizadas e finalizar o sistema.Conforme commit abaixo:

https://github.com/poo-ec-2024-1/g2/commit/147b53f35002f6d68924536cee5d8b036042735f

Após isso vieram commits buscando desenvolver a parte do cadastro da reserva com a atualização de algumas classes como a menu, menucontroller, databasehelper, passageiro, voo e a criação de um DAO para a classe passageiro.Em particular, ampliei o uso do ormlite para a classe passageiro.Então, a operação de fazer a reserva passava a ser funcional:

https://github.com/poo-ec-2024-1/g2/commit/a487441edad8c28758a6e1aa919183f122ee2399
https://github.com/poo-ec-2024-1/g2/commit/504f5249c2318c504b14f47b2c6f9ebb4837f449

Em sentido mais técnico, os diálogos usados para entrada de dados (JOptionPane.showConfirmDialog) permitem ao usuário inserir informações necessárias para as operações. Estes diálogos utilizam componentes básicos como JTextField, JLabel, e JComboBox.Para o cadastro de aeronave e voo utilizamos o JTextField para a entrada de dados e o JComboBox para a seleção de modelos.Já na parte da reserva incluimos a seleção de voo com o JComboBox e a entrada dos dados pessoas e do assento.

No entanto, não conseguimos uma lógica para as operações consultar lugares vazios e consultar reservas realizadas que apesar de aparecerem na interface estão sem realizar nenhuma operação.


Por fim, conclui-se que o sistema está projetado para ser intuitivo e fácil de usar conforme definimos como objetivo, com menus claramente divididos por funcionalidade e diálogos para inserção de dados. No entanto, algumas funcionalidades estão apenas esboçadas e necessitam de um maior desenvolvimento, como a consulta de lugares vazios e a listagem das reservas realizadas.Para garantir uma melhor experiência ao usuário, é essencial concluir as funcionalidades que faltam.
