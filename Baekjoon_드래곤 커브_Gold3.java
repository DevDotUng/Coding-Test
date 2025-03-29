import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;
    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[102][102];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);
            int g = Integer.parseInt(input[3]);

            List<Curve> curves = new ArrayList<>();
            curves.add(new Curve(x, y, d));

            dragonCurve(g, 0, curves, board);
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1]) {
                    answer++;;
                }
            }
        }

        System.out.println(answer);
    }

    static void dragonCurve(int generation, int depth, List<Curve> curves, boolean[][] board) {
        if (depth == generation) {
            for (int i = 0; i < curves.size(); i++) {
                Curve curve = curves.get(i);
                board[curve.y][curve.x] = true;
            }

            int nextX = curves.get(curves.size() - 1).x + dx[curves.get(curves.size() - 1).dir];
            int nextY = curves.get(curves.size() - 1).y + dy[curves.get(curves.size() - 1).dir];
            board[nextY][nextX] = true;

            return;
        }

        int size = curves.size();

        int preX = 0;
        int preY = 0;
        int preDir = 0;

        for (int i = size - 1; i >= 0; i--) {
            Curve curve = curves.get(i);

            int nextX = i == size - 1 ? curve.x + dx[curve.dir] : preX + dx[preDir];
            int nextY = i == size - 1 ? curve.y + dy[curve.dir] : preY + dy[preDir];
            int nextDir = (curve.dir + 1) % 4;

            preX = nextX;
            preY = nextY;
            preDir = nextDir;

            curves.add(new Curve(nextX, nextY, nextDir));
        }

        dragonCurve(generation, depth + 1, curves, board);
    }
}

class Curve {
    int x;
    int y;
    int dir;

    Curve(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}