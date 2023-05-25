# Sistema para Gerenciamento de Estoque

## Equipe:

    Eduardo Serpa Cavalcante
    Lilian Fabrício Marques Neves
    Lucas Arthur Ribeiro Mascarenhas
    Matheus Feitosa Ramos
    Ronaldo Cândido dos Santos 
    
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
## Visão Geral do Sistema

O sistema de gerenciamento de estoque objetiva o gerenciamento de produtos de uma loja de departamento. Essa loja de departamento vende produtos dos tipos: roupas (feminina, masculina e infantil), calçados, artigos de casa, acessórios, eletrônicos e perfumes. 

    (i) identificação;
    (ii) especificação;
    (iii) tamanho;
    (iv) cor;
    (v) marca;
    (vi) preço;
    (vii) tipo
    (viii) categoria
    (ix) fabricante;
    (x) fornecedor;

Cada atividade possui as seguintes informações:

    (i) item;
    (ii) localidade;
    (iii) movimentação;
    (iv) data de entrada;
    (v) data de saída;
    (vi) Quantidade disponível.

## Requisitos Funcionais

   
| Func.  | Título | Descrição   |
| ------ | ------ | ----------- |
| 1  | Produtos | Permitir a criação e remoção de informações referentes aos produtos, movimentações e funcionários/responsáveis; Permitir que novos produtos adicionados tenham como base uma classe master com o método - Polimorfismo   |
| 2  | Informações do produto | Permitir a edição de informações referentes aos produtos, movimentações e funcionários/responsáveis; As informações dos produtos precisam ter um serial(id) de identificação que está integrado com a classe abstrata do produto - Interface   |
| 3  | Localidade do produto | Permitir a associação de produto a uma localidade do estoque   |
| 4  | Alteração dos status | “Em estoque”, “Sem estoque”, “quantidade” etc.   |
| 5  | Consultar produtos | Permitir consultas de informações;   |
| 6  | Relatório dos produtos | O sistema deve fornecer um relatório de entrada, saída do produto   |
| 7  | Gerenciamento de Usuários | Cadastro de usuário como uma classe base, e as classes derivadas (quais os tipos de usuário); - Herança O sistema deve permitir o intercâmbio de usuários entre lojas para realização de get.   |
| 8  | Gerenciamento de pagamentos | O sistema deve suportar o gerenciamento de pagamento dos produtos   |
| 9  | Controle de acessos | O sistema deve suportar controle de acesso através de usuário e senha com possibilidade para recuperação de senha;   |
| 10  | Undo/redo | Permitir operações de undo e redo de informações referentes aos produtos,movimentações e funcionários/responsáveis.   |

