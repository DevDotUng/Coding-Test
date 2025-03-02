import java.io.*;

public class Main {

    static int N = 0;
    static int[][] board;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(input.split(" ")[j]);
        }

        dfs(0);

        System.out.println(max);
    }

    static void dfs(int depth) {
        if (depth == 5) {
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    max = Math.max(board[i][j], max);
            return;
        }

        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                copy[i][j] = board[i][j];

        left(depth, copy);
        right(depth, copy);
        up(depth, copy);
        down(depth, copy);
    }

    static void left(int depth, int[][] copy) {

        for (int i = 0; i < N; i++) {
            int block = 0;
            int index = 0;

            for (int j = 0; j < N; j++) {
                if (board[i][j] > 0 && board[i][j] == block) {
                    board[i][index - 1] = block * 2;
                    block = 0;
                    board[i][j] = 0;
                } else if (board[i][j] > 0 && board[i][j] != block) {
                    block = board[i][j];
                    board[i][j] = 0;
                    board[i][index] = block;
                    index++;
                }
            }
        }

        dfs(depth + 1);

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = copy[i][j];
    }

    static void right(int depth, int[][] copy) {

        for (int i = 0; i < N; i++) {
            int block = 0;
            int index = N - 1;

            for (int j = N - 1; j >= 0; j--) {
                if (board[i][j] > 0 && board[i][j] == block) {
                    board[i][index + 1] = block * 2;
                    block = 0;
                    board[i][j] = 0;
                } else if (board[i][j] > 0 && board[i][j] != block) {
                    block = board[i][j];
                    board[i][j] = 0;
                    board[i][index] = block;
                    index--;
                }
            }
        }

        dfs(depth + 1);

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = copy[i][j];
    }

    static void up(int depth, int[][] copy) {

        for (int j = 0; j < N; j++) {
            int block = 0;
            int index = 0;

            for (int i = 0; i < N; i++) {
                if (board[i][j] > 0 && board[i][j] == block) {
                    board[index - 1][j] = block * 2;
                    block = 0;
                    board[i][j] = 0;
                } else if (board[i][j] > 0 && board[i][j] != block) {
                    block = board[i][j];
                    board[i][j] = 0;
                    board[index][j] = block;
                    index++;
                }
            }
        }

        dfs(depth + 1);

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = copy[i][j];
    }

    static void down(int depth, int[][] copy) {

        for (int j = 0; j < N; j++) {
            int block = 0;
            int index = N - 1;

            for (int i = N - 1; i >= 0; i--) {
                if (board[i][j] > 0 && board[i][j] == block) {
                    board[index + 1][j] = block * 2;
                    block = 0;
                    board[i][j] = 0;
                } else if (board[i][j] > 0 && board[i][j] != block) {
                    block = board[i][j];
                    board[i][j] = 0;
                    board[index][j] = block;
                    index--;
                }
            }
        }

        dfs(depth + 1);

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = copy[i][j];
    }
}