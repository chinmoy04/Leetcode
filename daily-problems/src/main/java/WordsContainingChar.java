import java.util.ArrayList;
import java.util.List;

public class WordsContainingChar {
    public List<Integer> findWordsContaining(String[] words, char x) {
        final int size = words.length;
        final List<Integer> res = new ArrayList<>();

        for (int j=0; j<size; j++) {
            final String word = words[j];

            for(int k=0; k<word.length(); k++) {
                if(word.charAt(k) == x) {
                    res.add(j);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WordsContainingChar wcc = new WordsContainingChar();
        String[] words = {"apple", "banana", "cherry", "date", "grape"};
        char x = 'a';

        List<Integer> result = wcc.findWordsContaining(words, x);
        System.out.println("Indices of words containing '" + x + "': " + result);

        // Additional test
        x = 'e';
        result = wcc.findWordsContaining(words, x);
        System.out.println("Indices of words containing '" + x + "': " + result);
    }
}
