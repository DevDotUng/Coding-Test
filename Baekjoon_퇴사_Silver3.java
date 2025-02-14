import java.io.*;

public class Main {

    static int answer;
    static int[][] counsel;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        counsel = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            counsel[i][0] = Integer.parseInt(input[0]);
            counsel[i][1] = Integer.parseInt(input[1]);
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int depth, int money) {
        if (depth >= counsel.length) {
            answer = Math.max(money, answer);

            return;
        }

        dfs(depth + 1, money);
        if (depth + counsel[depth][0] <= counsel.length)
            dfs(depth + counsel[depth][0], money + counsel[depth][1]);
    }
}