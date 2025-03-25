import java.io.*;
import java.util.*;

public class Main {

    static int n, m, answer = -1;
    static List<Coordinate> houseList = new ArrayList<>(), chickenList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(input[j]);
                if (num == 1) {
                    houseList.add(new Coordinate(i, j));
                } else if (num == 2) {
                    chickenList.add(new Coordinate(i, j));
                }
            }
        }
        visited = new boolean[chickenList.size()];

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int depth, int count) {
        if (depth == m) {
            int distance = 0;
            for (Coordinate house: houseList) {
                int min = -1;
                int i = 0;
                for (Coordinate chicken: chickenList) {
                    if (visited[i]) {
                        int d = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                        min = min == -1 ? d : Math.min(d, min);
                    }
                    i++;
                }
                distance += min;
            }

            answer = answer == -1 ? distance : Math.min(distance, answer);

            return;
        }

        for (int i = count; i < chickenList.size(); i++) {
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }
}

class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}