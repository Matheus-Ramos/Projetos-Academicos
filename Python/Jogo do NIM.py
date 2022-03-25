def computador_escolhe_jogada(n, m):
    if(n <= m):#erro
        jogada = n
    else:
        if not (n%(m+1)==0):#erro
            jogada = n
        else:
            jogada = n/(m+1)
    while True:
        if((jogada >= 1) and (jogada <= m)):
            print("O computador tirou ", jogada, " peças.")
            if(n-jogada == 0):
                print("Fim do jogo! O computador ganhou!\n")
                return jogada
            else:
                print("Agora resta apenas ", n-jogada, " peças no tabuleiro.\n")
                return jogada
        else:
            jogada -= 1#???

def usuario_escolhe_jogada(n, m):
    while True:
        jogada = int(input("Quantas peças você vai tirar? "))
        if((jogada >= 1) and (jogada <= m) and not (jogada > n)):
            print("Você tirou ", jogada, " peças.")
            if(n-jogada <= 0):
                print("Fim do jogo! Voce ganhou!\n")
                return jogada
            else:
                print("Agora resta apenas ", n-jogada, " peças no tabuleiro.\n")
                return jogada
        else:
            print("Oops! Jogada inválida! Tente de novo.\n")#erro
            
def partida():
    n = int(input("Quantas peças? "))
    m = int(input("Limite de peças por jogada? "))
    if(n%(m+1)==0):
        print("\nVoce começa!\n")
        vez = 1
    else:
        print("\nComputador começa!\n")
        vez = 2
    while(n > 0):
        if(vez == 1):
            jogada = usuario_escolhe_jogada(n, m)
            n -= jogada
            if(n == 0):
                return 1
            vez = 2
        else:#vez == 2
            jogada = computador_escolhe_jogada(n, m)
            n -= jogada
            if(n == 0):
                return 2
            vez = 1
    
def campeonato():
    i = 1
    user = 0
    comp = 0
    while(i<=3):
        print("**** Rodada ",i, " ****\n")
        vencedor = partida()
        if(vencedor == 1):
            user += 1
        else:#vencedor == 2
            comp += 1
        i += 1
    print("**** Final do campeonato! ****\n")
    print("Placar: Você ", user, " X ", comp, " Computador")

selecao = int(input("Bem-vindo ao jogo do NIM! Escolha:\n\n1 - para jogar uma partida isolada\n2 - para jogar um campeonato "))
if(selecao == 1):
    print("\nVoce escolheu uma partida!\n")
    partida()
else:
    if(selecao == 2):
        print("\nVoce escolheu um campeonato!\n")
        campeonato()
    else:
        print("\nSeleção invalida!\n")
