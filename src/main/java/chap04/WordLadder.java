package chap04;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(words);
        System.out.println("solve() = " + solve("hit", "cog", wordList));
    }

    static int solve(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        //중복허용 방지
        Set<String> dict = new HashSet<>(wordList);

        q.offer(beginWord);
        dict.add(endWord);
        dict.remove(beginWord);

        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                if(str.equals(endWord)) return level;
                for (String neighbor: neighbors(str, wordList)) {
                    q.offer(neighbor);
                }
            }
            level++;
        }
        return level;
    }

    static List<String> neighbors(String s, List<String> wordList) {
        List<String> result = new LinkedList<>();
        //중복허용 방지
        Set<String> dict = new HashSet<>(wordList);

        for (int i = 0; i < s.length(); i++) {
            char[] charArr = s.toCharArray();
            for (char ch='a'; ch <= 'z'; ch++) {
                charArr[i] = ch; //ait~zit
                String word = new String(charArr);
                if (dict.remove(word)) {
                    result.add(word);
                }
            }
        }
        return result;
    }
}
