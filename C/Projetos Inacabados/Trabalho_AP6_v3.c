/*Problema 2: Dado 3 jarras de capacidades 8, 5 e 3 litros; nenhuma delas tem qualquer marcação de medidas. 
O jarro de 8 litros está cheio de água, os demais estão vazios. Usando essas 3 jarras, como separar 4 litros 
em um deles, podendo somente realizar a operação de transferir água de uma jarra na outra sem derramar?
Sera utilizada a busca heurística/gulosa com lista encadeada.*/
#include <stdio.h>
#include <stdlib.h>
#define p1 1
#define p2 10

typedef struct estado
{
	int num[3];
	int etiq, etiq_prox1, etiq_prox2;
	int peso1, peso2;
	int flag;
	struct estado *prox_e;
	struct estado *ant;
}estado;

typedef struct lista
{
	int num[3];
	struct lista *prox;
}lista;

lista* alocar_l(lista *rec, int x, int y, int z)
{
	lista *nova;
	nova = malloc (sizeof (lista));
	nova->num[0] = x;
	nova->num[1] = y;
	nova->num[2] = z;
	nova->prox = rec->prox;
	rec->prox = nova;
	return nova;
}

estado* alocar_e(estado *rec, int x, int y, int z, int etq, int etqp1, int etqp2, int ps1, int ps2)
{
	estado *novo;
	novo = (estado*)malloc (sizeof (estado));
	rec->num[0] = x;
	rec->num[1] = y;
	rec->num[2] = z;
	rec->etiq= etq;
	rec->etiq_prox1 = etqp1;
	rec->etiq_prox2 = etqp2;
	rec->peso1 = ps1;
	rec->peso2 = ps2;
	rec->flag = 0;
	novo->prox_e = rec;
	novo->ant = NULL;
	if(rec != NULL)///primeiro elemento
		rec->ant = novo;
	return novo;
}

/*void imprimir_e(estado *rec)
{
	while(rec != NULL)
	{
		printf("%d %d %d\n", rec->num[0], rec->num[1], rec->num[2]);
		rec=rec->prox_e;
	}
}*/

int menor(estado *rec, int k)
{
	int a;
	while(rec != NULL)
	{
		if(rec->flag == 1)
		{
			if(k <= rec->peso1 && rec->peso1 != 0)
			{
				k = rec->peso1;
				a = rec->etiq_prox1;
			}
			else if(k <= rec->peso2 && rec->peso2 != 0)
			{
				k = rec->peso2;
				a = rec->etiq_prox2;
			}
		}
		rec=rec->prox_e;
	}
	return a;
}

void separa_4(estado *rec, lista *list)
{
	if(rec->etiq_prox1 == 0)
		exit(1);
	else
	{
		int m, p;
		rec->flag = 1;
		if(rec->etiq_prox2 == 0)
			p = rec->peso1;
		else
		{
			if(rec->peso1 <= rec->peso2)
				p = rec->peso1;
			else
				p = rec->peso2;
		}
		m = menor(rec, p);
		while(rec->ant != NULL)
		{
			if(m == rec->etiq)
			{
				list = alocar_l(list, rec->num[0], rec->num[1], rec->num[2]);
				printf("%d %d %d\n", list->num[0], list->num[1], list->num[2]);
				separa_4(rec, list);
			}
			rec = rec->prox_e;
		}
	}	
}

int main()
{
	estado *E;
	lista *L;
	///alocando os estados
	E = malloc(sizeof(estado));
	E->prox_e = NULL;
	E->ant = NULL;
	///estado inicial: (8, 0, 0); estado final: (4, 4, 0)
	///----------------------------------------------------------------------------------------------------------------------------
	///alocando a lista
	L = malloc(sizeof(lista));
	L->prox= NULL;
	///----------------------------------------------------------------------------------------------------------------------------
	///entrada  
	///alocar_e(estado, rec->num[0], rec->num[1], rec->num[2], rec->etiq, rec->etiq_prox1, rec->etiq_prox2, rec->peso1, rec->peso2);
	/// se a etiqueta for 0 considerar null
	E = alocar_e(E, 8, 0, 0, 1, 2, 10, p1, p2);///e1
	E = alocar_e(E, 3, 5, 0, 2, 4, 3, p1, 20);///e2
	E = alocar_e(E, 0, 5, 3, 3, 10, 0, p2, 0);///e3
	E = alocar_e(E, 3, 2, 3, 4, 6, 10, p1, p2);///e4
	E = alocar_e(E, 6, 0, 2, 5, 7, 10, p1, p2);///e5
	E = alocar_e(E, 6, 2, 0, 6, 5, 0, p1, 0);///e6
	E = alocar_e(E, 1, 5, 2, 7, 8, 0, p1, 0);///e7
	E = alocar_e(E, 1, 4, 3, 8, 9, 10, p1, p2);///e8
	E = alocar_e(E, 4, 4, 0, 9, 0, 0, 0, 0);///e9
	E = alocar_e(E, 5, 0, 3, 10, 11, 0, p2, 0);///e10
	E = alocar_e(E, 5, 3, 0, 11, 15, 0, p2, 0);///e11
	E = alocar_e(E, 4, 1, 3, 12, 9, 0, p1, 0);///e12
	E = alocar_e(E, 7, 1, 0, 13, 12, 0, p2, 0);///e13
	E = alocar_e(E, 7, 0, 1, 14, 13, 0, p2, 0);///e14
	E = alocar_e(E, 2, 3, 3, 15, 16, 0, p2, 0);///e15
	E = alocar_e(E, 2, 5, 1, 16, 14, 0, p2, 0);///e16	
	///----------------------------------------------------------------------------------------------------------------------------
	while(E->ant != NULL)
		E=E->ant;
	E=E->prox_e;
	L = alocar_l(L, E->num[0], E->num[1], E->num[2]);
	printf("%d %d %d\n", L->num[0], L->num[1], L->num[2]);
	//imprimir_e(E);
	separa_4(E, L);
	return 0;
}