import java.io.*;

public class Main {

    static int n, m, answer = 0;
    static int[][] paper;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        paper = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++)
                paper[i][j] = Integer.parseInt(input[j]);
        }

        tetromino1();
        tetromino2();
        tetromino3();
        tetromino4();
        tetromino5();

        System.out.println(answer);
    }

    static void tetromino1() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 3; j++) {
                int sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i][j + 3];
                answer = Math.max(sum, answer);
            }
        }

        for (int i = 0; i < n - 3; i++) {
            for (int j = 0; j < m; j++) {
                int sum = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 3][j];
                answer = Math.max(sum, answer);
            }
        }
    }

    static void tetromino2() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                int sum = paper[i][j] + paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1];
                answer = Math.max(sum, answer);
            }
        }
    }

    static void tetromino3() {

        // *
        // *
        // **

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int sum = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 2][j + 1];
                answer = Math.max(sum, answer);
            }
        }

        //  *
        //  *
        // **

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int sum = paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j] + paper[i + 2][j + 1];
                answer = Math.max(sum, answer);
            }
        }

        //   *
        // ***

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int sum = paper[i][j + 2] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
                answer = Math.max(sum, answer);
            }
        }

        // ***
        //   *

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 2];
                answer = Math.max(sum, answer);
            }
        }

        // **
        //  *
        //  *

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int sum = paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
                answer = Math.max(sum, answer);
            }
        }

        // **
        // *
        // *

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int sum = paper[i][j] + paper[i][j + 1] + paper[i + 1][j] + paper[i + 2][j];
                answer = Math.max(sum, answer);
            }
        }

        // ***
        // *

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j];
                answer = Math.max(sum, answer);
            }
        }

        // *
        // ***

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int sum = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
                answer = Math.max(sum, answer);
            }
        }
    }

    static void tetromino4() {

        // *
        // **
        //  *

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int sum = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
                answer = Math.max(sum, answer);
            }
        }

        //  *
        // **
        // *

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int sum = paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j];
                answer = Math.max(sum, answer);
            }
        }

        //  **
        // **

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int sum = paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 1] + paper[i + 1][j];
                answer = Math.max(sum, answer);
            }
        }

        // **
        //  **

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int sum = paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
                answer = Math.max(sum, answer);
            }
        }
    }

    static void tetromino5() {

        //  *
        // **
        //  *

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int sum = paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
                answer = Math.max(sum, answer);
            }
        }

        //  *
        // ***

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int sum = paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
                answer = Math.max(sum, answer);
            }
        }

        // *
        // **
        // *

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int sum = paper[i + 1][j + 1] + paper[i][j] + paper[i + 1][j] + paper[i + 2][j];
                answer = Math.max(sum, answer);
            }
        }

        // ***
        //  *

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                int sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 1];
                answer = Math.max(sum, answer);
            }
        }
    }
}