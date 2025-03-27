import java.io.*;

public class Main {

    static int n, l;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        l = Integer.parseInt(input[1]);
        map = new int[n][n];
        visited = new boolean[n][n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            boolean isRoad = true;
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] > map[i][j + 1]) {
                    if (j + l >= n) {
                        isRoad = false;
                        break;
                    }
                    if (map[i][j] - map[i][j + 1] > 1) {
                        isRoad = false;
                        break;
                    }
                    boolean isSame = true;
                    for (int k = j + 1; k < j + l; k++) {
                        if (map[i][k] != map[i][k + 1]) isSame = false;
                    }
                    if (!isSame) {
                        isRoad = false;
                        break;
                    }

                    for (int k = j + 1; k <= j + l; k++) {
                        visited[i][k] = true;
                    }

                } else if (map[i][j] < map[i][j + 1]) {
                    if (j - l + 1 < 0) {
                        isRoad = false;
                        break;
                    }
                    if (map[i][j + 1] - map[i][j] > 1) {
                        isRoad = false;
                        break;
                    }
                    boolean isSame = true;
                    boolean isVisited = false;
                    for (int k = j - l + 1; k < j; k++) {
                        if (map[i][k] != map[i][k + 1]) isSame = false;
                        if (visited[i][k]) isVisited = true;
                    }
                    if (!isSame) {
                        isRoad = false;
                        break;
                    }
                    if (visited[i][j]) isVisited = true;
                    if (isVisited) {
                        isRoad = false;
                        break;
                    }

                    for (int k = j - l + 1; k <= j; k++) {
                        visited[i][k] = true;
                    }
                }
            }

            if (isRoad) {
                answer++;
            }
        }

        visited = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            boolean isRoad = true;
            for (int i = 0; i < n - 1; i++) {
                if (map[i][j] > map[i + 1][j]) {
                    if (i + l >= n) {
                        isRoad = false;
                        break;
                    }
                    if (map[i][j] - map[i + 1][j] > 1) {
                        isRoad = false;
                        break;
                    }
                    boolean isSame = true;
                    for (int k = i + 1; k < i + l; k++) {
                        if (map[k][j] != map[k + 1][j]) isSame = false;
                    }
                    if (!isSame) {
                        isRoad = false;
                        break;
                    }

                    for (int k = i + 1; k <= i + l; k++) {
                        visited[k][j] = true;
                    }

                } else if (map[i][j] < map[i + 1][j]) {
                    if (i - l + 1 < 0) {
                        isRoad = false;
                        break;
                    }
                    if (map[i + 1][j] - map[i][j] > 1) {
                        isRoad = false;
                        break;
                    }
                    boolean isSame = true;
                    boolean isVisited = false;
                    for (int k = i - l + 1; k < i; k++) {
                        if (map[k][j] != map[k + 1][j]) isSame = false;
                        if (visited[k][j]) isVisited = true;
                    }
                    if (!isSame) {
                        isRoad = false;
                        break;
                    }
                    if (visited[i][j]) isVisited = true;
                    if (isVisited) {
                        isRoad = false;
                        break;
                    }

                    for (int k = i - l + 1; k <= i; k++) {
                        visited[k][j] = true;
                    }
                }
            }

            if (isRoad) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}