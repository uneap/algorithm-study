import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 늑대와올바른단어 {
    public static void main(String[] args) throws IOException {
        char[] wolfAlphabet = new char[4];
        int[] counts = new int[4];
        wolfAlphabet[0] = 'w';
        wolfAlphabet[1] = 'o';
        wolfAlphabet[2] = 'l';
        wolfAlphabet[3] = 'f';
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int index = 0;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == wolfAlphabet[index]) {
                counts[index]++;
            } else {
                if(index < 3) {
                    index++;
                } else {
                    if(correctWord(counts)) {
                        index = 0;
                    } else {
                        System.out.println(0);
                        return;
                    }
                }
                if(word.charAt(i) != wolfAlphabet[index]) {
                    System.out.println(0);
                    return;
                }
                counts[index]++;
            }
        }
        for(int i = 1; i < 4; i++) {
            if(counts[0] != counts[i]) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
    public static boolean correctWord(int[] counts) {
        for(int i = 1; i < 4; i++) {
            if(counts[0] != counts[i]) {
                return false;
            }
        }
        return true;
    }
}
