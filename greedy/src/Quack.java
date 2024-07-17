import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// quqacukqauackck
// q 0 2 7
// u 1 6 9
// a 4 8 10
// c 5 11 13
// k 6 12 14
// 1. quack 모두 있는지 체크
// 2. cryTypes key 순회하면서 list 사이즈 모두 동일한지 체크
// 3. 저장된 값의 순서가 q u a c k 순으로 증가해야 함, 그렇지 않을 경우 -1 출력
// 4. k보다 q에 저장된 index가 크면 같은 오리로 취급해서 list size - 1
public class Quack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cry = br.readLine();
        char[] quack = {'q','u','a','c','k'};
        Map<Character, List<Integer>> cryTypes = new HashMap<>();
        for(int i = 0; i < cry.length(); i++) {
            List<Integer> indexes = cryTypes.getOrDefault(cry.charAt(i), new ArrayList<>());
            indexes.add(i);
            cryTypes.put(cry.charAt(i), indexes);
        }
        for(int i = 0; i < quack.length; i++) {
            if(!cryTypes.containsKey(quack[i])) {
                System.out.println(-1);
                return;
            }
        }
        int size = cryTypes.get('q').size();
        for(Character type: cryTypes.keySet()) {
            if(cryTypes.get(type).size() != size) {
                System.out.println(-1);
                return;
            }
        }
        List<Integer> q = cryTypes.get('q');
        List<Integer> u = cryTypes.get('u');
        List<Integer> a = cryTypes.get('a');
        List<Integer> c = cryTypes.get('c');
        List<Integer> k = cryTypes.get('k');
        for(int i = 0; i < size; i++) {
            if(!(q.get(i) < u.get(i) && u.get(i) < a.get(i) && a.get(i) < c.get(i) && c.get(i) < k.get(i))) {
                System.out.println(-1);
                return;
            }
        }
        Set<Integer> removeQ = new HashSet<>();
        for (Integer kIndex : k) {
            for (Integer qIndex : q) {
                if (!removeQ.contains(qIndex) && kIndex < qIndex) {
                    size--;
                    removeQ.add(qIndex);
                    break;
                }
            }
        }
        System.out.println(size);
     }
}
