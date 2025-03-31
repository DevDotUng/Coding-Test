import java.io.*;

public class Main {

    static int[] dice = new int[] {1, 2, 3, 4, 5, 6};
    static int[] diceNumber = new int[] {0, 0, 0, 0, 0, 0};
    static char[] direction = new char[] {'u', 's', 'e', 'w', 'n', 'd'};
    static int[][] map;
    static int x;
    static int y;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2]);
        y = Integer.parseInt(input[3]);
        int k = Integer.parseInt(input[4]);

        map = new int[n][m];
        int[] commands = new int[k];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");

            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(input[j]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < k; i++)
            commands[i] = Integer.parseInt(input[i]);

        for (int command: commands) {
            switch (command) {
                case 1:
                if (y + 1 < m) {
                    y++;
                    east();
                }
                break;

                case 2:
                if (y - 1 >= 0) {
                    y--;
                    west();
                }
                break;

                case 3:
                if (x - 1 >= 0) {
                    x--;
                    north();
                }
                break;

                case 4:
                if (x + 1 < n) {
                    x++;
                    south();
                }
                break;

                default:
                break;
            }
        }
    }

    static void east() {
        swap(0, 3);
        swap(2, 5);
        swap(2, 3);
        write();
    }

    static void west() {
        swap(0, 3);
        swap(2, 5);
        swap(0, 5);
        write();
    }

    static void north() {
        swap(0, 5);
        swap(0, 1);
        swap(4, 5);
        write();
    }

    static void south() {
        swap(1, 4);
        swap(0, 1);
        swap(4, 5);
        write();
    }

    static void swap(int i, int j) {
        int tmpDice = dice[i];
        int tmpNum = diceNumber[i];

        dice[i] = dice[j];
        diceNumber[i] = diceNumber[j];

        dice[j] = tmpDice;
        diceNumber[j] = tmpNum;
    }

    static void write() {
        if (map[x][y] == 0) {
            map[x][y] = diceNumber[5];
        } else {
            diceNumber[5] = map[x][y];
            map[x][y] = 0;
        }
        
        System.out.println(diceNumber[0]);
    }
}