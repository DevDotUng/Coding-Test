import java.io.*;
import java.util.*;

public class Main {

    static int N, Q, M;
    static int[] magics, dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        Q = Integer.parseInt(input[1]);
        M = (int) Math.pow(2, N);
        magics = new int[Q];
        board = new int[M][M];
        visited = new boolean[M][M];

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < Q; i++) {
            magics[i] = Integer.parseInt(input[i]);
        }

        for (int magic: magics) {
            int L = (int) Math.pow(2, magic);

            for (int i = 0; i < M; i += L) {
                for (int j = 0; j < M; j += L) {

                    // 복사
                    int[][] copy = new int[L][L];
                    for (int k = 0; k < L; k++) {
                        for (int l = 0; l < L; l++) {
                            copy[k][l] = board[i + k][j + l];
                        }
                    }

                    // 회전해서 붙여넣기
                    for (int k = 0; k < L; k++) {
                        for (int l = 0; l < L; l++) {
                            board[i + k][j + l] = copy[L - l - 1][k];
                        }
                    }
                }
            }

            int[][] ices = new int[M][M];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    int ice = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];

                        if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < M && board[nextX][nextY] > 0) {
                            ice++;
                        }
                    }

                    ices[i][j] = ice;
                }
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    if (ices[i][j] < 3) {
                        board[i][j]--;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > 0) sum += board[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, bfs(i, j));
            }
        }

        System.out.println(sum + "\n" + max);
    }

    static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        if (board[x][y] <= 0 || visited[x][y]) return 0;
        int count = 0;
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < M && board[nextX][nextY] > 0 && !visited[nextX][nextY]) {
                    queue.offer(new Point(nextX, nextY));
                    visited[nextX][nextY] = true;
                    count++;
                }
            }
        }

        return count;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}