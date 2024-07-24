//import static java.lang.Integer.parseInt;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Set;
//import java.util.StringTokenizer;
//
//public class SharkAndFireball {
//    static int N;
//    static int[] directX = {0, -1, -1, -1, 0, 1, 1, 1};
//    static int[] directY = {-1, -1, 0, 1, 1, 1, 0, -1};
//    static Set<Fireball>[][] locationAndFireballs;
//
//    public static class Fireball {
//        int r;
//        int c;
//        int m;
//        int d;
//        int s;
//        public Fireball(int r, int c, int m, int d, int s) {
//            this.r = r;
//            this.c = c;
//            this.m = m;
//            this.d = d;
//            this.s = s;
//        }
//        @Override
//        public boolean equals(Object o) {
//            if(o instanceof Fireball fireball) {
//                return r == fireball.r && c == fireball.c && m == fireball.m && d == fireball.d && s == fireball.s;
//            }
//            return false;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(r, c, m, d, s);
//        }
//        public void move() {
//            locationAndFireballs[r][c].remove(this);
//            r = (N + r + (directX[d] * s)) % N;
//            c = (N + c + (directY[d] * s)) % N;
//            Set<Fireball> balls = locationAndFireballs[r][c];
//            balls.add(this);
//            locationAndFireballs[r][c] = balls;
//            if (locationAndFireballs[r][c].size() > 1) {
//                combine();
//            }
//        }
//        public boolean combine() {
//            locationAndFireballs[r][c]
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        int m, k;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = parseInt(st.nextToken());
//        m = parseInt(st.nextToken());
//        k = parseInt(st.nextToken());
//    }
//}
