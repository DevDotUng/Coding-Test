import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> dfsRoute;
    static List<Integer> bfsRoute;

    public static void main(String[] args) throws Exception {
        String answer = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);
        int v = Integer.parseInt(input.split(" ")[2]);

        dfsRoute = new ArrayList<>();
        bfsRoute = new ArrayList<>();

        int[][] nodes = new int[m * 2][2];

        boolean[] visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            String nodeInput = br.readLine();

            nodes[i][0] = Integer.parseInt(nodeInput.split(" ")[0]);
            nodes[i][1] = Integer.parseInt(nodeInput.split(" ")[1]);

            nodes[i + m][0] = Integer.parseInt(nodeInput.split(" ")[1]);
            nodes[i + m][1] = Integer.parseInt(nodeInput.split(" ")[0]);
        }

        Arrays.sort(nodes, (i1, i2) -> i1[0] == i2[0] ? i1[1] - i2[1] : i1[0] - i2[0]);

        visited[v - 1] = true;
        dfsRoute.add(v);
        dfs(v, nodes, visited);
        for (int i = 0; i < dfsRoute.size(); i++) {
            answer += dfsRoute.get(i);
            if (i != n - 1) answer += " ";
        }

        visited = new boolean[n];
        answer += "\n";

        bfs(v, nodes, visited);
        for (int i = 0; i < bfsRoute.size(); i++) {
            answer += bfsRoute.get(i);
            if (i != n - 1) answer += " ";
        }

        System.out.println(answer);
    }

    static void dfs(int v, int[][] nodes, boolean[] visited) {
        for (int[] node: nodes) {
            if (node[0] == v && !visited[node[1] - 1]) {
                visited[node[1] - 1] = true;
                dfsRoute.add(node[1]);
                dfs(node[1], nodes, visited);
            }
        }
    }

    static void bfs(int v, int[][] nodes, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        visited[v - 1] = true;
        bfsRoute.add(v);
        queue.offer(v);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int[] node: nodes) {
                if (node[0] == current && !visited[node[1] - 1]) {
                    visited[node[1] - 1] = true;
                    bfsRoute.add(node[1]);
                    queue.offer(node[1]);
                }
            }
        }
    }
}