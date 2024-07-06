import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class n_queen {

    public static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        nQueen(arr,0);
        System.out.println(count);

    }

    public static void nQueen(int[] arr, int depth) {
        if (depth == arr.length) {
            count++;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[depth] = i;
            if (possibility(arr, depth)) {
                nQueen(arr,depth + 1);
            }
        }

    }

    public static boolean possibility(int[] arr, int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            }

            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
