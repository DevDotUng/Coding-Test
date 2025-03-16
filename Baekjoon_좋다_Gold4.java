import java.io.*;
import java.util.*;

public class Main {

    static int N, answer = 0;
    static Integer[] numbers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new Integer[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(numbers);

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;

            while (true) {
                if (i == left) left++;
                else if (i == right) right--;

                if (left >= right) break;

                if (numbers[left] + numbers[right] < numbers[i]) left++;
                else if (numbers[left] + numbers[right] > numbers[i]) right--;
                else {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}