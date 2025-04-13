import java.io.*;

public class Main {

    static int N;
    static int[] people;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        people = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(input[i]);
            int height = i + 1;
            int count = 0;

            for (int j = 0; j < N; j++) {
                if (people[j] == 0) {
                    count++;
                    if (count == n + 1) {
                        people[j] = height;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(people[i] + " ");
        }
        System.out.println();;
    }
}