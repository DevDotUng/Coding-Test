import java.io.*;

public class Main {

    static int n, diff = -1;
    static int[][] ability;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ability = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0, 0);

        System.out.println(diff);
    }

    static void dfs(int depth, int start) {
        if (depth == n / 2) {
            int startSum = 0;
            int linkSum = 0;
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == j) continue;
    
                    if(visited[i] && visited[j]) startSum += ability[i][j];
                    if(!visited[i] && !visited[j]) linkSum += ability[i][j];
                }
            }

            diff = diff == -1 ? Math.abs(startSum - linkSum) : Math.min(Math.abs(startSum - linkSum), diff);

            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }
}