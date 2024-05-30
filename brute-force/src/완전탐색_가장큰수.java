import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class 완전탐색_가장큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int limit = parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        List<String> elements = new ArrayList<>();
        while(st.hasMoreTokens()) {
            elements.add(st.nextToken());
        }
        AtomicInteger maxNum = new AtomicInteger();
        simulate(maxNum, elements, new LinkedList<>(), limit);
        System.out.println(maxNum);
    }
    //  (10 ≤ N ≤ 10^8, 1 ≤ K의 원소의 개수 ≤ 3)
    // 시간 복잡도 O(3^8)
    // 순서 상관있게 뽑고, 중복 허용, 중복순열
    // 처음엔 순서 상관 없게 뽑는 중복 조합과 헷갈림. 그러나 수를 비교해야하므로 순서 상관있음.
    //
    public static void simulate(AtomicInteger maxNum, List<String> elements, LinkedList<String> number, int limit) {
        if(!number.isEmpty()) {
            int answer = parseInt(String.join("", number));
            if (answer > limit) {
                return;
            }
            maxNum.set(max(maxNum.get(), answer));
        }
        for(int i = 0; i < elements.size(); i++) {
            number.add(elements.get(i));
            simulate(maxNum, elements, number, limit);
            number.removeLast();
        }
    }
}
