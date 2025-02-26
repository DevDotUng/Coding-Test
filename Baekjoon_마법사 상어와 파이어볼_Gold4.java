import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}, dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static Block[][] blocks;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        blocks = new Block[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                blocks[i][j] = new Block(i, j);
            }
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");

            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            int m = Integer.parseInt(input[2]);
            int s = Integer.parseInt(input[3]);
            int d = Integer.parseInt(input[4]);

            blocks[r - 1][c - 1].fireballs.offer(new Fireball(m, s, d));
        }

        for (int i = 0; i < K; i++) {
            List<FireballTmp> fireballTmps = new ArrayList<>();

            // 이동
            for (int j = 0; j < blocks.length; j++) {
                for (int k = 0; k < blocks[0].length; k++) {
                    while (!blocks[j][k].fireballs.isEmpty()) {
                        Fireball ball = blocks[j][k].fireballs.poll();

                        int nextR = (j + N + dr[ball.d] * (ball.s%N)) % N;
                        int nextC = (k + N + dc[ball.d] * (ball.s%N)) % N;

                        while (!(nextR >= 0 && nextR < N && nextC >= 0 && nextC < N)) {
                            nextR -= dr[ball.d];
                            nextC -= dc[ball.d];
                        }

                        fireballTmps.add(new FireballTmp(nextR, nextC, ball.m, ball.s,  ball.d));
                    }
                }
            }

            // blocks에 채우기
            for (FireballTmp fireballTmp: fireballTmps) {
                blocks[fireballTmp.r][fireballTmp.c].fireballs.offer(new Fireball(fireballTmp.m, fireballTmp.s, fireballTmp.d));
            }

            for (int j = 0; j < blocks.length; j++) {
                for (int k = 0; k < blocks[0].length; k++) {
                    if (blocks[j][k].fireballs.size() >= 2) {
                        int even = 0;
                        int odd = 0;

                        int m = 0;
                        int s = 0;
                        int count = blocks[j][k].fireballs.size();

                        while (!blocks[j][k].fireballs.isEmpty()) {
                            Fireball ball = blocks[j][k].fireballs.poll();
                            
                            m += ball.m;
                            s += ball.s;
                            if (ball.d % 2 == 0) even++;
                            else odd++;
                        }

                        boolean equal = even == 0 || odd == 0;

                        if (m / 5 > 0) {
                            for (int l = 0; l < 4; l++) {
                                blocks[j][k].fireballs.offer(new Fireball(m / 5, s / count, equal ? l * 2 : l * 2 + 1));
                            }
                        }
                    }
                }
            }
        }

        int weight = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                while (!blocks[i][j].fireballs.isEmpty()) {
                    weight += blocks[i][j].fireballs.poll().m;
                }
            }
        }

        System.out.println(weight);
    }
}

class Block {
    int r;
    int c;
    Queue<Fireball> fireballs;

    Block(int r, int c) {
        this.r = r;
        this.c = c;
        fireballs = new LinkedList<>();
    }
}

class Fireball {
    int m;
    int s;
    int d;

    Fireball(int m, int s, int d) {
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

class FireballTmp {
    int r;
    int c;
    int m;
    int s;
    int d;

    FireballTmp(int r, int c, int m, int s, int d) {
        this.r = r;
        this.c = c;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}