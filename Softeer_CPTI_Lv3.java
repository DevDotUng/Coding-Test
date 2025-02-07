// 비트연산

import java.io.*;
import java.util.*;

public class Softeer_CPTI_Lv3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);
        int answer = 0;
        int[] arr = new int[N];

        if (M < 3) {
            System.out.println(N * (N - 1) / 2);
            return;
        }

        arr[0] = Integer.parseInt(br.readLine(), 2);
        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine(), 2);
            for (int j = 0; j < i; j++) {
                if (isFriendly(arr[i], arr[j])) answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean isFriendly(int i1, int i2) {
        return Integer.bitCount(i1^i2) <= 2;
    }
}