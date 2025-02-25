import java.io.*;

public class Main {

    static int N, dir, x, y, sand;
    static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        dir = 0;
        x = N / 2;
        y = N / 2;
        sand = 0;

        for (int i = 1; i < N; i++) {
            for (int l = 0; l < 2; l++) {
                for (int k = 0; k < i; k++) {
                    move();
                }
                dir = (dir + 1) % 4;
            }
        }

        for (int k = 0; k < N - 1; k++) {
            move();
        }

        System.out.println(sand);
    }

    static void move() {
        Percent percent = new Percent(dir);
        x += dx[dir];
        y += dy[dir];
        int sandSum = 0;

        for (int j = 0; j < 9; j++) {
            int nextX = x + percent.dx[j];
            int nextY = y + percent.dy[j];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                int sandTmp = board[x][y] * percent.ratio[j] / 100;
                board[nextX][nextY] += sandTmp;
                sandSum += sandTmp;
            } else {
                int sandTmp = board[x][y] * percent.ratio[j] / 100;
                sand += sandTmp;
                sandSum += sandTmp;
            }
        }

        board[x][y] -= sandSum;

        int nextX = x + percent.dx[9];
        int nextY = y + percent.dy[9];

        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
            board[nextX][nextY] += board[x][y];
            board[x][y] = 0;
        } else {
            sand += board[x][y];
            board[x][y] = 0;
        }
    }
}

class Percent {
    int dir;
    int[] dx;
    int[] dy;
    int[] ratio;

    Percent(int dir) {
        if (dir == 0) {
            dx = new int[] {-2, -1, -1, -1, 0, 1, 1, 1, 2, 0};
            dy = new int[] {0, -1, 0, 1, -2, -1, 0, 1, 0, -1};
            ratio = new int[] {2, 10, 7, 1, 5, 10, 7, 1, 2, -1};
            // 왼
            //     2
            //  10 7 1
            // 5 a y x
            //  10 7 1
            //     2
        } else if (dir == 1) {
            dx = new int[] {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1};
            dy = new int[] {-1, 1, -2, -1, 1, 2, -1, 1, 0, 0};
            ratio = new int[] {1, 1, 2, 7, 7, 2, 10, 10, 5, -1};
            // 아래
            //   1 x 1
            // 2 7 y 7 2
            //  10 a 10
            //     5
        } else if (dir == 2) {
            dx = new int[] {-2, -1, -1, -1, 0, 1, 1, 1, 2, 0};
            dy = new int[] {0, -1, 0, 1, 2, -1, 0, 1, 0, 1};
            ratio = new int[] {2, 1, 7, 10, 5, 1, 7, 10, 2, -1};
            // 오른
            //   2
            // 1 7 10
            // x y a 5
            // 1 7 10
            //   2
        } else if (dir == 3) {
            dx = new int[] {-2, -1, -1, 0, 0, 0, 0, 1, 1, -1};
            dy = new int[] {0, -1, 1, -2, -1, 1, 2, -1, 1, 0};
            ratio = new int[] {5, 10, 10, 2, 7, 7, 2, 1, 1, -1};
            // 위
            //     5
            //  10 a 10
            // 2 7 y 7 2
            //   1 x 1
        }
    }
}