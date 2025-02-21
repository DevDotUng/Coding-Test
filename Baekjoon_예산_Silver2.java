import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i: arr) {
            sum += i;
        }

        if (sum <= M) {
            System.out.println(arr[arr.length - 1]);
            return;
        }

        int index = arr.length - 1;
        while (sum > M) {
            for (int i = index; i >= 0; i--) {
                if (i > 0 && arr[i] == arr[i - 1]) {
                    index--;
                } else {
                    break;
                }
            }

            if (index == 1 && arr[0] == arr[1]) index--;

            for (int i = index; i < N; i++) {
                arr[i]--;
                sum--;
            }
        }

        System.out.println(arr[arr.length - 1]);
    }
}