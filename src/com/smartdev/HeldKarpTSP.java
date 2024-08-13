package com.smartdev;

import java.util.Arrays;

public class HeldKarpTSP {
    // Número de cidades
    private static final int N = 4;

    // Matriz de distâncias
    private static final int[][] distanceMatrix = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
    };

    public static void main(String[] args) {
        long minCost = heldKarp();
        System.out.println("Custo mínimo do caminho: " + minCost);
    }

    public static long heldKarp() {
        // 2^N combinações possíveis
        int numCombinations = 1 << N;
        // Matriz dp para armazenar os custos
        long[][] dp = new long[N][numCombinations];
        // Inicializando dp com valores grandes mas não com Long.MAX_VALUE
        for (long[] row : dp) {
            Arrays.fill(row, 1000000000L); // Um valor grande, mas seguro para evitar overflow
        }
        // A distância para a cidade inicial é 0
        dp[0][1] = 0;

        // Preenchendo a matriz dp
        for (int mask = 1; mask < numCombinations; mask += 2) {
            for (int u = 0; u < N; u++) {
                if ((mask & (1 << u)) != 0) {
                    for (int v = 0; v < N; v++) {
                        if ((mask & (1 << v)) == 0) {
                            int newMask = mask | (1 << v);
                            dp[v][newMask] = Math.min(dp[v][newMask], dp[u][mask] + distanceMatrix[u][v]);
                        }
                    }
                }
            }
        }

        // Calculando o custo mínimo para retornar à cidade inicial
        long minCost = Long.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            minCost = Math.min(minCost, dp[i][numCombinations - 1] + distanceMatrix[i][0]);
        }
        return minCost;
    }
}
