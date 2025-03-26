import java.io.*;
import java.util.HashSet;
import java.lang.StringBuilder;

public class Main {

	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		HashSet<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(",");

			for (int j = 0; j < input.length; j++) {
				if (set.contains(input[j])) set.remove(input[j]);
			}

			sb.append(set.size()).append("\n");
		}

        System.out.println(sb);
	}
}