import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        boolean[] zeroVisited = new boolean[input.length()];
        boolean[] oneVisited = new boolean[input.length()];

        int zero = 0;
        int one = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') zero++;
            else one++;
        }

        zero /= 2;
        one /= 2;

        int count = 0;
        int i = input.length() - 1;
        while (count < zero) {
            if (input.charAt(i) == '0') {
                zeroVisited[i] = true;
                count++;
            }
            i--;
        }

        count = 0;
        i = 0;
        while (count < one) {
            if (input.charAt(i) == '1') {
                oneVisited[i] = true;
                count++;
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();

        for (i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') {
                if (!zeroVisited[i]) sb.append('0');
            } else {
                if (!oneVisited[i]) sb.append('1');
            }
        }

        System.out.println(sb);
    }
}