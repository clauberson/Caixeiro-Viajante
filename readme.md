# Problema do Caixeiro-Viajante (TSP) - Algoritmo de Held-Karp

## Descrição

O Problema do Caixeiro-Viajante (TSP - Traveling Salesman Problem) é um dos problemas clássicos da otimização combinatória. O objetivo é determinar a rota mais curta que permite a um caixeiro-viajante visitar um conjunto de cidades, passando por cada cidade exatamente uma vez e retornando à cidade de origem.

Formalmente, dado um conjunto de cidades e as distâncias entre cada par de cidades, o problema consiste em encontrar o ciclo hamiltoniano (rota) de menor custo.

### Exemplo de Aplicação
Imagine um entregador que precisa passar por várias cidades para entregar pacotes. O TSP ajudaria a determinar a rota mais eficiente, minimizando a distância total percorrida e, consequentemente, o tempo e o custo da viagem.

## Solução: Algoritmo de Held-Karp

O algoritmo de Held-Karp é uma solução baseada em programação dinâmica para o TSP. Ele resolve o problema explorando todas as combinações possíveis de cidades e subproblemas, mas de maneira mais eficiente que a força bruta.

### Características do Algoritmo:

- **Complexidade**: O algoritmo de Held-Karp tem complexidade de tempo \(O(N^2 \cdot 2^N)\), onde `N` é o número de cidades. Embora ainda exponencial, é uma melhoria significativa em relação à abordagem de força bruta que tem complexidade \(O(N!)\).
- **Estratégia**: O algoritmo utiliza uma matriz `dp` onde `dp[v][mask]` representa o custo mínimo para visitar o subconjunto de cidades representado por `mask`, terminando na cidade `v`. Ele constrói a solução a partir de subproblemas menores, combinando os resultados para encontrar o caminho ótimo.

### Como Executar

Para compilar e executar o código em Java:

1. Compile o código:
    ```bash
    javac HeldKarpTSP.java
    ```

2. Execute o programa:
    ```bash
    java HeldKarpTSP
    ```

O programa calculará e exibirá o custo mínimo do caminho, ou seja, a menor distância total que permite visitar todas as cidades e retornar à cidade de origem.