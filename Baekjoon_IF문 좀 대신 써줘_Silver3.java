import java.io.*;

public class Main {

    static int N, M;
    static int[] characters;
    static Style[] styles;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        styles = new Style[N];
        characters = new int[M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            styles[i] = new Style(input[0], Integer.parseInt(input[1]));
        }

        for (int i = 0; i < M; i++) {
            characters[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(characters[i])).append("\n");
        }

        System.out.println(sb);
    }

    static String binarySearch(int character) {
        int left = 0;
        int right = N - 1;
        
        while (left <= right) {
            int center = (left + right) / 2;

            if (styles[center].strength < character) {
                left = center + 1;
            } else {
                right = center - 1;
            }
        }

        return styles[left].name;
    }
}

class Style {
    String name;
    int strength;

    Style(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }
}