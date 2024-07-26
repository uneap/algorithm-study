import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 우는 순서가 다를 때
//
public class 오리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cry = br.readLine();
        char[] quacks = {'q','u','a','c','k'};
        Map<Character, List<Integer>> cryIndexes = new HashMap<>();
        for(int i = 0; i < quacks.length; i++) {
            cryIndexes.put(quacks[i], new ArrayList<>());
        }
        for(int i = 0; i < cry.length(); i++) {
            List<Integer> indexes = cryIndexes.get(cry.charAt(i));
            indexes.add(i);
            cryIndexes.put(cry.charAt(i), indexes);
        }
        for(int i = 0; i < quacks.length; i++) {
            if(cryIndexes.get(quacks[i]).isEmpty()) {
                System.out.println(-1);
                return;
            }
        }
        int qSize = cryIndexes.get('q').size();
        for(Character key : cryIndexes.keySet()) {
            if(cryIndexes.get(key).size() != qSize) {
                System.out.println(-1);
                return;
            }
        }
        List<Integer> q = cryIndexes.get('q');
        List<Integer> u = cryIndexes.get('u');
        List<Integer> a = cryIndexes.get('a');
        List<Integer> c = cryIndexes.get('c');
        List<Integer> k = cryIndexes.get('k');
        for(int i = 0; i < q.size(); i++) {
            if(!(q.get(i) < u.get(i) && u.get(i) < a.get(i) && a.get(i) < c.get(i) && c.get(i) < k.get(i))) {
                System.out.println(-1);
                return;
            }
        }
        int size = q.size();
        Set<Integer> duplicatedQ = new HashSet<>();
        for(int i = 0; i < k.size(); i++) {
            for(int j = 0; j < q.size(); j++) {
                if(!duplicatedQ.contains(q.get(j)) && k.get(i) < q.get(j)) {
                    duplicatedQ.add(q.get(j));
                    size--;
                    break;
                }
            }
        }
        System.out.println(size);
    }
}
