import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] ground, nutrients;
    static Trees[][] trees;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        ground = new int[n][n];
        nutrients = new int[n][n];
        trees = new Trees[n][n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                ground[i][j] = 5;
                nutrients[i][j] = Integer.parseInt(input[j]);
                trees[i][j] = new Trees(i, j);
            }
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int z = Integer.parseInt(input[2]);

            trees[x - 1][y - 1].tree.add(z);
        }

        for (int i = 0; i < k; i++) {
            spring();
            summer();
            autumn();
            winter();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> t = trees[i][j].tree;
                answer += t.size();
            }
        }

        System.out.println(answer);
    }

    static void spring() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> t = trees[i][j].tree;
                List<Integer> dt = trees[i][j].deadTree;
                if (!t.isEmpty()) {
                    Collections.sort(t);

                    int l;
                    for (l = 0; l < t.size(); l++) {
                        if (t.get(l) <= ground[i][j]) {
                            ground[i][j] -= t.get(l);
                            t.set(l, t.get(l) + 1);
                        } else {
                            break;
                        }
                    }

                    for (int o = t.size() - 1; o >= l; o--) {
                        dt.add(t.remove(o));
                    }
                }
            }
        }
    }

    static void summer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> dt = trees[i][j].deadTree;
                if (!dt.isEmpty()) {
                    for (int l = dt.size() - 1; l >= 0; l--) {
                        ground[i][j] += dt.remove(l) / 2;
                    }
                }
            }
        }
    }

    static void autumn() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> t = trees[i][j].tree;
                if (!t.isEmpty()) {
                    for (int l = 0; l < t.size(); l++) {
                        if (t.get(l) % 5 == 0) {
                            for (int o = 0; o < 8; o++) {
                                int nextX = i + dx[o];
                                int nextY = j + dy[o];

                                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                                    trees[nextX][nextY].tree.add(1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ground[i][j] += nutrients[i][j];
            }
        }
    }
}

class Trees {
    int x;
    int y;
    List<Integer> tree;
    List<Integer> deadTree;

    Trees(int x, int y) {
        this.x = x;
        this.y = y;
        tree = new ArrayList<>();
        deadTree = new ArrayList<>();
    }
}