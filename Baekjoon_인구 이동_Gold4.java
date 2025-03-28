import java.io.*;
import java.util.*;

public class Main {

    static int n, l, r;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] ground;
    static boolean[][] visited, path;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        l = Integer.parseInt(input[1]);
        r = Integer.parseInt(input[2]);

        ground = new int[n][n];
        visited = new boolean[n][n];
        path = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                ground[i][j] = Integer.parseInt(input[j]);
            }
        }

        int answer = 0;

        while (true) {
            visited = new boolean[n][n];
            path = new boolean[n][n];
            boolean move = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];

                        if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && Math.abs(ground[i][j] - ground[nextX][nextY]) >= l && Math.abs(ground[i][j] - ground[nextX][nextY]) <= r) {
                            move = true;
                            break;
                        }
                    }
                }
            }

            if (!move) break;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        bfs(new Point(i, j, ground[i][j]));
                    }
                }
            }

            answer++;
        }

        System.out.println(answer);
    }

    static void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        List<Point> list = new ArrayList<>();

        queue.offer(point);
        list.add(point);
        visited[point.x][point.y] = true;
        int people = point.people;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY] && Math.abs(ground[p.x][p.y] - ground[nextX][nextY]) >= l && Math.abs(ground[p.x][p.y] - ground[nextX][nextY]) <= r) {
                    queue.offer(new Point(nextX, nextY, ground[nextX][nextY]));
                    list.add(new Point(nextX, nextY, ground[nextX][nextY]));
                    people += ground[nextX][nextY];
                    visited[nextX][nextY] = true;
                }
            }
        }

        for (Point p: list) {
            ground[p.x][p.y] = people / list.size();
        }
    }
}

class Point {
    int x;
    int y;
    int people;

    Point(int x, int y, int people) {
        this.x = x;
        this.y = y;
        this.people = people;
    }
}