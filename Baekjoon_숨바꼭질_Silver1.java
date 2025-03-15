import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(N, 0));

        while (!queue.isEmpty()) {
            Location location = queue.poll();

            if (location.point == K) return location.count;

            if (location.point - 1 >= 0 && !visited[location.point - 1]) {
                queue.offer(new Location(location.point - 1, location.count + 1));
                visited[location.point - 1] = true;
            }
            if (location.point + 1 <= 100000 && !visited[location.point + 1]) {
                queue.offer(new Location(location.point + 1, location.count + 1));
                visited[location.point + 1] = true;
            }
            if (location.point * 2 <= 100000 && !visited[location.point * 2]) {
                queue.offer(new Location(location.point * 2, location.count + 1));
                visited[location.point * 2] = true;
            }
        }

        return 100000;
    }
}

class Location {
    int point;
    int count;

    Location(int point, int count) {
        this.point = point;
        this.count = count;
    }
}