import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 전구를 킨 상태
// 전구를 끈 상태 체크
// 이전 인덱스 상태가 예상치랑 다를 경우, 스위치를 누른다.
// 최종적으로 전구 상태를 체크하고, 답과 일치하는 애 중 가장 작은 카운트로 출력
public class 전구와스위치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        boolean[] after = new boolean[N];
        String[] token = br.readLine().split("");
        boolean[] on = new boolean[N];
        boolean[] off = new boolean[N];
        for(int i = 0; i < N; i++) {
            on[i] = parseInt(token[i]) == 1;
            off[i] = on[i];
        }
        on[0] = !on[0];
        on[1] = !on[1];
        token = br.readLine().split("");
        for(int i = 0; i < N; i++) {
            after[i] = parseInt(token[i]) == 1;
        }
        int switchOn = 1;
        int switchOff = 0;
        for(int i = 1; i < N; i++) {
            if(after[i - 1] != on[i - 1]) {
                on[i - 1] = !on[i - 1];
                on[i] = !on[i];
                if(i < N - 1) {
                    on[i + 1] = !on[i + 1];
                }
                switchOn++;
            }
            if(after[i - 1] != off[i - 1]) {
                off[i - 1] = !off[i - 1];
                off[i] = !off[i];
                if(i < N - 1) {
                    off[i + 1] = !off[i + 1];
                }
                switchOff++;
            }
        }
        boolean switchOnCorrect = true;
        boolean switchOffCorrect = true;
        for(int i = 0; i < N; i++) {
            if(after[i] != on[i]) {
                switchOnCorrect = false;
            }
            if(after[i] != off[i]) {
                switchOffCorrect = false;
            }
        }
        if(switchOffCorrect && switchOnCorrect) {
            System.out.println(Math.min(switchOn, switchOff));
            return;
        }
        System.out.println(switchOnCorrect ? switchOn : switchOffCorrect ? switchOff : - 1);
    }

}
