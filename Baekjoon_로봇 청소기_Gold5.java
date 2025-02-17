import java.io.*;

public class Main {

    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int d = Integer.parseInt(input[2]);

        int[][] room = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(input[j]);
            }
        }

        int answer = 0;

        while (true) {
            if (room[r][c] == 0) {
                room[r][c] = 2;
                answer++;
            }

            if (room[r + dx[0]][c + dy[0]] != 0 && room[r + dx[1]][c + dy[1]] != 0 && room[r + dx[2]][c + dy[2]] != 0 && room[r + dx[3]][c + dy[3]] != 0) {
                int nextR = r + dx[(d + 2) % 4];
                int nextC = c + dy[(d + 2) % 4];

                if (room[nextR][nextC] != 1) {
                    r = nextR;
                    c = nextC;
                } else {
                    break;
                }
            } else {
                d = d == 0 ? 3 : d - 1;
                int nextR = r + dx[d];
                int nextC = c + dy[d];

                if (room[nextR][nextC] == 0) {
                    r = nextR;
                    c = nextC;
                }
            }
        }

        System.out.println(answer);
    }
}