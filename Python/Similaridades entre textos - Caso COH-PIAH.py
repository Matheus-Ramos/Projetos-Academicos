import re#biblioteca de expressoes regulares: tratamento de textos

def le_assinatura():
    '''A funcao le os valores dos tracos linguisticos do modelo e devolve uma assinatura a ser comparada com os textos fornecidos'''
    print("Bem-vindo ao detector automático de COH-PIAH.")
    print("Informe a assinatura típica de um aluno infectado:")

    wal = float(input("Entre o tamanho médio de palavra:"))
    ttr = float(input("Entre a relação Type-Token:"))
    hlr = float(input("Entre a Razão Hapax Legomana:"))
    sal = float(input("Entre o tamanho médio de sentença:"))
    sac = float(input("Entre a complexidade média da sentença:"))
    pal = float(input("Entre o tamanho medio de frase:"))

    return [wal, ttr, hlr, sal, sac, pal]

def le_textos():
    i = 1
    textos = []
    texto = input("Digite o texto " + str(i) +" (aperte enter para sair):")
    while texto:
        textos.append(texto)
        i += 1
        texto = input("Digite o texto " + str(i) +" (aperte enter para sair):")

    return textos

def separa_sentencas(texto):
    '''A funcao recebe um texto e devolve uma lista das sentencas dentro do texto'''
    sentencas = re.split(r'[.!?]+', texto)
    if sentencas[-1] == '':
        del sentencas[-1]
    return sentencas

def separa_frases(sentenca):
    '''A funcao recebe uma sentenca e devolve uma lista das frases dentro da sentenca'''
    return re.split(r'[,:;]+', sentenca)

def separa_palavras(frase):
    '''A funcao recebe uma frase e devolve uma lista das palavras dentro da frase'''
    return frase.split()

def n_palavras_unicas(lista_palavras):#comprenender
    '''Essa funcao recebe uma lista de palavras e devolve o numero de palavras que aparecem uma unica vez'''
    freq = dict()
    #print("freq é:" + freq)
    unicas = 0
    for palavra in lista_palavras:
        p = palavra.lower()
        if p in freq:
            #print("freq[" + p + "] é:" + freq[p])
            if freq[p] == 1:
                unicas -= 1
            freq[p] += 1
        else:
            freq[p] = 1
            unicas += 1

    return unicas

def n_palavras_diferentes(lista_palavras):#comprenender
    '''Essa funcao recebe uma lista de palavras e devolve o numero de palavras diferentes utilizadas'''
    freq = dict()
    for palavra in lista_palavras:
        p = palavra.lower()
        if p in freq:
            freq[p] += 1
        else:
            freq[p] = 1

    return len(freq)

def cont_caracter(lista):
    caracters = i = 0
    while i < len(lista):
        caracters += len(lista[i])
        i += 1
    return caracters

def compara_assinatura(as_a, as_b):
    med_dif = i = 0
    while i < 6:
        med_dif += abs(as_a[i] - as_b[i])
        i += 1
    return med_dif/6

def calcula_assinatura(texto):
    sentencas = []
    frases = []
    palavras = []
    palavras_texto = []
    wal = ttr = hlr = sal = sac = pal = 0.0
    sentencas = separa_sentencas(texto)
    sal = cont_caracter(sentencas)
    totFra = npUni = npDif = totPal = 0
    i = 0
    while i < len(sentencas):
        frases = separa_frases(sentencas[i])
        totFra += len(frases)
        pal += cont_caracter(frases)
        j = 0
        while j < len(frases):
            palavras = separa_palavras(frases[j])
            totPal += len(palavras)
            wal += cont_caracter(palavras)
            g = 0
            while g < len(palavras):
                palavras_texto.append(palavras[g])
                g += 1
            j += 1
        i += 1
    ttr = n_palavras_diferentes(palavras_texto)
    hlr = n_palavras_unicas(palavras_texto)
    wal /= totPal
    ttr /= totPal
    hlr /= totPal
    sal /= len(sentencas)
    sac = totFra / len(sentencas)
    pal /= totFra

    return [wal, ttr, hlr, sal, sac, pal]

def menor_elemento(lista):
    menor = lista[0]
    ind_min = 0
    i = 1
    while(i != (len(lista))):
        if(menor > lista[i]):
            menor = lista[i]
            ind_min = i
        i += 1
    return ind_min

def avalia_textos(textos, ass_cp):
    assTeste = []
    simili = []
    aux = i = 0
    while i < len(textos):
        assTeste = calcula_assinatura(textos[i])
        aux = compara_assinatura(ass_cp, assTeste)
        simili.append(aux)
        i += 1
    return menor_elemento(simili) + 1

def main():
    assBase = []
    assBase = le_assinatura()
    textos = []
    textos = le_textos()
    tex_cop = 0
    tex_cop = avalia_textos(textos, assBase)
    print("O autor do texto " + str(tex_cop) + " está infectado com COH-PIAH")
    
#main()
        
