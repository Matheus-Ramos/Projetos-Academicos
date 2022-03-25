# Algoritmos-de-Grafo

Kruskal : O arquivo Kruskal.c contem o exemplo do livro, ja o arquivo Kruskal_2.c aceita entrada do usuario, ambos os arquivos retornam uma tabela com as arestas que não formam ciclo na ordem que são colocadas para formar a arvore geradora minima, isto é, levando em conta qual tem menos peso e tambem retornam a soma das arestas.

Dijkstra : O arquivo Dijkstra.c utiliza o exemplo do livro, mas no livro consta-se 2 erros, o 1º é que ele não considera a aresta (C, D) com peso 2 e o 2º erro é que ele soma a distancia de D/E ate F como 10 mas não considera que a distancia de (A, D) e a distancia de (A, E) é 6 e a distancia do vertice D/E para F é 6 logo daria 12 e não 10. O arquivo Dijkstra_2.c aceita entrada do usuario, ambos os arquivos retornam um conjunto de tabelas com os vertices, a distancia com o vertice anterior e os vertices atuais que estão fechados.

[off] Prim : O arquivo Prim.c contem o exemplo do livro, ja o arquivo Prim_2.c recebe a quantidade de vertices, de arestas, o grafo e um vertice de origem. É retornado para o usuario uma tabela com as arestas que não formam ciclo na ordem que são colocadas para formar a arvore geradora minima, isto é, levando em conta qual tem menos peso e tambem retornam a soma das arestas incluidas. 
