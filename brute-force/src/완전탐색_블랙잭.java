
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class 완전탐색_블랙잭 {
    public static List<Integer> getInputs() throws IOException {
        List<Integer> nums = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        return nums;
    }
    // 시간 복잡도: 조합 nC3 -> n! / 3!*(n-3)!
    //
    public static void blackJack(List<Integer> nums, int answer, AtomicInteger max, int n, int index) {
        if(answer > nums.get(1)) {
            return;
        }
        if(n == 0) {
            max.set(Math.max(max.get(), answer));
            return;
        }
        if(index >= nums.size()) {
            return;
        }
        blackJack(nums, nums.get(index) + answer, max, n - 1, index + 1);
        blackJack(nums, answer, max, n, index + 1);
    }
    public static void main(String[] args) throws IOException {
        List<Integer> nums = getInputs();
        AtomicInteger max = new AtomicInteger();
        blackJack(nums, 0, max, 3, 2);
        System.out.println(max);
    }
}
