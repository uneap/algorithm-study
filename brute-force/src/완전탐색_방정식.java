import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 완전탐색_방정식 {
    public static List<Integer> getNumbers() throws IOException {
        List<Integer> nums = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        return nums;
    }
    // a*d*x + b*d*y = c*d
    // d*a*x  + e*a*y = f*a
    //
    // (b*d - e*a)y = c*d - f*a
    // y = c*d - f*a / (b*d - e*a)
    //     2 3   5 0    1 3   4 0
    // a*e*x + b*ey = c*e
    // d*b x + e*b y = f*b
    // (a*e - d*b) * x = (c * e - f*b)
    //  x = (c * e - f*b) / (a*e - d*b)
    //       2   4   5 1     0 4   3 1
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = getNumbers();
        //브루트포스
//        for(int i = -999; i <= 999; i++) {
//           for(int j = -999; j <= 999; j++) {
//               if(numbers.get(0) * i + numbers.get(1) * j == numbers.get(2)) {
//                   if(numbers.get(3) * i + numbers.get(4) * j == numbers.get(5)) {
//                       System.out.println(i + " " + j);
//                       return;
//                   }
//               }
//           }
//        }
        //수학
        System.out.println((numbers.get(2) * numbers.get(4) - numbers.get(5) * numbers.get(1)) / (numbers.get(0) * numbers.get(4) - numbers.get(3) * numbers.get(1)) + " " +
            (numbers.get(2) * numbers.get(3) - numbers.get(5) * numbers.get(0)) / (numbers.get(1) * numbers.get(3) - numbers.get(4)*numbers.get(0)));
    }
}
