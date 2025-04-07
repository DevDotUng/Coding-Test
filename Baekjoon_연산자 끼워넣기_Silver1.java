import java.io.*;
import java.util.*;

public class Main {

    static int n, max = -1000000000, min = 1000000000;
    static int[] arr, indexArr;
    static boolean[] visited;
    static char[] operatorArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int init = Integer.parseInt(input[0]);
        arr = new int[n - 1];
        indexArr = new int[n - 1];
        visited = new boolean[n - 1];

        for (int i = 0; i < n - 1; i++)
            arr[i] = Integer.parseInt(input[i + 1]);

        input = br.readLine().split(" ");

        operatorArr = new char[Integer.parseInt(input[0]) + Integer.parseInt(input[1]) + Integer.parseInt(input[2]) + Integer.parseInt(input[3])];

        int i;
        for (i = 0; i < Integer.parseInt(input[0]); i++)
            operatorArr[i] = '+';

        for (int j = i; i < j + Integer.parseInt(input[1]); i++)
            operatorArr[i] = '-';

        for (int j = i; i < j + Integer.parseInt(input[2]); i++)
            operatorArr[i] = '*';

        for (int j = i; i < j + Integer.parseInt(input[3]); i++)
            operatorArr[i] = '/';

        dfs(0, init);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, int init) {
        if (depth == n - 1) {
            Queue<Calculation> queue = new LinkedList<>();

            for (int i = 0; i < n - 1; i++)
                queue.offer(new Calculation(operatorArr[indexArr[i]], arr[i]));

            int result = calculate(init, queue);

            max = Math.max(result, max);
            min = Math.min(result, min);

            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                indexArr[depth] = i;
                dfs(depth + 1, init);
                visited[i] = false;
            }
        }
    }

    static int calculate(int init, Queue<Calculation> queue) {
        while (!queue.isEmpty()) {
            Calculation c = queue.poll();
            switch (c.operator) {
                case '+':
                    init += c.value;
                    break;
                case '-':
                    init -= c.value;
                    break;
                case '*':
                    init *= c.value;
                    break;
                case '/':
                    if (init < 0) init = -(-init / c.value);
                    else init /= c.value;
                    break;
                default:
                    break;
            }
        }

        return init;
    }
}

class Calculation {
    char operator;
    int value;

    Calculation(char operator, int value) {
        this.operator = operator;
        this.value = value;
    }
}