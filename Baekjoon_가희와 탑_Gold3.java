import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);
        List<Integer> tower = new ArrayList<>();

        if (a + b > n + 1) {
            System.out.println(-1);
            return;
        }

        for (int i = 1; i < a; i++) {
			tower.add(i);
		}
		tower.add(Math.max(a, b));

		for (int i = b - 1; i >= 1; i--) {
			tower.add(i);
		}

		if (a == 1) {
			while (tower.size() < n) {
				tower.add(1, 1);
			}
		} else {
			while (tower.size() < n) {
				tower.add(0, 1);
			}
		}
		for (int i : tower) {
			System.out.print(i + " ");
		}
    }
}