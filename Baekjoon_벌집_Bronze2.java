import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int i;
        int count = 1;
        int num = 1;
        for (i = 6; num < n; i += 6) {
            num += i;
            count++;
        }

        System.out.println(count);
    }
}