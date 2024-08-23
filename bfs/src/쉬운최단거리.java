import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리 {
    static int n,m;
    static int[][] matrix;
    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        matrix = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                matrix[i][j] = parseInt(st.nextToken());
            }
        }
        Node node = getObject();
        print(search(node));
    }
    public static void print(int[][] weight) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(weight[i][j] == Integer.MAX_VALUE && matrix[i][j] == 1) {
                    System.out.print( -1 + " ");
                } else if(weight[i][j] == Integer.MAX_VALUE) {
                    System.out.print(0 + " ");
                }
                else {
                    System.out.print(weight[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public static Node getObject() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 2) {
                    return new Node(i, j);
                }
            }
        }
        return null;
    }
    public static int[][] search(Node object) {
        int[][] weight = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(weight[i], Integer.MAX_VALUE);
        }
        int[] directX = {1, -1, 0,0};
        int[] directY = {0,0,1, -1};
        Queue<Node> q = new LinkedList<>();
        q.add(object);
        weight[object.x][object.y] = 0;
        while(!q.isEmpty()) {
            Node node = q.poll();
            for(int i = 0; i < 4; i++) {
                int dx = node.x + directX[i];
                int dy = node.y + directY[i];
                if(dx < 0 || dy < 0 || dx >= n || dy >= m || matrix[dx][dy] == 0) {
                    continue;
                }
                if(weight[dx][dy] != Integer.MAX_VALUE) {
                    continue;
                }
                q.add(new Node(dx,dy));
                weight[dx][dy] = weight[node.x][node.y] + 1;
            }
        }
        return weight;
    }
}
