import java.io.*;

public class Main {

    static int N, X;
    static int[] visitor;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);
        visitor = new int[N];

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            visitor[i] = Integer.parseInt(input[i]);
        }

        int visit = 0;
        int max = 0;
        int count = 0;

        for (int i = 0; i < X; i++) {
            visit += visitor[i];
        }

        int left = 0;
        int right = X - 1;

        while (right < N - 1) {
            if (visit > max) {
                max = visit;
                count = 1;
            } else if (visit == max) {
                count++;
            }

            visit -= visitor[left++];
            visit += visitor[++right];
        }

        if (visit > max) {
            max = visit;
            count = 1;
        } else if (visit == max) {
            count++;
        }

        System.out.println(max == 0 ? "SAD" : max + "\n" + count);
    }
}