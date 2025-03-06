import java.io.*;
import java.util.*;

public class Main {

    static int r, c, k;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < 101; i++) {
            if (arr.length > r - 1 && arr[0].length > c - 1 && arr[r - 1][c - 1] == k) {
                System.out.println(i);
                return;
            }

            if (arr.length >= arr[0].length) {
                int n = arr.length;
                PQ[] pqs = new PQ[n];
                for (int j = 0; j < n; j++) {
                    HashMap<Integer, Integer> map = new HashMap<>();
                    pqs[j] = new PQ();
                    for (int k = 0; k < arr[0].length; k++) {
                        if (arr[j][k] != 0) {
                            if (map.containsKey(arr[j][k])) {
                                map.put(arr[j][k], map.get(arr[j][k]) + 1);
                            } else {
                                map.put(arr[j][k], 1);
                            }
                        }
                    }
                    
                    for (int k: map.keySet()) {
                        pqs[j].pq.offer(new Num(k, map.get(k)));
                    }
                }

                int size = 0;
                for (int j = 0; j < n; j++) {
                    size = Math.max(pqs[j].pq.size(), size);
                }
                size *= 2;

                arr = new int[n][size];

                for (int j = 0; j < n; j++) {
                    int k = 0;
                    while (!pqs[j].pq.isEmpty()) {
                        Num num = pqs[j].pq.poll();
                        arr[j][k] = num.n;
                        arr[j][k + 1] = num.number;
                        k += 2;
                    }
                }
            } else {
                int n = arr[0].length;
                PQ[] pqs = new PQ[n];
                for (int j = 0; j < n; j++) {
                    HashMap<Integer, Integer> map = new HashMap<>();
                    pqs[j] = new PQ();
                    for (int k = 0; k < arr.length; k++) {
                        if (arr[k][j] != 0) {
                            if (map.containsKey(arr[k][j])) {
                                map.put(arr[k][j], map.get(arr[k][j]) + 1);
                            } else {
                                map.put(arr[k][j], 1);
                            }
                        }
                    }
                    
                    for (int k: map.keySet()) {
                        pqs[j].pq.offer(new Num(k, map.get(k)));
                    }
                }

                int size = 0;
                for (int j = 0; j < n; j++) {
                    size = Math.max(pqs[j].pq.size(), size);
                }
                size *= 2;

                arr = new int[size][n];

                for (int j = 0; j < n; j++) {
                    int k = 0;
                    while (!pqs[j].pq.isEmpty()) {
                        Num num = pqs[j].pq.poll();
                        arr[k][j] = num.n;
                        arr[k + 1][j] = num.number;
                        k += 2;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}

class PQ {
    PriorityQueue<Num> pq;

    PQ() {
        this.pq = new PriorityQueue<>((o1, o2) -> (o1.number == o2.number ? o1.n - o2.n : o1.number - o2.number));
    }
}

class Num {
    int n;
    int number;

    Num(int n, int number) {
        this.n = n;
        this.number = number;
    }
}