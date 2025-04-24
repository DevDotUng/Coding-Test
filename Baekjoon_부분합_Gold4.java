import java.io.*;

public class Main {

    static int N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] arr = new int[N + 1];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            sum += arr[i];
        }

        if (sum < S) {
            System.out.println(0);
            return;
        }

        int left = 0;
        int right = 0;
        sum = 0;
        int length = N + 1;

        while (left <= right && right <= N) {
            if (sum < S) {
                sum += arr[right++];
            } else {
                length = Math.min(length, right - left);
                sum -= arr[left++];
            }
        }

        System.out.println(length == N + 1 ? 0 :length);
    }
}