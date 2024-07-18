import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Zoac {
    public static class Keyboard {
        int x;
        int y;
        public Keyboard(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getTime(Keyboard keyboard) {
            return Math.abs(this.x - keyboard.x) + Math.abs(this.y - keyboard.y) + 1;
        }
    }
    public static Map<String, Keyboard> initKeys() {
        Map<String, Keyboard> keys = new HashMap<>();
        String[] board = {"q","w","e","r","t","y","u","i","o","p"};
        String[] board2 = {"a","s","d","f","g","h","j","k","l"};
        String[] board3 = {"z","x","c","v","b","n","m"};
        for(int i = 0; i < board.length; i++) {
            keys.put(board[i], new Keyboard(0, i));
        }
        for(int i = 0; i < board2.length; i++) {
            keys.put(board2[i], new Keyboard(1, i));
        }
        for(int i = 0; i < board3.length; i++) {
            keys.put(board3[i], new Keyboard(2, i));
        }
        return keys;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Keyboard> keys = initKeys();
        Keyboard left = keys.get(st.nextToken());
        Keyboard right = keys.get(st.nextToken());
        String word = br.readLine();
        int time = 0;
        for(int i = 0; i < word.length(); i++) {
            Keyboard newKey = keys.get(Character.toString(word.charAt(i)));
            if(newKey.y < 5 && word.charAt(i) != 'b') {
                time += left.getTime(newKey);
                left = newKey;
            } else {
                time += right.getTime(newKey);
                right = newKey;
            }
        }
        System.out.println(time);
    }
}
