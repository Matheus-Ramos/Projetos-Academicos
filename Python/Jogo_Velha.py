#Ta-Te-Ti/Tic-Tae-Toe

def cria_matriz():
    matriz = []
    for i in range(3):
        linha = []
        for j in range(3):
            linha.append('_')
        matriz.append(linha)
    return matriz

def imprime_matriz(matriz):
    for i in range(3):
        print("|",end = "")
        for j in range(3):
            if j == 3 - 1:
                print(matriz[i][j],end="")
            else:
                print(matriz[i][j],end="")
            print("|",end = "")
        print()

def transposta_matriz(matriz):#faz a transposta da matriz
    m = []
    for j in range(3):
        linha = []
        for i in range(3):
            linha.append(matriz[i][j])
        m.append(linha)
    return m

def diagonal_matriz(matriz):#cria a matriz com as diagonais
    d = []
    l1 = [matriz[0][0], matriz[1][1], matriz[2][2]]
    l2 = [matriz[0][2], matriz[1][1], matriz[2][0]]
    d.append(l1)
    d.append(l2)
    return d
          
def conversor(p):#pegar a posição
    if (p <= 3):
        i = 0
        j = p - 1 
    elif (p <= 6):
        i = 1
        j = p - 4  
    else:
        i = 2
        j = p - 7   
    return i, j
    
def vitoria(matriz):#checar vitoria
    #horizontal//#vertical//#diagonal
    emp = 0
    for i in range(len(matriz)):
        aux1 = matriz[i].count("X")
        aux2 = matriz[i].count("O")
        aux3 = matriz[i].count('_')
        if (aux1 == 3):
            print("O Jogador X venceu!!!")
            return 2#vitoria
        elif (aux2 == 3): 
            print("O Jogador O venceu!!!")
            return 2#vitoria
        else: #ate 3 espaços disponiveis ou empate
            #empate na linha
            if (aux3 == 0):
                emp += 1
    if emp == len(matriz):
        return 1#empate na matriz
    else:
        return 0#ha jogadas possiveis
        

def jogo(matriz, s):#marcar as posições
    flag = False
    while (not flag):
        print()
        print("|1|2|3|","\n|4|5|6|","\n|7|8|9|")
        print()
        pos = input("Escolha a posição para jogar: ")
        if not(pos in '123456789'):
            print("Posição Invalida!!")
            print("Digite Novamente!!")  
        else:
            i, j = conversor(int(pos))
            if(matriz[i][j] == '_'):
                matriz[i][j] = s
                flag = True
            else:
                print("Posição Invalida!!")
                print("Digite Novamente!!")
    #analise da vitoria
    lista = []
    m2 = transposta_matriz(matriz)
    d = diagonal_matriz(matriz)
    lista.append(vitoria(matriz))
    lista.append(vitoria(m2))
    lista.append(vitoria(d))
    aux = lista.count(1)
    if aux == 3:
        print("O jogo Empatou!!")
        return 1, "E"
    else:
        aux = lista.count(2)
        if aux >= 1:
            return 1, s
        else:
            print("Aguardando proxima jogada...")
            return 0, "0"

def entrada():
    #Escolher Simbolo
    while True:
        simb = input("Escolha X ou O, para começar o jogo ")
        if not(simb.upper() == "X" or simb.upper() == "O"):
            print("Entrada Invalida!!")
            print("Digite Novamente!!")
        else:
            print("Voce escolheu:", simb.upper())
            print("O X começa.")
            break
    return simb.upper()

def partida():
    m = cria_matriz()
    print()
    imprime_matriz(m)
    print()
    s = entrada()
    if (s == "X"):
        ss = "O"
        ordem = 1
    else:
        ss = "X"
        ordem = 2
    flag = 0
    while (not flag):
        if ordem == 1:
            try:
                flag, venc = jogo(m, s)
            except (KeyboardInterrupt, ValueError):
                print("O jogo Empatou!!")
                flag, venc = 1, "E"
            else:
                ordem += 1
        else:
            try:
                flag, venc = jogo(m, ss)
            except (KeyboardInterrupt, ValueError):
                print("O jogo Empatou!!")
                flag, venc = 1, "E"
            else:
                ordem -= 1
        imprime_matriz(m)
    return s, ss, venc

def main():
    print("\t#####Bem-Vindo ao Jogo da Velha.#####")
    print()
    n = int(input("Informe o numero de partidas: "))
    i = 1
    tot1 = tot2 = 0
    while (n>0):
        pl1, pl2, venc = partida()
        print()
        print("*******************************************************")
        print("*  Partida:\t", str(i), "\tSimbolo:\tPontuação:    *")
        if (venc == pl1):
            tot1 += 1
        elif (venc == pl2):
            tot2 += 1
        print("*  Jogador 1:\t\t", pl1, "\t\t", tot1, "pontos     *")
        print("*  Jogador 2:\t\t", pl2, "\t\t", tot2, "pontos     *")
        print("*******************************************************")
        n -= 1
        i += 1
    if (tot1 > tot2):
        print("*  O Jogador 1 foi o Grande Vencedor.                 *")
    elif (tot2 > tot1):
        print("*  O Jogador 2 foi o Grande Vencedor.                 *")
    else:
        print("*  Ambos os Jogadores Empataram.                 *")
    print("*  Obrigado por jogar!!                               *")
    print("*******************************************************")
    
main()

