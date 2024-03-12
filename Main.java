import java.util.ArrayList;

public class Main {
    public static class MatrixChainMultiplication {

        public static int minMultBottomUp(int[] d) {
            int n = d.length - 1;
            int[][] M = new int[n + 1][n + 1];
            int[][] S = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                M[i][i] = 0;
            }

            for (int l = 2; l <= n; l++) {
                for (int i = 1; i <= n - l + 1; i++) {
                    int j = i + l - 1;
                    M[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int q = M[i][k] + M[k + 1][j] + d[i - 1] * d[k] * d[j];
                        if (q < M[i][j]) {
                            M[i][j] = q;
                            S[i][j] = k;
                        }
                    }
                }
            }

            reconstruirPasos(S, n);
            return M[1][n];
        }

        /*
         * private static void reconstruirPasos(int[][] S, int i, int j) {
         * if (i < j) {
         * System.out.println("Multiplica la cadena de matrices de " + i + " a " +
         * S[i][j] + " y de " + (S[i][j] + 1) + " a " + j);
         * reconstruirPasos(S, i, S[i][j]);
         * reconstruirPasos(S, S[i][j] + 1, j);
         * }
         * }
         */

        private static void reconstruirPasos(int[][] S, int n) {
            ArrayList<Integer> resp = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (S[i][j] != 0) {
                        resp.add(S[i][j]);
                    }
                }
            }

            System.out.println(resp);
        }

        public static void main(String[] args) {
            int[] d = { 2, 3, 4, 5, 3 };
            int minMultiplicaciones = minMultBottomUp(d);
            System.out.println("Cantidad mínima de multiplicaciones: " + minMultiplicaciones);
        }
    }
}
