import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static int[] belt;
    static Queue<Integer> robots;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        belt = new int[2 * n];
        robots = new LinkedList<>();

        input = br.readLine().split(" ");
        for (int i = 0; i < 2 * n; i++) {
            belt[i] = Integer.parseInt(input[i]);
        }

        int level = 0;
        while (getZeroBlock() < k) {
            level++;
            rotate();
            move();
            addRobot(level);
        }

        System.out.println(level);
    }

    static void rotate() {
        int tmp = belt[2 * n - 1];
        
        for (int i = 2 * n - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }

        belt[0] = tmp;

        Queue<Integer> queue = new LinkedList<>();

        while (!robots.isEmpty()) {
            int robot = robots.poll();

            if (robot == n - 2) continue;

            robot++;

            queue.offer(robot);
        }

        robots = queue;
    }

    static void move() {
        Queue<Integer> queue = new LinkedList<>();

        while (!robots.isEmpty()) {
            int robot = robots.poll();

            if (robot == n - 2 && belt[n - 1] >= 1) {
                belt[n - 1]--;
                continue;
            }

            if (!(robots.contains(robot + 1) || queue.contains(robot + 1)) && belt[robot + 1] >= 1) {
                robot += 1;
                belt[robot]--;
            }

            queue.offer(robot);
        }

        robots = queue;
    }

    static void addRobot(int id) {
        if (belt[0] > 0) {
            robots.offer(0);
            belt[0]--;
        }
    }

    static int getZeroBlock() {
        int zeroBlock = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (belt[i] <= 0) zeroBlock++;
        }
        return zeroBlock;
    }
}