package src.kakao.blind;

import java.util.Arrays;

public class 가사검색 {

    class Trie {
        Trie[] child = new Trie[26];
        int count;
        int aletter = Character.getNumericValue('a');

        void insert(String str) {
            Trie current = this;

            for (char ch : str.toCharArray()) {
                current.count++;
                int index = Character.getNumericValue(ch) - aletter;

                if (current.child[index] == null) {
                    current.child[index] = new Trie();
                }

                current = current.child[index];
            }

            current.count++;
        }

        int search(String str) {
            Trie current = this;
            for (char ch : str.toCharArray()) {

                if (ch == '?') {
                    return current.count;
                }

                current = current.child[Character.getNumericValue(ch) - aletter];

                if (current == null) {
                    return 0;
                }
            }

            return 0;
        }
    }

    Trie[] TrieRoot = new Trie[10000];
    Trie[] ReverseTrieRoot = new Trie[10000];

    public int[] solution(String[] words, String[] queries) {
        int[] answer = {};

        answer = new int[queries.length];

        int answerIndex = 0;

        for (String str : words) {
            int index = str.length() - 1;

            if (TrieRoot[index] == null) {
                TrieRoot[index] = new Trie();
                ReverseTrieRoot[index] = new Trie();
            }

            TrieRoot[index].insert(str);
            str = new StringBuilder(str).reverse().toString();
            ReverseTrieRoot[index].insert(str);
        }

        for (String str : queries) {
            int index = str.length() - 1;

            if (TrieRoot[index] == null) {
                answer[answerIndex++] = 0;
                continue;
            }

            if (str.charAt(0) != '?') {
                answer[answerIndex++] = TrieRoot[index].search(str);
            } else {
                str = new StringBuilder(str).reverse().toString();
                answer[answerIndex++] = ReverseTrieRoot[index].search(str);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        가사검색 instance = new 가사검색();

        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        System.out.println(Arrays.toString(instance.solution(words, queries)));
    }
}
