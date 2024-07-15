import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class combination_password {
    static String[] alphabet;
    static int L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = parseInt(st.nextToken());
        int c = parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        alphabet = new String[c];
        for(int i = 0; i < c; i++) {
            alphabet[i] = st.nextToken();
        }
        Arrays.sort(alphabet);
        List<String> passwords = new ArrayList<>();
        makePassword("", passwords, 0);
        for (String password : passwords) {
            System.out.println(password);
        }
    }

    public static void makePassword(String password, List<String> passwords, int index) {
        if(password.length() == L) {
            if(L - Stream.of("a", "e", "i", "o", "u").filter(password::contains).count() >= 2 && Stream.of("a", "e", "i", "o", "u").anyMatch(password::contains)) {
                passwords.add(password);
            }
            return;
        }
        if(index == alphabet.length) {
            return;
        }
        makePassword(password + alphabet[index], passwords, index + 1);
        makePassword(password, passwords, index + 1);
    }
}
