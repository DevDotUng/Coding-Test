import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static Country[] countries;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        countries = new Country[N];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            countries[i] = new Country(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
        }

        Arrays.sort(countries, (c1, c2) -> c1.gold == c2.gold ? (c1.silver == c2.silver ? (c2.bronze - c1.bronze) : c2.silver - c1.silver) : c2.gold - c1.gold);

        int rank = 1;
        if (countries[0].name == K) {
            System.out.println(rank);
            return;
        }

        for (int i = 1; i < N; i++) {
            if (!(countries[i].gold == countries[i - 1].gold && countries[i].silver == countries[i - 1].silver && countries[i].bronze == countries[i - 1].bronze)) {
                rank = i + 1;
            }

            if (countries[i].name == K) {
                System.out.println(rank);
                return;
            }
        }
    }
}

class Country {
    int name;
    int gold;
    int silver;
    int bronze;

    Country(int name, int gold, int silver, int bronze) {
        this.name = name;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }
}