-------------------------------------------------------------------------------------------------------------------------------------------------------------------
## Classes

    App
    
        # Funções: 
        
        main;
        
        startOptions: Função de Apoio para main:
        
                        Input dos Dados
        
        msgErroOpcoes: Tratamento de Erro de Entrada: 
        
                        Opção Inválida
        
        msgErroDados: Tratamento de Erro de Entrada: 
        
                        Tipo de Dado Inválido
    
    
    Base (Interface)
        
        # Funções:
        
        M_Inicial: Função de Apoio para editar;
        
        adicionar: Adição de Dados;
        
        editar: Alterar Detalhes dos Dados Cadastrados;
        
        imprimir: Impressão dos Dados.
    
    
    Funcionarios (Classe Abstrata/Superclasse)
    
        # Construtor: Funcionarios(int id, String nome, String email, long telefone, long cpf, int cargo).
        
        # Funções: 
        
        imprimir (Metodo Abstrato): Impressão dos Dados de um Funcionario;
    
        M_Inicial: Função de Apoio para editar;
    
        editar: Alterar Detalhes de um Funcionario.
    
    
    Gerenciamento (Array List - Produtos)
    
        # Funções: 
        
        adicionarProdutos: Adição de um Produto no Array List;
        
        imprimirProdutos: Percorrer o Array List Imprimindo as Informações de cada Produto;
        
        editarProdutos: Encontra o ID Desejado no Array List para Alterar Detalhes de um Produto;
        
        removerProduto: Encontra o ID Desejado no Array List para Remoção de um Produto;
        
        correcaoId: Checa se o ID do Novo Produto ja se Encontra no Array List antes de Adiciona-lo.
    
    
    GerenciamentoFuncionarios (Array List - Funcionarios)
    
        # Funções:
        
        imprimirFuncionarios: Percorrer o Array List Imprimindo as Informações de cada Tipo de Funcionario;
        
        editarFuncionarios: Encontra o ID Desejado no Array List para Alterar Detalhes de um Funcionario;
        
        removerfuncionarios: Encontra o ID Desejado no Array List para Remoção de um Funcionario;
        
        correcaoId: Checa se o ID do Novo Funcionario ja se Encontra no Array List antes de Adiciona-lo;
        
        M_Inicial: Função de Apoio para gerenciamentoCargo;
        
        gerenciamentoCargo: Adição de um Novo Funcionario baseado no Tipo do Funcionario no Array List.
    
    
    GerenciamentoMovimentacao (Array List - Movimentação)
    
        # Funções:
        
        adicionarMovimentacao: Adição de uma Movimentação no Array List;
        
        imprimirMovimentacao: Percorrer o Array List Imprimindo as Informações de cada Movimentação;
        
        editarMovimentacao: Encontra o ID Desejado no Array List para Alterar Detalhes de uma Movimentação;
        
        correcaoId: Checa se o ID da Nova Movimentação ja se Encontra no Array List antes de Adiciona-la.
        
    
    Gerente (Subclasse de Funcionarios)
    
        # Construtor: Gerente(int id, String nome, String email, long telefone, long cpf, int cargo, int pesSuperv).
        
        # Funções:  
        
        getpessoasSupervisionadas: Retorna o Valor da Quantidade de Pessoas Supervisionadas daquele Gerente;
    
        imprimir (Sobrescrita de Metodo): Impressão dos Dados de um Gerente.
    
    
    Login
    
        # Funções: 
        
        add_login: Função para Cadastrar Novo Login;
        
        recSenha(): Função para Recuperar Senha;
        
        acesso() Função para Acessar o Sistema.
        
        
    Movimentacao (Implementa Base)
    
        # Funções: 
        
        getCategoriaString: Função de Apoio para imprimir;
        
        imprimir: Impressão dos Dados de uma Movimentação;
    
        adicionar: Adição de uma Movimentação;
    
        CategoriaProduto: Função de Apoio para adicionar e editar;
    
        M_Inicial: Função de Apoio para editar;
    
        editar: Alterar Detalhes de uma Movimentação.


    Pagamento
    
        # Funções: 
        
        setAtriCCred: Função para Atributos do Cartão de Credito;
        
        setAtriCDeb: Função para Atributos do Cartão de Debito;
        
        M_Inicial: Função de Apoio para setPagamento;
        
        setPagamento: Função Principal para Pagamentos.
        
        
    Produtos (Implementa Base)
    
        # Funções: 
        
        getCategoriaString: Função de Apoio para imprimir;
        
        imprimir: Impressão dos Dados de um Produto;
        
        CategoriaProduto: Função de Apoio para adicionar e editar;
        
        adicionar: Adição de um Produto;
        
        remover_produto: Remoção de um Produto;
        
        M_Inicial: Função de Apoio para editar_produto;
        
        editar: Alterar Detalhes de um Produto.
        
 
    Vendedor (Subclasse de Funcionarios)
    
        # Construtor: Vendedor(int id, String nome, String email, long telefone, long cpf, int cargo, int metaVendas).
        
        # Funções:  
        
        getpessoasSupervisionadas: Retorna o Valor da Meta de Vendas daquele Vendedor;
    
        imprimir (Sobrescrita de Metodo): Impressão dos Dados de um Vendedor.
        
        
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
## Tratamento de Exceções
    
    Algumas Exceções mais Simples eram Tratadas pelo Switch e pela Função input.nextLine, 
    dessa forma ate o presente momento so foi Identificada uma Exceção em todo o projeto comum na maioria das classes 
    
    # InputMismatchException 
    
    Sendo tratada na Função Main e em algumas das Funções dos Array List.
         
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
## Lista dos Code Smells    

    Duplicated Code
    
        # Similaridade entre duas expressões em dois métodos da mesma classe:
            
            Gerenciamento: removerProduto(), editarProdutos()
            
            GerenciamentoFuncionarios: removerfuncionarios(), editarFuncionarios()
            
            Pagamento: setAtriCCred(), setAtriCDeb()
            
        # Semelhança entre duas expressões em subclasses:
        
            Gerente e Vendedor
            
        # Semelhança entre códigos em duas classes não relacionadas:
        
            Produtos e Movimentacao: CategoriaProduto(), getCategoriaString()
            
            Gerenciamento, GerenciamentoFuncionarios, GerenciamentoMovimentacao: correcaoId()
            
        # Similaridade entre a lógica condicional aplicada em todo o sistema para lidar com um objeto nulo:
        
            Não existe esse Tratamento Atualmente
    
    Long Method
    
        # A quantidade de instrução switch para despachar e manipular a solicitação:
        
            Pagamento: setPagamento()
            
            Produtos e Movimentacao: getCategoriaString()
    
    Speculative Generality
    
        # O nome de um método não revela sua finalidade:
        
            Pagamento: setAtriCCred()e setAtriCDeb()
         
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
## Padrões de Projeto Implementados
    
    Extract Method
    
        Gerenciamento
        
        GerenciamentoFuncionarios
        
        Pagamento
        
    Extract Class  
    
        TipoProduto
        
    State    
    
        As seguintes classes foram criadas: 
        
            GerencimentoEstado; (Classe de Transição)
            Estado; (Interface)
            EstadoDisponivel; 
            EstadoPoucasUnidades; 
            EstadoSemEstoque; 
            
        Para realizar a transição de estado do sistema em relação a classe Produtos.   
        
        
    # Modificações: 
        
        remover_produto - Excluida pois se tornou inutil com a remoção de produto no array list
        
        buscaId - adicionado ao Gerenciamento e GerenciamentoFuncionarios (Extract Method)
        
        setAtributosCartaoCredito e setAtributosCartaoDebito unificadas (Extract Method)
        
        getCategoriaString e CategoriaProduto unificadas e movidas pra uma nova classe (Extract Class)
        
        Long Method e Speculative Generality - Corrigidas        
         
