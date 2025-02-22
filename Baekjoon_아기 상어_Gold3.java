import java.io.*;
import java.util.*;

public class Main {

    static int n, x, y, scale = 2, feed = 0, second = 0;
    static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
    static int[][] area;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        area = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (input[j].equals("9")) {
                    x = i;
                    y = j;
                } else {
                    area[i][j] = Integer.parseInt(input[j]);
                }
            }
        }

        while (true) {
            boolean containFish = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (area[i][j] < scale) {
                        containFish = true;
                        break;
                    }
                }
            }
            if (!containFish) break;

            visited = new boolean[n][n];
            int s = bfs();

            if (s == -1) break;

            second += s;
        }

        System.out.println(second);
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        List<Point> list = new ArrayList<>();

        queue.offer(new Point(x, y, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY] && area[nextX][nextY] <= scale) {
                    if (area[nextX][nextY] == scale) {
                        visited[nextX][nextY] = true;
                        queue.offer(new Point(nextX, nextY, point.second + 1));
                    } else if (area[nextX][nextY] > 0) {
                        if (list.isEmpty()) {
                            list.add(new Point(nextX, nextY, point.second + 1));
                        } else {
                            if (list.get(list.size() - 1).second < point.second + 1) {
                                queue.clear();
                                break;
                            } else {
                                list.add(new Point(nextX, nextY, point.second + 1));
                            }
                        }
                    } else {
                        visited[nextX][nextY] = true;
                        queue.offer(new Point(nextX, nextY, point.second + 1));
                    }
                }
            }
        }

        if (list.isEmpty()) {
            return -1;
        } else {
            Collections.sort(list, (p1, p2) -> (p1.x == p2.x ? p1.y - p2.y : p1.x - p2.x));
            feed++;
            area[list.get(0).x][list.get(0).y] = 0;
            if (feed >= scale) feed -= scale++;
            x = list.get(0).x;
            y = list.get(0).y;
            return list.get(0).second;
        }
    }
}

class Point {
    int x;
    int y;
    int second;

    Point(int x, int y, int second) {
        this.x = x;
        this.y = y;
        this.second = second;
    }
}