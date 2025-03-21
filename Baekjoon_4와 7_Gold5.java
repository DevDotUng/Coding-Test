import java.io.*;
import java.lang.StringBuilder;

public class Main {

	static int a, b, K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		a = 4;
		b = 7;
		K = Integer.parseInt(br.readLine());

		int digit = getDigit(K);
        String binaryString = Integer.toBinaryString(getDiff(K));

        int[] arr = new int[digit];

        int j = binaryString.length() - 1;
        for (int i = digit - 1; i > digit - binaryString.length() - 1; i--) {
            arr[i] = 50 - (int) binaryString.charAt(j--);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] == 1 ? b : a);
        }

        System.out.println(sb);
	}

	static int getDigit(int k) {
		int sum = 0;

		int digit = 1;
		while (true) {
			sum += Math.pow(2, digit);

			if (k <= sum) {
				break;
			}

			digit++;
		}
		
		return digit;
	}

	static int getDiff(int k) {
		int preSum = 0;
		int sum = 0;

		int digit = 1;
		while (true) {
			preSum = sum;
			sum += Math.pow(2, digit);

			if (k <= sum) {
				break;
			}

			digit++;
		}
		
		return k - preSum - 1;
	}
}