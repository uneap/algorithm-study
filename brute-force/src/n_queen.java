import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class n_queen {

    public static int count = 0;
    // 모든 퀸을 다 놓아야 함.
    // 말을 놓을 때마다 값이 변경됨.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rows = new int[n];
        dfs(rows, 0);
        System.out.println(count);
    }

    public static void dfs(int[] rows, int a) {
        if(a == rows.length){
            count++;
            return;
        }
        for(int i = 0; i < rows.length; i++) {
            rows[a] = i;
            if(isPossible(rows, a)) {
                dfs(rows,a + 1);
            }
        }
    }

    public static boolean isPossible(int[] rows, int a) {
        for(int b = 0; b < a; b++) {
            if (rows[a] == rows[b]) {
                return false;
            }
            if (Math.abs(a - b) == Math.abs(rows[a] - rows[b])) {
                return false;
            }
        }
        return true;
    }
}
