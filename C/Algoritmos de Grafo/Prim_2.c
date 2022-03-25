#include <stdio.h>
#include <stdlib.h>

int tam;

void imprimir(int v1, int v2, int peso, int vetor_arv[])
{
	printf("Aresta\tVertices Incluidos\tValor\n");
	printf("(%d,%d)\t", v1, v2);
	printf("{");
	for(int i = 0; i < tam; i++)
	{
		if(vetor_arv[i] == 1)
			printf("%d,", i);
	}
	printf("}\t\t");
	printf("%d\n", peso);
}

int menor(int grafo[tam][tam], int linha, int vetor_arv[])
{
	int min = grafo[linha][0];
	int posicao = 0;
	for(int i = 1; i < tam; i++)
	{
		if((grafo[linha][i] < min) && (vetor_arv[i] == 0))
		{
			min = grafo[linha][i];
			posicao = i;
		}
	}
	return posicao;
}

int visitados(int vetor[])
{
	int soma = 0;
	for(int i = 0; i < tam; i++)
		soma += vetor[i];
	return soma;
}

void prim(int grafo[tam][tam], int orig)
{
	int i, j;
	int soma = 0;
	int arv[tam];
	for(i = 0; i < tam; i++)
		arv[i] = 0;
	arv[orig] = 1;
	int aux[3];
	aux[2] = 1000000;
	while(visitados(arv) < tam)
	{
		for(i = 0; i < tam; i++)
		{
			if((arv[i] == 1) && (i == orig))///vertice na arvore(orig)
			{
				j=menor(grafo, i, arv);///vertice q liga a arvore com a aresta de menor peso
				aux[0] = i;
				aux[1] = j;
				aux[2] = grafo[i][j];
			}
			else if((arv[i] == 1) && (i != orig))///vertice na arvore(repetiçoes)	
			{
				j=menor(grafo, i, arv);///vertice q liga a arvore com a aresta de menor peso
				if(grafo[i][j] < aux[2])
				{
					aux[0] = i;
					aux[1] = j;
					aux[2] = grafo[i][j];
				}
				if(grafo[i][j] == aux[2])///pesos iguais
				{
					if(j < aux[1])
					{
						aux[0] = i;
						aux[1] = j;
					}
					if(j == aux[1])///vertice de menor indice
						aux[0] = aux[0] < i ? aux[0] : i;
				}
			}
		}	
		imprimir(i, j, grafo[i][j], arv);
		soma += aux[2];	
		arv[j] = 1;
		aux[2] = 1000000;
	}
	printf("O custo da arvore geradora minima é %d\n", soma);
}

int main()
{
	printf("Informe o numero de vertices do grafo: ");
	scanf("%d", &tam);
	int arestas, a, b, valor, origem;
	printf("Informe o numero de arestas do grafo: ");
	scanf("%d", &arestas);
	int grafo[tam][tam];
	for(int i = 0; i < tam; i++)
	{
		for(int j = 0; j < tam; j++)
			grafo[i][j] = 1000000;
	}
	while(arestas > 0)
	{
		scanf("%d%d%d", &a, &b, &valor);
		grafo[a][b] = valor;
		arestas--;
	}
	printf("\nInforme o vertice de origem: ");
	scanf("%d", &origem);
	prim(grafo, origem);
	return 0;
}