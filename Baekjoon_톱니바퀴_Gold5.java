import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] gear1 = new int[8];
        int[] gear2 = new int[8];
        int[] gear3 = new int[8];
        int[] gear4 = new int[8];

        String[] input = br.readLine().split("");
        for (int i = 0; i < 8; i++)
            if (input[i].equals("1")) gear1[i] = 1;

        input = br.readLine().split("");
        for (int i = 0; i < 8; i++)
            if (input[i].equals("1")) gear2[i] = 1;

        input = br.readLine().split("");
        for (int i = 0; i < 8; i++)
            if (input[i].equals("1")) gear3[i] = 1;

        input = br.readLine().split("");
        for (int i = 0; i < 8; i++)
            if (input[i].equals("1")) gear4[i] = 1;

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");

            int num = Integer.parseInt(input[0]);
            int dir = Integer.parseInt(input[1]);

            if (num == 1) {
                boolean move2 = false;
                int dir2 = dir == -1 ? 1 : -1;
                boolean move3 = false;
                int dir3 = dir;
                boolean move4 = false;
                int dir4 = dir == -1 ? 1 : -1;
                
                if (gear1[2] != gear2[6]) move2 = true;
                if (gear2[2] != gear3[6]) move3 = true;
                if (gear3[2] != gear4[6]) move4 = true;

                rotate(gear1, dir);
                if (move2) {
                    rotate(gear2, dir2);
                }
                if (move2 && move3) {
                    rotate(gear3, dir3);
                }
                if (move2 && move3 && move4) {
                    rotate(gear4, dir4);
                }
            } else if (num == 2) {
                boolean move1 = false;
                int dir1 = dir == -1 ? 1 : -1;
                boolean move3 = false;
                int dir3 = dir == -1 ? 1 : -1;
                boolean move4 = false;
                int dir4 = dir;
                
                if (gear1[2] != gear2[6]) move1 = true;
                if (gear2[2] != gear3[6]) move3 = true;
                if (gear3[2] != gear4[6]) move4 = true;

                rotate(gear2, dir);
                if (move1) {
                    rotate(gear1, dir1);
                }
                if (move3) {
                    rotate(gear3, dir3);
                }
                if (move3 && move4) {
                    rotate(gear4, dir4);
                }
            } else if (num == 3) {
                boolean move1 = false;
                int dir1 = dir;
                boolean move2 = false;
                int dir2 = dir == -1 ? 1 : -1;
                boolean move4 = false;
                int dir4 = dir == -1 ? 1 : -1;
                
                if (gear1[2] != gear2[6]) move1 = true;
                if (gear2[2] != gear3[6]) move2 = true;
                if (gear3[2] != gear4[6]) move4 = true;

                rotate(gear3, dir);
                if (move4) {
                    rotate(gear4, dir4);
                }
                if (move2) {
                    rotate(gear2, dir2);
                }
                if (move2 && move1) {
                    rotate(gear1, dir1);
                }
            } else {
                boolean move1 = false;
                int dir1 = dir == -1 ? 1 : -1;
                boolean move2 = false;
                int dir2 = dir;
                boolean move3 = false;
                int dir3 = dir == -1 ? 1 : -1;
                
                if (gear1[2] != gear2[6]) move1 = true;
                if (gear2[2] != gear3[6]) move2 = true;
                if (gear3[2] != gear4[6]) move3 = true;

                rotate(gear4, dir);
                if (move3) {
                    rotate(gear3, dir3);
                }
                if (move3 && move2) {
                    rotate(gear2, dir2);
                }
                if (move3 && move2 && move1) {
                    rotate(gear1, dir1);
                }
            }
        }

        System.out.println(gear1[0] + gear2[0] * 2 + gear3[0] * 4 + gear4[0] * 8);
    }

    static void rotate(int[] gear, int dir) {
        if (dir == 1) {
            int tmp = gear[7];
            for (int i = 6; i >= 0; i--) {
                gear[i + 1] = gear[i];
            }
            gear[0] = tmp;
        } else {
            int tmp = gear[0];
            for (int i = 0; i < 7; i++) {
                gear[i] = gear[i + 1];
            }
            gear[7] = tmp;
        }
    }
}