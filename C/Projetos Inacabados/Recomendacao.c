#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#define MAX 100

typedef struct musicas
{
    char artirsta[MAX];
    char nome_da_musica[MAX];
    int decada;///70, 80, 90, 00, 10
    char genero[MAX];///Axe, Eletronica, Hip Hop/Rap, MPB, Pagode, Pop, Pop Rock, R&B, Reggaeton, Rock, Sertanejo, Soul
    int lingua;///[1]Ingles, [2]Portugues, [3]Espanhol, [4]Coreano
    int estilo;///[5]Animada, [6]Lenta
} musicas;

int i, j, k, tam;
int flag_idm=0;
int flag_stl_msc=0;
int flag_anos=0;
int flag_gnr_msc=0;
musicas mscs[MAX];
musicas rcmd[MAX];

void idioma(int idm)
{
    k=j=0;
    if(idm==1 || idm==2 || idm==3 || idm==4)
    {
        for(i=0;i<MAX;i++)
        {
            if(idm==mscs[i].lingua)
            {
                strcpy(rcmd[j].artirsta,mscs[i].artirsta);
                strcpy(rcmd[j].nome_da_musica,mscs[i].nome_da_musica);
                rcmd[j].decada=mscs[i].decada;
                strcpy(rcmd[j].genero,mscs[i].genero);
                rcmd[j].lingua=mscs[i].lingua;
                rcmd[j].estilo=mscs[i].estilo;
                j++;
                k++;
            }
        } 
    }
    else
        flag_idm=1;
    tam=k;
}

void estilo_musical(int stl_msc)
{
    k=j=0;
    if(stl_msc==5 || stl_msc==6)
    {
        for(i=0;i<tam;i++)
        {
            if(stl_msc==rcmd[i].estilo)
            {
                strcpy(rcmd[j].artirsta,rcmd[i].artirsta);
                strcpy(rcmd[j].nome_da_musica,rcmd[i].nome_da_musica);
                rcmd[j].decada=rcmd[i].decada;
                strcpy(rcmd[j].genero,rcmd[i].genero);
                rcmd[j].lingua=rcmd[i].lingua;
                rcmd[j].estilo=rcmd[i].estilo;
                j++;
                k++;
            }
        } 
    }
    else
        flag_stl_msc=1;
    tam=k;
}

void periodo(int anos)
{
    k=j=0;
    if(anos==70 || anos==80 || anos==90 || anos==00 ||anos==10)
    {
        for(i=0;i<tam;i++)
        {
            if(anos==rcmd[i].decada)
            {
                strcpy(rcmd[j].artirsta,rcmd[i].artirsta);
                strcpy(rcmd[j].nome_da_musica,rcmd[i].nome_da_musica);
                rcmd[j].decada=rcmd[i].decada;
                strcpy(rcmd[j].genero,rcmd[i].genero);
                rcmd[j].lingua=rcmd[i].lingua;
                rcmd[j].estilo=rcmd[i].estilo;
                j++;
                k++;
            }
        } 
    }
    else
        flag_anos=1;
    tam=k;
}

void genero_musical(char gnr_msc[])
{
    k=j=0;
    int valid=0;
    
    if(strcmp(gnr_msc,"AXE")==0 || strcmp(gnr_msc,"ELETRONICA")==0 || strcmp(gnr_msc,"HIP HOP/RAP")==0)
        valid=1;
    else if(strcmp(gnr_msc,"MPB")==0 || strcmp(gnr_msc,"PAGODE")==0 || strcmp(gnr_msc,"POP")==0)
        valid=1;
    else if(strcmp(gnr_msc,"POP ROCK")==0 || strcmp(gnr_msc,"R&B")==0 || strcmp(gnr_msc,"REGGAETON")==0)
        valid=1;
    else if(strcmp(gnr_msc,"ROCK")==0 || strcmp(gnr_msc,"SERTANEJO")==0 || strcmp(gnr_msc,"SOUL")==0)
        valid=1;
    if(valid)
    {
        for(i=0;i<tam;i++)                         
        {
            if(strcmp(gnr_msc,rcmd[i].genero)==0)
            {
                strcpy(rcmd[j].artirsta,rcmd[i].artirsta);
                strcpy(rcmd[j].nome_da_musica,rcmd[i].nome_da_musica);
                rcmd[j].decada=rcmd[i].decada;
                strcpy(rcmd[j].genero,rcmd[i].genero);
                rcmd[j].lingua=rcmd[i].lingua;
                rcmd[j].estilo=rcmd[i].estilo;
                j++;
                k++
            }
        } 
    }
    else
        flag_gnr_msc=1;
    tam=k;
}

int main()
{
    int dcd, lnga, stlo;
    char gnro[MAX];
    printf("\tBEM VINDO AO RECOMENDADOR DE MUSICAS XYZ\n\n\n");
    printf("Para começarmos informe qual idioma que voce gostaria de ouvir\n");
    printf("[1]Ingles, [2]Portugues, [3]Espanhol, [4]Coreano\n");
    printf("Por Favor digite o numero: ");
    scanf("%d", &lnga);
    printf("\n\n");
    printf("Informe qual estilo que voce gostaria de ouvir\n");
    printf("[5]Animada, [6]Lenta\n");
    printf("Por Favor digite o numero: ");
    scanf("%d", &stlo);
    printf("\n\n");
    printf("Informe qual decada que voce gostaria de ouvir\n");
    printf("70, 80, 90, 00, 10\n");
    printf("Por Favor digite o numero: ");
    scanf("%d", &dcd);
    printf("\n\n");
    printf("Por ultimo informe qual genero que voce gostaria de ouvir\n");
    scanf("%s", gnro);
    printf("\n\n");
    for(i=0;gnro[i]!='\0';i++)
    {
        gnro[i]=toupper(gnro[i]);
    }
    idioma(lnga);
    if(flag_idm);
        printf("Idioma escolhido invalido\n");
    estilo_musical(stlo);
    if(flag_stl_msc);
        printf("Estilo Musical escolhido invalido\n");
    periodo(dcd); 
    if(flag_anos)
        printf("Decada escolhida invalida\n"); 
    genero_musical(gnro);
    if(flag_gnr_msc)
        printf("Genero Musical escolhida invalida\n");
    for(i=0;i<tam;i++)                         
        {
            printf("%s\n",rcmd[i].nome_da_musica);
            printf("%s\n",rcmd[i].artirsta);
            pprintf("%s\n",rcmd[i].genero);
            if(rcmd[i].decada==70 || rcmd[i].decada==80 || rcmd[i].decada==90)
                printf("Anos %d\n",rcmd[i].decada);
            else
                printf("Anos 20%d\n",rcmd[i].decada);
        } 
    return 0;
}