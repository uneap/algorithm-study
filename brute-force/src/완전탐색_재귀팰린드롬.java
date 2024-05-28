import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class 완전탐색_재귀팰린드롬 {
    public static List<String> getStringList() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        List<String> strs = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            strs.add(br.readLine());
        }
        return strs;
    }
    public static int palindrome(String str, int l, int r, AtomicInteger count) {
        count.getAndIncrement();
        if(l >= r) {
            return 1;
        }
        if(str.charAt(l) != str.charAt(r)) {
            return 0;
        }
        return palindrome(str, l + 1, r - 1, count);
    }
    public static void main(String[] args) throws IOException {
        List<String> strs = getStringList();
        for(int i = 0; i < strs.size(); i ++) {
            AtomicInteger count = new AtomicInteger();
            System.out.println(palindrome(strs.get(i), 0, strs.get(i).length() - 1, count) + " " + count.get());
        }
    }
}
