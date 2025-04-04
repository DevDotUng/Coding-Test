import java.io.*;
import java.util.*;

public class Main {

    static int R, C, answer = 1;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static char[][] board;
    static HashSet<Character> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String inputString = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = inputString.charAt(j);
            }
        }

        set.add(board[0][0]);
        dfs(1, 0, 0);

        System.out.println(answer);
    }

    static void dfs(int depth, int x, int y) {
        answer = Math.max(depth, answer);

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && !set.contains(board[nextX][nextY])) {
                set.add(board[nextX][nextY]);
                dfs(depth + 1, nextX, nextY);
                set.remove(board[nextX][nextY]);
            }
        }
    }
}