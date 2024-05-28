import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 완전탐색_분해합 {
    public static int getNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    public static void create(Map<Integer, Integer> nums, int num) {
        for(int i = 1; i <= num; i++) {
            if(nums.containsKey(num)) {
                return;
            }
            //String변환
            String numString = String.valueOf(i);
            //char변환 후 num으로 변환
            int sum = 0;
            for(int j = 0; j < numString.length(); j++) {
                sum += numString.charAt(j) - '0';
            }
            sum += i;
            // 해당값을 key로 i를 value로 넣기
            nums.put(sum, i);
        }
    }
    public static void main(String[] args) throws IOException {
        int num = getNumber();
        Map<Integer, Integer> nums = new HashMap<>();
        create(nums, num);
        if(nums.containsKey(num)) {
            System.out.println(nums.get(num));
        } else {
            System.out.println(0);
        }
    }
}
