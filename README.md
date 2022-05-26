# S109_TopAvanc-ProjSprints
Fac Senai de Tecnologia S109 Tópicos Avançados - Projeto UC Sprints

CURSO: SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS – NOITE
UNIDADE CURRICULAR: S109 – TÓPICOS AVANÇADOS
PROFESSOR: MARCELO BARBOSA SOARES EMAIL: marcelo.barbosa@senairs.edu.br

INTRODUÇÃO
O objetivo de nosso caso prático é o desenvolvimento de aplicações da área de
e-commerce. A aplicação deve dispor de serviços para cadastrar produtos, realizar a compra dos
mesmos, além de integrações junto a outros micro-serviços e mecanismos para processar em
lote, as vendas do sistema.
O grupo está aberto a implementar bem como desejar, mas é interessante desenvolver
usando o conhecimento e ferramentas expostas em sala de aula.
Por fim, o desenvolvimento é feito a partir de métodos ágeis, na qual em cada início de
sprint, será apresentado detalhes mais técnicos de cada feature e assim tirar as dúvidas. Haverá
aulas específicas para a implementação, mas é de uma importância, realizar etapas fora da sala
de aula.

DESENVOLVIMENTO
O desenvolvimento será realizado através das ferramentas que o grupo achar melhor. Será
apresentado em sala de aula, tecnologias em cima da plataforma Java. As apis devem dispor de
documentação.O aluno está aberto a realizar mais implementações que achar importante. A
metodologia será por meio de métodos ágeis, via scrum. Dessa forma, algumas cerimônias do
framework serão usadas, tais como sprints, planejamento da sprint e review da sprint. A lista de
backLog está disposta no final do arquivo, então a cada início de sprint, será definido as histórias
a serem entregues (planejamento da sprint). No final, deve ser mostrado para a turma o que o
grupo entregou(entrega da sprint). Melhorias a serem feitas, devem ser debatidas na review. O
código deve estar em um repositório. O cronograma completo está no plano de ensino da
disciplina.
Papéis
● Scrum Master e PO: Professor
● Dev, TO: Alunos

MÓDULO PRODUTO
Este componente (micro-serviço), é responsável por manipular a entidade Produto, na qual deve
dispor métodos, a fim de fazer manuseá-los. Abaixo, é exposto as api's a serem desenvolvidas,
assim como, suas funcionalidades:
Operação: cadastrarProduto(String nome, float preco)
Funcionalidade: cadastrar um produto, validando se os campos foram preenchidos. Salvar na
memória, na qual deve ser inserido também a data de cadastro e ID
Operação: buscarProdutoId(float idProduto)
Funcionalidade: retornar um produto através de seu id. Caso não exista, voltar o código 204 http.
Operação: listarProdutos()
Funcionalidade: Retornar todos os produtos cadastrados
Operação: comprarProduto(float idProduto, int quantidade)
Funcionalidade: realiza a compra de um produto. Ao ocorrer, deve-se verificar a existência do
produto e se o mesmo existe em estoque, com a quantidade informada. Neste ponto, o aluno tem
que pensar qual melhor estratégia para integrar junto ao Módulo Estoque (conectividade direta ou
BPM).. Caso tenha estoque, deve-se atualizar o mesmo com a quantidade informada, e salvar os
dados da compra na memória, junto com a data da compra. Havendo algum erro, encerra o fluxo.
Abaixo é disposto o fluxograma desta operação.
Comprar Produto: Operação que inicia o fluxo (escolher solução para integração)
Verificar Estoque: Operação que verificar se existe ou não o produto (módulo Estoque)
Atualizar Estoque: Operação que atualiza o estoque (módulo Estoque)
Operação: listarCompras()
Funcionalidade: Retornar todas as compras cadastrados
Operação: executaLoteComprasAcima10()
Funcionalidade: ao ser chamado, deve-se executar uma rotina em lote, escrevendo em arquivo
todas as compras feitas, com valor do produto acima de R$10,00.

MÓDULO ESTOQUE
Este componente (micro-serviço), é responsável por manipular o estoque do sistema, na qual
deve dispor de métodos para verificar se tem ou não tal entidade, além de atualização do mesmo.
Abaixo, é exposto as api's a serem desenvolvidas, assim como, suas funcionalidades:
Operação: verificarEstoque(float idProduto, int quantidade)
Funcionalidade: verifica se produto informado dispõe de quantidade informada. Deve retornar um
boolean.
Operação: atualizarEstoque(float idProduto, int quantidade)
Funcionalidade: atualiza o produto na lista interna do módulo. Caso não exista, crie a entidade em
memória.
BACK LOG
API - cadastro do produto
API - buscar produto por id
API - listar todos os produtos
API - listar todas as compras
API - comprarProduto (sem integração)
API - executaLoteComprasAcima10(sem lote)
API - verificarEstoque
API - atualizarEstoque

INTEGRAÇÃO - comprarProduto (implementação).
LOTE - executaLoteComprasAcima10 (implementação)
DEVOP - criação de container para executar o módulo produto.

SPRINT 1
Data: 23/2 à 23/3
Objetivos:
API - cadastro do produto
API - buscar produto por id
API - listar todos os produtos
API - listar todas as compras
API - comprarProduto (sem integração)

SPRINT 2
Data:
Objetivos:
API - executaLoteComprasAcima10(sem lote)
API - verificarEstoque
API - atualizarEstoque

SPRINT 3
Data:
Objetivos:
INTEGRAÇÃO - comprarProduto (implementação).

SPRINT 4
Data:
Objetivos:
LOTE - executaLoteComprasAcima10 (implementação)
DEVOP - criação de container para executar o módulo produto.
