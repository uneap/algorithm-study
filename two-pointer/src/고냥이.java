import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// left pointer 종류가 num을 넘어가면 ++
// right pointer 종류가 num을 넘어가지 않으면 ++
//
public class 고냥이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = parseInt(br.readLine());
        String alphabets = br.readLine();
        int left = 0, right = 0, answer = 0;
        Map<Character, Integer> alphabetAndIndex = new HashMap<>();
        while(left < alphabets.length() && right < alphabets.length()) {
            char alphabet = alphabets.charAt(right);
            alphabetAndIndex.put(alphabet, alphabetAndIndex.getOrDefault(alphabet, 0) + 1);
            if(alphabetAndIndex.size() <= num) {
                answer = Math.max(right - left + 1, answer);
                right++;
            } else {
                alphabetAndIndex.remove(alphabet);
                alphabet = alphabets.charAt(left);
                alphabetAndIndex.put(alphabet, alphabetAndIndex.get(alphabet) - 1);
                if(alphabetAndIndex.get(alphabet) == 0) {
                    alphabetAndIndex.remove(alphabet);
                }
                left++;
            }
        }
        System.out.println(answer);
    }
}
