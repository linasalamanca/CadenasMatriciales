public class Main {
    public static int minMultBottomUp(int[] d) {
        int n = d.length - 1;
        int[][] M = new int[n + 1][n + 1];

        // Inicializar con valores máximos excepto la diagonal principal
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                M[i][j] = Integer.MAX_VALUE;
            }
        }

        // Inicializar la diagonal principal de M
        for (int i = 1; i <= n; i++) {
            M[i][i] = 0;
        }

        // Calcular M[i][j] para todas las subsecuencias de longitud l
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                for (int k = i; k < j; k++) {
                    M[i][j] = Math.min(M[i][j], M[i][k] + M[k + 1][j] + d[i - 1] * d[k] * d[j]);
                }
            }
        }

        return M[1][n];
    }

    public static void main(String[] args) {
        int[] d = {2, 3, 4, 5, 3};
        int minMultiplicaciones = minMultBottomUp(d);
        System.out.println("Cantidad mínima de multiplicaciones: " + minMultiplicaciones);
    }
}
