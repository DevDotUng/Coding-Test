import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = new int[] {0, -1, 0, 1};
    static int[] dy = new int[] {-1, 0, 1, 0};
    static char[] direction = new char[] {'L', 'U', 'R', 'D'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];

        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            board[x - 1][y - 1] = 1;
        }
        board[0][0] = 2;

        List<Integer> moves = new ArrayList<>();
        List<String> moveDirections = new ArrayList<>();
        int l = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            String[] input = br.readLine().split(" ");

            moves.add(Integer.parseInt(input[0]));
            moveDirections.add(input[1]);
        }

        int x = 0;
        int y = 0;
        int dir = 2;
        int i = 0;
        Queue<Coordinate> snake = new LinkedList<>();
        snake.offer(new Coordinate(x, y));

        while (true) {

            if (moves.contains(i)) {
                int index = moves.indexOf(i);
                String d = moveDirections.get(index);

                if (d.equals("L")) {
                    dir = dir == 0 ? 3 : dir - 1;
                } else {
                    dir = (dir + 1) % 4;
                }
            }

            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                if (board[nextX][nextY] == 1) {
                    board[nextX][nextY] = 2;
                    snake.offer(new Coordinate(nextX, nextY));
                } else if (board[nextX][nextY] == 0) {
                    board[nextX][nextY] = 2;
                    snake.offer(new Coordinate(nextX, nextY));
                    Coordinate c = snake.poll();
                    board[c.x][c.y] = 0;
                } else {
                    break;
                }
            } else {
                break;
            }

            x = nextX;
            y = nextY;
            i++;
        }

        System.out.println(i + 1);
    }
}

class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Coordinate) {
            Coordinate c = (Coordinate) o;
            return c.x == this.x && c.y == this.y;
        }
        return false;
    }
}