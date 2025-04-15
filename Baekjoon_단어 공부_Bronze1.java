import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char alphabet = input.charAt(i);
            if (alphabet >= 'a' && alphabet <= 'z') alphabet = Character.toUpperCase(alphabet);

            if (map.containsKey(alphabet)) {
                map.put(alphabet, map.get(alphabet) + 1);
            } else {
                map.put(alphabet, 1);
            }
        }

        List<int[]> list = new ArrayList<>();

        for (char c: map.keySet())
            list.add(new int[] {(int)c, map.get(c)});

        Collections.sort(list, (i1, i2) -> i2[1] - i1[1]);

        char answer = '?';

        if (list.size() != 1 && list.get(0)[1] == list.get(1)[1]) {
            answer = '?';
        } else {
            answer = (char)list.get(0)[0];
        }

        System.out.println(answer);
    }
}