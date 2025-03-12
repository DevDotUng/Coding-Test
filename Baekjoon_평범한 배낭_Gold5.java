import java.io.*;

public class Main {

    static int N, K, max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        int[][] arr = new int[N][K];

        input = br.readLine().split(" ");
        int w = Integer.parseInt(input[0]);
        int v = Integer.parseInt(input[1]);
        for (int i = 1; i <= K; i++) {
            if (w <= i) arr[0][i - 1] = v;
        }

        for (int i = 1; i < N; i++) {
            input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            v = Integer.parseInt(input[1]);
            for (int j = 1; j <= K; j++) {
                if (w <= j) {
                    int tmp = v;
                    int k = j - w;

                    if (k > 0) {
                        tmp += arr[i - 1][k - 1];
                    }
                    arr[i][j - 1] = Math.max(tmp, arr[i - 1][j - 1]);
                } else {
                    arr[i][j - 1] = arr[i - 1][j - 1];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                max = Math.max(arr[i][j], max);
            }
        }

        System.out.println(max);
    }
}