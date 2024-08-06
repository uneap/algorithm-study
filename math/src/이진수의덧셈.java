import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 이진수의덧셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = parseInt(br.readLine());
        for(int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger numberOne = new BigInteger(st.nextToken(), 2);
            BigInteger numberTwo = new BigInteger(st.nextToken(), 2);
            System.out.println(numberTwo.add(numberOne).toString(2));
        }
    }
}
