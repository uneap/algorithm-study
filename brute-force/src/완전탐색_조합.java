import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

//2961 조합
public class 완전탐색_조합 {
    static class Taste {
        BigInteger bitter;
        BigInteger sour;
        public Taste(String sour, String bitter) {
            this.bitter = new BigInteger(bitter);
            this.sour = new BigInteger(sour);
        }
        public Taste(BigInteger sour, BigInteger bitter) {
            this.sour = sour;
            this.bitter = bitter;
        }
        public Taste cook(Taste taste) {
            return new Taste(this.sour.multiply(taste.sour), this.bitter.add(taste.bitter));
        }
        public long getDifference() {
            return Math.abs(bitter.subtract(sour).longValue());
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        List<Taste> tastes = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            tastes.add(new Taste(st.nextToken(), st.nextToken()));
        }
        AtomicLong answer = new AtomicLong(Integer.MAX_VALUE);
        combination(tastes, new LinkedList<>(), answer, 0);
        System.out.println(answer.get());
    }
    public static void combination(List<Taste> tastes, LinkedList<Taste> taste, AtomicLong answer, int index) {
        if(index == tastes.size()) {
            if(!taste.isEmpty()) {
                Taste t = taste.get(0);
                for (int i = 1; i < taste.size(); i++) {
                    t = t.cook(taste.get(i));
                }
                answer.set(Math.min(answer.get(), t.getDifference()));
            }
            return;
        }
        combination(tastes, taste, answer, index + 1);
        taste.add(tastes.get(index));
        combination(tastes, taste, answer, index + 1);
        taste.removeLast();
    }
}
