import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class dp_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int number[] = new int[n + 1];
        Arrays.fill(number, 0);
        number[1] = 0;
        for(int i = 2; i <= n; i++) {
            if(i % 3 == 0 && i % 2 == 0) {
                number[i] = Math.min(number[i / 3] + 1, Math.min(number[i / 2] + 1, number[i - 1] + 1));
            }
            else if(i % 3 == 0) {
                number[i] = Math.min(number[i / 3] + 1, number[i - 1] + 1);
            }
            else if(i % 2 == 0) {
                number[i] = Math.min(number[i / 2] + 1, number[i - 1] + 1);
            }
            else {
                number[i] = number[i - 1] + 1;
            }
        }
        System.out.println(number[n]);
    }

}