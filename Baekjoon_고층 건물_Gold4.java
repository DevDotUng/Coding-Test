import java.io.*;

public class Main {

    static int N;
    static int[] buildings, count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        buildings = new int[N];
        count = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int start = i < j ? i + 1 : j + 1;
                int end = i < j ? j - 1 : i - 1;
                if (i != j && canSee(new Building(i, buildings[i]), new Building(j, buildings[j]), start, end)) {
                    count[i]++;
                }
            }
        }

        int max = 0;
        for (int c: count) {
            max = Math.max(c, max);
        }

        System.out.println(max);
    }

    static boolean canSee(Building a, Building b, int start, int end) {
        for (int i = start; i <= end; i++) {
            Building target = new Building(i, buildings[i]);
            if (target.h - a.h >= (double)(a.h - b.h)/(a.i - b.i) * (target.i - a.i)) {
                return false;
            }
        }

        return true;
    }
}

class Building {
    int i;
    int h;

    Building(int i, int h) {
        this.i = i;
        this.h = h;
    }
}