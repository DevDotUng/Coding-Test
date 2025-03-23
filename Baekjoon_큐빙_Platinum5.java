import java.io.*;

public class Main {

    static int n;
    static char[][] up, down, front, behind, left, right;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        initCube();

        for (int i = 0; i < n; i++) {
            int testCase = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < testCase; j++) {
                char face = input[j].charAt(0);
                char dir = input[j].charAt(1);

                turn(face, dir);
            }

            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    sb.append(up[k][l]);
                }
                sb.append("\n");
            }

            initCube();
        }

        System.out.println(sb);
    }

    static void initCube() {
        up = new char[][] {{'w', 'w', 'w'}, {'w', 'w', 'w'}, {'w', 'w', 'w'}};
        down = new char[][] {{'y', 'y', 'y'}, {'y', 'y', 'y'}, {'y', 'y', 'y'}};
        front = new char[][] {{'r', 'r', 'r'}, {'r', 'r', 'r'}, {'r', 'r', 'r'}};
        behind = new char[][] {{'o', 'o', 'o'}, {'o', 'o', 'o'}, {'o', 'o', 'o'}};
        left = new char[][] {{'g', 'g', 'g'}, {'g', 'g', 'g'}, {'g', 'g', 'g'}};
        right = new char[][] {{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}};
    }

    static void turn(char face, char dir) {
        char[][] cube;
        switch (face) {
            case 'U':

            cube = up;

            if (dir == '+') {
                char tmp = cube[0][0];
                cube[0][0] = cube[2][0];
                cube[2][0] = cube[2][2];
                cube[2][2] = cube[0][2];
                cube[0][2] = tmp;

                tmp = cube[0][1];
                cube[0][1] = cube[1][0];
                cube[1][0] = cube[2][1];
                cube[2][1] = cube[1][2];
                cube[1][2] = tmp;

                char[] frontClone = front[0].clone();

                for (int i = 0; i < 3; i++) {
                    front[0][i] = right[0][i];
                }

                for (int i = 0; i < 3; i++) {
                    right[0][i] = behind[0][i];
                }

                for (int i = 0; i < 3; i++) {
                    behind[0][i] = left[0][i];
                }

                for (int i = 0; i < 3; i++) {
                    left[0][i] = frontClone[i];
                }

            } else {
                char tmp = cube[0][0];
                cube[0][0] = cube[0][2];
                cube[0][2] = cube[2][2];
                cube[2][2] = cube[2][0];
                cube[2][0] = tmp;

                tmp = cube[0][1];
                cube[0][1] = cube[1][2];
                cube[1][2] = cube[2][1];
                cube[2][1] = cube[1][0];
                cube[1][0] = tmp;

                char[] frontClone = front[0].clone();

                for (int i = 0; i < 3; i++) {
                    front[0][i] = left[0][i];
                }

                for (int i = 0; i < 3; i++) {
                    left[0][i] = behind[0][i];
                }

                for (int i = 0; i < 3; i++) {
                    behind[0][i] = right[0][i];
                }

                for (int i = 0; i < 3; i++) {
                    right[0][i] = frontClone[i];
                }

            }

            break;

            case 'D':

            cube = down;

            if (dir == '+') {
                char tmp = cube[0][0];
                cube[0][0] = cube[2][0];
                cube[2][0] = cube[2][2];
                cube[2][2] = cube[0][2];
                cube[0][2] = tmp;

                tmp = cube[0][1];
                cube[0][1] = cube[1][0];
                cube[1][0] = cube[2][1];
                cube[2][1] = cube[1][2];
                cube[1][2] = tmp;

                char[] frontClone = front[2].clone();

                for (int i = 0; i < 3; i++) {
                    front[2][i] = left[2][i];
                }

                for (int i = 0; i < 3; i++) {
                    left[2][i] = behind[2][i];
                }

                for (int i = 0; i < 3; i++) {
                    behind[2][i] = right[2][i];
                }

                for (int i = 0; i < 3; i++) {
                    right[2][i] = frontClone[i];
                }

            } else {
                char tmp = cube[0][0];
                cube[0][0] = cube[0][2];
                cube[0][2] = cube[2][2];
                cube[2][2] = cube[2][0];
                cube[2][0] = tmp;

                tmp = cube[0][1];
                cube[0][1] = cube[1][2];
                cube[1][2] = cube[2][1];
                cube[2][1] = cube[1][0];
                cube[1][0] = tmp;

                char[] frontClone = front[2].clone();

                for (int i = 0; i < 3; i++) {
                    front[2][i] = right[2][i];
                }

                for (int i = 0; i < 3; i++) {
                    right[2][i] = behind[2][i];
                }

                for (int i = 0; i < 3; i++) {
                    behind[2][i] = left[2][i];
                }

                for (int i = 0; i < 3; i++) {
                    left[2][i] = frontClone[i];
                }
            }

            break;

            case 'F':

            cube = front;

            if (dir == '+') {
                char tmp = cube[0][0];
                cube[0][0] = cube[2][0];
                cube[2][0] = cube[2][2];
                cube[2][2] = cube[0][2];
                cube[0][2] = tmp;

                tmp = cube[0][1];
                cube[0][1] = cube[1][0];
                cube[1][0] = cube[2][1];
                cube[2][1] = cube[1][2];
                cube[1][2] = tmp;

                char[] upClone = up[2].clone();

                for (int i = 0; i < 3; i++) {
                    up[2][2 - i] = left[i][2];
                }

                for (int i = 0; i < 3; i++) {
                    left[i][2] = down[0][i];
                }

                for (int i = 0; i < 3; i++) {
                    down[0][i] = right[2 - i][0];
                }

                for (int i = 0; i < 3; i++) {
                    right[i][0] = upClone[i];
                }
            } else {
                char tmp = cube[0][0];
                cube[0][0] = cube[0][2];
                cube[0][2] = cube[2][2];
                cube[2][2] = cube[2][0];
                cube[2][0] = tmp;

                tmp = cube[0][1];
                cube[0][1] = cube[1][2];
                cube[1][2] = cube[2][1];
                cube[2][1] = cube[1][0];
                cube[1][0] = tmp;

                char[] upClone = up[2].clone();

                for (int i = 0; i < 3; i++) {
                    up[2][i] = right[i][0];
                }

                for (int i = 0; i < 3; i++) {
                    right[i][0] = down[0][2 - i];
                }

                for (int i = 0; i < 3; i++) {
                    down[0][i] = left[i][2];
                }

                for (int i = 0; i < 3; i++) {
                    left[2 - i][2] = upClone[i];
                }
            }

            break;

            case 'B':

            cube = behind;

            if (dir == '+') {
                char tmp = cube[0][0];
                cube[0][0] = cube[2][0];
                cube[2][0] = cube[2][2];
                cube[2][2] = cube[0][2];
                cube[0][2] = tmp;

                tmp = cube[0][1];
                cube[0][1] = cube[1][0];
                cube[1][0] = cube[2][1];
                cube[2][1] = cube[1][2];
                cube[1][2] = tmp;

                char[] upClone = up[0].clone();

                for (int i = 0; i < 3; i++) {
                    up[0][i] = right[i][2];
                }

                for (int i = 0; i < 3; i++) {
                    right[2 - i][2] = down[2][i];
                }

                for (int i = 0; i < 3; i++) {
                    down[2][i] = left[i][0];
                }

                for (int i = 0; i < 3; i++) {
                    left[i][0] = upClone[2 - i];
                }
            } else {
                char tmp = cube[0][0];
                cube[0][0] = cube[0][2];
                cube[0][2] = cube[2][2];
                cube[2][2] = cube[2][0];
                cube[2][0] = tmp;

                tmp = cube[0][1];
                cube[0][1] = cube[1][2];
                cube[1][2] = cube[2][1];
                cube[2][1] = cube[1][0];
                cube[1][0] = tmp;

                char[] upClone = up[0].clone();

                for (int i = 0; i < 3; i++) {
                    up[0][2 - i] = left[i][0];
                }

                for (int i = 0; i < 3; i++) {
                    left[i][0] = down[2][i];
                }

                for (int i = 0; i < 3; i++) {
                    down[2][2 - i] = right[i][2];
                }

                for (int i = 0; i < 3; i++) {
                    right[i][2] = upClone[i];
                }
            }

            break;

            case 'L':

            cube = left;

            if (dir == '+') {
                char tmp = cube[0][0];
                cube[0][0] = cube[2][0];
                cube[2][0] = cube[2][2];
                cube[2][2] = cube[0][2];
                cube[0][2] = tmp;

                tmp = cube[0][1];
                cube[0][1] = cube[1][0];
                cube[1][0] = cube[2][1];
                cube[2][1] = cube[1][2];
                cube[1][2] = tmp;

                char[] upClone = new char[3];

                for (int i = 0; i < 3; i++) {
                    upClone[i] = up[i][0];
                }

                for (int i = 0; i < 3; i++) {
                    up[i][0] = behind[2 - i][2];
                }

                for (int i = 0; i < 3; i++) {
                    behind[2 - i][2] = down[i][0];
                }

                for (int i = 0; i < 3; i++) {
                    down[i][0] = front[i][0];
                }

                for (int i = 0; i < 3; i++) {
                    front[i][0] = upClone[i];
                }
            } else {
                char tmp = cube[0][0];
                cube[0][0] = cube[0][2];
                cube[0][2] = cube[2][2];
                cube[2][2] = cube[2][0];
                cube[2][0] = tmp;

                tmp = cube[0][1];
                cube[0][1] = cube[1][2];
                cube[1][2] = cube[2][1];
                cube[2][1] = cube[1][0];
                cube[1][0] = tmp;

                char[] upClone = new char[3];

                for (int i = 0; i < 3; i++) {
                    upClone[i] = up[i][0];
                }

                for (int i = 0; i < 3; i++) {
                    up[i][0] = front[i][0];
                }

                for (int i = 0; i < 3; i++) {
                    front[i][0] = down[i][0];
                }

                for (int i = 0; i < 3; i++) {
                    down[i][0] = behind[2 - i][2];
                }

                for (int i = 0; i < 3; i++) {
                    behind[2 - i][2] = upClone[i];
                }
            }

            break;

            case 'R':

            cube = right;

            if (dir == '+') {
                char tmp = cube[0][0];
                cube[0][0] = cube[2][0];
                cube[2][0] = cube[2][2];
                cube[2][2] = cube[0][2];
                cube[0][2] = tmp;

                tmp = cube[0][1];
                cube[0][1] = cube[1][0];
                cube[1][0] = cube[2][1];
                cube[2][1] = cube[1][2];
                cube[1][2] = tmp;

                char[] upClone = new char[3];

                for (int i = 0; i < 3; i++) {
                    upClone[i] = up[i][2];
                }

                for (int i = 0; i < 3; i++) {
                    up[i][2] = front[i][2];
                }

                for (int i = 0; i < 3; i++) {
                    front[i][2] = down[i][2];
                }

                for (int i = 0; i < 3; i++) {
                    down[i][2] = behind[2 - i][0];
                }

                for (int i = 0; i < 3; i++) {
                    behind[2 - i][0] = upClone[i];
                }
            } else {
                char tmp = cube[0][0];
                cube[0][0] = cube[0][2];
                cube[0][2] = cube[2][2];
                cube[2][2] = cube[2][0];
                cube[2][0] = tmp;

                tmp = cube[0][1];
                cube[0][1] = cube[1][2];
                cube[1][2] = cube[2][1];
                cube[2][1] = cube[1][0];
                cube[1][0] = tmp;

                char[] upClone = new char[3];

                for (int i = 0; i < 3; i++) {
                    upClone[i] = up[i][2];
                }

                for (int i = 0; i < 3; i++) {
                    up[i][2] = behind[2 - i][0];
                }

                for (int i = 0; i < 3; i++) {
                    behind[2 - i][0] = down[i][2];
                }

                for (int i = 0; i < 3; i++) {
                    down[i][2] = front[i][2];
                }

                for (int i = 0; i < 3; i++) {
                    front[i][2] = upClone[i];
                }
            }

            break;

            default:
            break;
        }
    }
}