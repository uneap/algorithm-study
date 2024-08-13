import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int one = parseInt(st.nextToken());
        int two = parseInt(st.nextToken());
        int maxNum = gcd(one, two);
        System.out.println(maxNum + "\n" + one * two / maxNum);
    }
// 24 18
    // 18 6
    // 6 0
    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
