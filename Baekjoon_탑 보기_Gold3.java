import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] buildings;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        buildings = new int[N];
        Stack<Integer> stack = new Stack<>();
        int[] leftArr = new int[N];
        int[] rightArr = new int[N];
        int[] countArr = new int[N];

        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(input[i]);
            leftArr[i] = -1;
            rightArr[i] = -1;
        }

        // 왼쪽에서 오른쪽
        for (int i = 1; i < N; i++) {
            if (buildings[i] < buildings[i - 1]) {
                stack.push(i - 1);
                leftArr[i] = i - 1;
                countArr[i] += stack.size();
            } else if (buildings[i] == buildings[i - 1]) {
                leftArr[i] = stack.isEmpty() ? -1 : stack.peek();
                countArr[i] += stack.size();
            } else {
                while (!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]) {
                    stack.pop();
                }

                leftArr[i] = stack.isEmpty() ? -1 : stack.peek();
                countArr[i] += stack.size();
            }
        }

        stack.clear();

        // 오른쪽에서 왼쪽
        for (int i = N - 2; i >= 0; i--) {
            if (buildings[i] < buildings[i + 1]) {
                stack.push(i + 1);
                rightArr[i] = i + 1;
                countArr[i] += stack.size();
            } else if (buildings[i] == buildings[i + 1]) {
                rightArr[i] = stack.isEmpty() ? -1 : stack.peek();
                countArr[i] += stack.size();
            } else {
                while (!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]) {
                    stack.pop();
                }

                rightArr[i] = stack.isEmpty() ? -1 : stack.peek();
                countArr[i] += stack.size();
            }
        }

        for (int i = 0; i < N; i++) {
            if (countArr[i] == 0) {
                System.out.println(0);
                continue;
            }

            int close = 0;

            if (leftArr[i] == -1) {
                close = rightArr[i];
            } else if (rightArr[i] == -1) {
                close = leftArr[i];
            } else {
                close = i - leftArr[i] <= rightArr[i] - i ? leftArr[i] : rightArr[i];
            }

            System.out.println(countArr[i] + " " + (close + 1));
        }
    }
}