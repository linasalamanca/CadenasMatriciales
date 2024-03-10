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

        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }

        minMultReverso(d, n, M);

        return M[1][n];
    }

    public static int[][] minMultReverso(int[] d, int n, int m[][]) {
        int resp[][] = new int[n+1][n+1]; 
        int r = m[1][n];
        System.out.println("n es: "+n);

        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                resp[i][j] = 0;
            }
        }

        for(int i=n+1; i>=0; i--){
            for(int j=i; j<n+1; j++){
                if(i==1 || j==n){
                    resp[i][j] = m[i][j];
                }
            }
        }

        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                System.out.print(resp[i][j] + " ");
            }
            System.out.println();
        }

        return resp;
    }

    public static void main(String[] args) {
        int[] d = {2, 3, 4, 5, 3};
        int minMultiplicaciones = minMultBottomUp(d);
        System.out.println("Cantidad mínima de multiplicaciones: " + minMultiplicaciones);
    }
}
