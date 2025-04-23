import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int length = 64;
        int shortest = 64;
        int count = 1;

        if (x == 64) {
            System.out.println(1);
            return;
        }

        while (true) {
            if (length - shortest / 2 == x) {
                break;
            } else if (length - shortest / 2 > x) {
                length -= shortest / 2;
                shortest /= 2;
            } else {
                shortest /= 2;
                count++;
            }
        }

        System.out.println(count);
    }
}