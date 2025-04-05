import java.io.*;

public class Main {

    static int N, K, T, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testData = Integer.parseInt(br.readLine());

        for (int i = 0; i < testData; i++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);
            T = Integer.parseInt(input[2]);
            M = Integer.parseInt(input[3]);

            Log[] logs = new Log[M];
            int[][] scores = new int[N + 1][K + 1];
            int[] finalScores = new int[N + 1];
            int[] submits = new int[N + 1];

            for (int j = 0; j < M; j++) {
                input = br.readLine().split(" ");
                logs[j] = new Log(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                submits[logs[j].i]++;

                scores[logs[j].i][logs[j].j] = Math.max(logs[j].s, scores[logs[j].i][logs[j].j]);
            }

            for (int j = 1; j <= N; j++) {
                int finalScore = 0;

                for (int k = 1; k <= K; k++) {
                    finalScore += scores[j][k];
                }

                finalScores[j] = finalScore;
            }

            int myTeamScore = finalScores[T];
            int myTeamSubmit = submits[T];

            int count = 1;
            for (int j = 1; j <= N; j++) {
                if (j != T) {
                    if (finalScores[j] == myTeamScore && submits[j] == myTeamSubmit) {
                        for (int k = M - 1; k >= 0; k--) {
                            if (logs[k].i == T) {
                                count++;
                                break;
                            } else if (logs[k].i == j) {
                                break;
                            }
                        }
                    } else if (finalScores[j] == myTeamScore) {
                        if (submits[j] < myTeamSubmit) count++;
                    } else {
                        if (finalScores[j] > myTeamScore) count++;
                    }
                }
            }

            sb.append(count);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

class Log {
    int i;
    int j;
    int s;

    Log(int i, int j, int s) {
        this.i = i;
        this.j = j;
        this.s = s;
    }
}