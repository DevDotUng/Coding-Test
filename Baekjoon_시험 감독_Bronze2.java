import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] persons = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            persons[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");

        int b = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        long coach = 0;

        for (int person: persons) {
            if (person <= b) {
                coach++;
            } else {
                person -= b;
                coach++;

                coach += person / c;

                if (person % c != 0) coach++;
            }
        }

        System.out.println(coach);
    }
}