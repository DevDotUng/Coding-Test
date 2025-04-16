import java.io.*;
import java.util.*;

public class Main {

    static int P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        P = Integer.parseInt(br.readLine());

        for (int i = 0; i < P; i++) {
            String[] input = br.readLine().split(" ");
            int count = 0;
            List<Integer> list1 = new ArrayList<>();
            list1.add(Integer.parseInt(input[1]));

            for (int j = 2; j <= 20; j++) {
                List<Integer> list2 = new ArrayList<>();
                int student = Integer.parseInt(input[j]);
                boolean isAdd = false;

                for (int l: list1) {
                    if (!isAdd && l > student) {
                        list2.add(student);
                        list2.add(l);
                        isAdd = true;
                    } else {
                        list2.add(l);
                    }

                    if (isAdd) count++;
                }

                if (!isAdd) list2.add(student);

                list1 = list2;
            }

            sb.append(input[0]).append(" ").append(count).append("\n");
        }

        System.out.print(sb);
    }
}