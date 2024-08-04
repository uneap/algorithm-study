//import static java.lang.Integer.parseInt;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Objects;
//import java.util.Set;
//import java.util.StringTokenizer;
//
//public class 테르로미노 {
//    public static int[][][] directions = {
//        {{0,0},{0,1},{0,2},{1,1}},
//        {{1,0},{0,1},{1,1},{2,1}},
//        {{0,0},{1,0},{1,1},{2,0}},
//        {{0,1},{1,0},{1,1},{1,2}}
//    };
//    public static class Location {
//
//        int x;
//        int y;
//
//        public Location(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (o instanceof Location location) {
//                return this.x == location.x && this.y == location.y;
//            }
//            return false;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(x, y);
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = parseInt(st.nextToken());
//        int m = parseInt(st.nextToken());
//        int[][] paper = new int[n][m];
//        for(int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0; j < m; j++) {
//                paper[i][j] = parseInt(st.nextToken());
//            }
//        }
//        int[][] visit = new int[n][m];
//        int answer = 0;
//        dfs(answer, visit, paper);
//    }
//    public static void dfs(int maximum, int[][] visit, int[][] paper, ) {
//        if(count == 0) {
//            maximum = Math.max(sum, maximum);
//            return;
//        }
//
//    }
//}
