import java.io.*;
import java.util.*;

public class Softeer_GPT식 숫자 비교_Lv2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++)
            arr[i] = br.readLine();

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] split1 = s1.split("\\.");
                String[] split2 = s2.split("\\.");

                int x1 = Integer.parseInt(split1[0]);
                int y1 = split1.length == 2 ? Integer.parseInt(split1[1]) : -1;
                int x2 = Integer.parseInt(split2[0]);
                int y2 = split2.length == 2 ? Integer.parseInt(split2[1]) : -1;

                if (y1 == -1 && y2 == -1) {
                    return x1 - x2;
                }

                if (y1 == -1 || y2 == -1) {
                    if (x1 == x2) {
                        return y1 == -1 ? -1 : 1;
                    } else {
                        return x1 - x2;
                    }
                }

                if (x1 < x2) {
                    return -1;
                } else if (x1 > x2) {
                    return 1;
                } else {
                    return y1 - y2;
                }
            }
        });

        for (int i = 0; i < N; i++)
            System.out.println(arr[i]);
    }
}