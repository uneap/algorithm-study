import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 완전탐색_시각 {
    public static void main(String[] args) throws IOException {
        List<Integer> nums = getNumbers();
        int count = 0;
        for(int i = 0; i <= nums.get(0); i++) {
            // % 명령의 시작
            // 0 채워질 문자
            // 2 총 자리 수
            // d 십진 정수
            if(String.format("%02d",i).contains(String.valueOf(nums.get(1)))) {
                count += 60*60;
                continue;
            }
            for(int j = 0; j <= 59; j++) {
                if(String.format("%02d",j).contains(String.valueOf(nums.get(1)))) {
                    count += 60;
                    continue;
                }
                for(int k = 0; k <= 59; k++) {
                    if(String.format("%02d",k).contains(String.valueOf(nums.get(1)))) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
    public static List<Integer> getNumbers() throws IOException {
        List<Integer> nums = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        return nums;
    }
}
