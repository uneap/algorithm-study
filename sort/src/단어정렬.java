import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 단어정렬 {
    public static class Word implements Comparable<Word> {
        String word;
        public Word(String word) {
            this.word = word;
        }


        @Override
        public int compareTo(Word o) {
            if(this.word.length() == o.word.length()) {
                return this.word.compareTo(o.word);
            }
            return this.word.length() - o.word.length();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = parseInt(br.readLine());
        List<Word> words = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        for(int i = 0; i < num; i++) {
            String word = br.readLine();
            if(wordSet.contains(word)) {
                continue;
            }
            wordSet.add(word);
            words.add(new Word(word));
        }
        Collections.sort(words);
        for(int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i).word);
        }
    }
}
