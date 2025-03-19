import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main {
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < 8; i++)
            arr.add(Integer.parseInt(st.nextToken()));
        int[] array = {arr.get(0), arr.get(1), arr.get(2), arr.get(3), arr.get(4), arr.get(5), arr.get(6), arr.get(7)};
        permutation(array, 0, 7);

        StringBuilder sb = new StringBuilder();

        sb.append(Integer.toString(count));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void permutation(int[] arr, int start, int end) {
        if (start == end) {
            if (isConvexity(arr))
                count++;
        } else {
            for (int i = start; i <= end; i++) {
                swap(arr, start, i);
                permutation(arr, start + 1, end);
                swap(arr, start, i);
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }

    static boolean isConvexity(int[] arr) {

        double[][] tempArr = new double[2][8];

        tempArr[0][0] = 0;
        tempArr[1][0] = arr[0];

        tempArr[0][1] = arr[1] / Math.sqrt(2);
        tempArr[1][1] = arr[1] / Math.sqrt(2);

        tempArr[0][2] = arr[2];
        tempArr[1][2] = 0;

        tempArr[0][3] = arr[3] / Math.sqrt(2);
        tempArr[1][3] = -arr[3] / Math.sqrt(2);

        tempArr[0][4] = 0;
        tempArr[1][4] = -arr[4];

        tempArr[0][5] = -arr[5] / Math.sqrt(2);
        tempArr[1][5] = -arr[5] / Math.sqrt(2);

        tempArr[0][6] = -arr[6];
        tempArr[1][6] = 0;

        tempArr[0][7] = -arr[7] / Math.sqrt(2);
        tempArr[1][7] = arr[7] / Math.sqrt(2);

        for (int i = 0; i < 6; i++) {
            if (!isConvexityTriangle(tempArr[0][i], tempArr[1][i], tempArr[0][i+1], tempArr[1][i+1], tempArr[0][i+2], tempArr[1][i+2]))
                return false;
        }
        if (!isConvexityTriangle(tempArr[0][6], tempArr[1][6], tempArr[0][7], tempArr[1][7], tempArr[0][0], tempArr[1][0]))
            return false;
        if (!isConvexityTriangle(tempArr[0][7], tempArr[1][7], tempArr[0][0], tempArr[1][0], tempArr[0][1], tempArr[1][1]))
            return false;
        return true;
    }

    static boolean isConvexityTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double direction = x1 * (y2 - y3) - y1 * (x2 - x3) + x2 * y3 - x3 * y2;
        return direction <= 0;
    }
}