import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class movingPeople {
    static int N,L,R;

    public static class Country {
        int x;
        int y;
        int count;
        public Country(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        L = parseInt(st.nextToken());
        R = parseInt(st.nextToken());
        int[][] people = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                people[i][j] = parseInt(st.nextToken());
            }
        }
        int day = 0;
        while(true) {
            boolean[][] visit = new boolean[N][N];
            boolean out = true;
            for(int i = 0; i < N; i++){
                for(int j= 0; j < N; j++) {
                    if(visit[i][j]){
                        continue;
                    }
                    List<Country> countries = new ArrayList<>();
                    int num = move(countries, visit, people, i, j);
                    if(num != -1){
                        renew(num, countries, people);
                        out = false;
                    }
                }
            }
            if(out) {
                break;
            }
            day++;
        }
        System.out.print(day);
    }

    public static void renew(int num, List<Country> countries, int[][] people) {
        for(Country country : countries) {
            people[country.x][country.y] = num;
        }
    }
    public static int move(List<Country> countries, boolean[][]visit, int[][] people, int x, int y) {
        int sum = 0;
        int unit = 0;
        int[] directX = {0,0,1,-1};
        int[] directY = {1,-1,0,0};
        Queue<Country> q = new LinkedList<>();
        q.offer(new Country(x, y, people[x][y]));
        while (!q.isEmpty()) {
            Country country = q.poll();
            if(visit[country.x][country.y]) {
                continue;
            }
            countries.add(country);
            sum += country.count;
            unit++;
            visit[country.x][country.y] = true;
            for(int i = 0; i < 4; i++) {
                int dx = directX[i] + country.x;
                int dy = directY[i] + country.y;
                if(dx < 0 || dy < 0 || dx >= N || dy >= N) {
                    continue;
                }
                if(Math.abs(people[dx][dy] - country.count) >= L && Math.abs(people[dx][dy] - country.count) <= R) {
                    q.offer(new Country(dx, dy, people[dx][dy]));
                }
            }
        }
        if(unit > 1) {
            return sum / unit;
        }
        return -1;
    }

}
