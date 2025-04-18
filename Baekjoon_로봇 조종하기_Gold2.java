import java.io.*;

public class Main {

    static int N, M;
    static int[][] mars, dp, tmp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        mars = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                mars[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp[0][0] = mars[0][0];
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + mars[0][i];
        }

        for (int i = 1; i < N; i++) {
            tmp = new int[2][M];

            tmp[0][0] = dp[i - 1][0] + mars[i][0];
            for (int j = 1; j < M; j++) {
                tmp[0][j] = Math.max(tmp[0][j - 1], dp[i - 1][j]) + mars[i][j];
            }

            tmp[1][M - 1] = dp[i - 1][M - 1] + mars[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                tmp[1][j] = Math.max(tmp[1][j + 1], dp[i - 1][j]) + mars[i][j];
            }

            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(tmp[0][j], tmp[1][j]);
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}