import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RidingLadder {
    static int questionIndex = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = parseInt(br.readLine());
        int n = parseInt(br.readLine());
        String answer = br.readLine();
        Map<Character, Integer> ladderAndIndex = new HashMap<>();
        List<String> ladders = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            ladderAndIndex.put(answer.charAt(i), i);
        }
        for(int i = 0; i < n; i++) {
            ladders.add(br.readLine());
        }
        char[] downLadders = ladderDown(ladders, k);
        char[] upLadders = ladderUp(ladders, k, answer);
        System.out.println(getLine(downLadders, upLadders));
    }
    //  위부터 ?가 나올 때까지 사다리 타기
    // 아래부터 ?가 나올 때까지 사다리 타기
    // 위와 아래 비교, 같으면 * 위의 i와 아래의 i + 1이 같으면 - 그 이상이면 x로 리턴
    // 가장 마지막 자리일 땐 * 빼준다.
    //ABC
    //-*-
    //BAC
    public static String getLine(char[] downLadders, char[] upLadders) {
        StringBuilder answer = new StringBuilder();
        boolean noneMatch = false;
        for (int i = 0; i < downLadders.length - 1; i++) {
            if(downLadders[i] == upLadders[i]) {
                answer.append("*");
            } else if(downLadders[i] == upLadders[i + 1] || upLadders[i] == downLadders[i + 1]) {
                answer.append("-");
                if(i + 1 != downLadders.length - 1){
                    answer.append("*");
                }
                i++;
            } else {
                noneMatch = true;
                break;
            }
        }
        if(noneMatch) {
            answer = new StringBuilder();
            answer.append("x".repeat(downLadders.length - 1));
        }
        return answer.toString();
    }
    //사다리타기
    // - 보이면 index 증가
    // 맨끝 index 일 경우 - 보이면 index 감소

    public static char[] ladderDown(List<String> ladders, int k) {
        char[] downLadders = new char[k];
        for(int i = 0; i < downLadders.length; i++) {
            downLadders[i] = (char)('A' + i);
        }
        for(int i = 0; i < ladders.size(); i++) {
            if(ladders.get(i).charAt(0) == '?') {
                questionIndex = i;
                break;
            }
            for(int j = 0; j < k - 1; j++) {
                if(ladders.get(i).charAt(j) == '-') {
                    char temp = downLadders[j];
                    downLadders[j] = downLadders[j + 1];
                    downLadders[j + 1] = temp;
                }
            }
        }
        return downLadders;
    }

    public static char[] ladderUp(List<String> ladders, int k, String answer) {
        char[] downLadders = new char[k];
        for(int i = 0; i < downLadders.length; i++) {
            downLadders[i] = answer.charAt(i);
        }
        for(int i = ladders.size() - 1; i > questionIndex; i--) {
            for(int j = 0; j < k - 1; j++) {
                if(ladders.get(i).charAt(j) == '-') {
                    char temp = downLadders[j];
                    downLadders[j] = downLadders[j + 1];
                    downLadders[j + 1] = temp;
                }
            }
        }
        return downLadders;
    }
}
