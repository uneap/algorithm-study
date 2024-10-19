//class에 lastIndex, count, alphabet
// count 큰 순으로 정렬
// 두개 뽑아서 전에거 없는 애로 넣고 다시 넣음, pq 없어질 때까지 셋팅
import java.util.*;
class Solution {
    static int index;
    class Str implements Comparable<Str>{
        int count;
        char alphabet;
        Str(int count, char alphabet) {
            this.count = count;
            this.alphabet = alphabet;
        }
        @Override
        public int compareTo(Str s) {
            return s.count - this.count;
        }
    }
    public String reorganizeString(String s) {
        Map<Character, Integer> alphas = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            alphas.put(s.charAt(i), alphas.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Str> pq = new PriorityQueue<>();
        for(char key : alphas.keySet()) {
            pq.offer(new Str(alphas.get(key), key));
        }
        String st = "";
        while(!pq.isEmpty()) {
            Str str = pq.poll();
            int lastIndex = st.length() - 1;
            if(st.length() > 0 && st.charAt(lastIndex) == str.alphabet) {
                Str str2 = null;
                if(!pq.isEmpty()) {
                    str2 = pq.poll();
                }
                if(str2 == null || st.charAt(lastIndex) == str2.alphabet) {
                    return "";
                } else {
                    st += str2.alphabet;
                    str2.count--;
                    if(str2.count != 0) {
                        pq.offer(str2);
                    }
                    pq.offer(str);
                }
            } else {
                st += str.alphabet;
                str.count--;
                if(str.count != 0) {
                    pq.offer(str);
                }
            }
        }
        return st;
    }
}