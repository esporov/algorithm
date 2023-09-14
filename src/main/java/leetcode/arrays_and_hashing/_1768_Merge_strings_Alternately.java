package leetcode.arrays_and_hashing;

//https://leetcode.com/problems/merge-strings-alternately/submissions/1047839597/?envType=study-plan-v2&envId=leetcode-75
public class _1768_Merge_strings_Alternately {
    public static void main(String[] args) {

        System.out.println(mergeAlternately("ab","pqrs"));
    }

    public static String mergeAlternately(String word1, String word2) {
        if (word1.length() == 0) {
            return word2;
        }
        if (word2.length() == 0) {
            return word1;
        }
        int w1 = 1;
        int w2 = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(word1.charAt(0));
        for (int i = 1; i < word1.length() + word2.length(); i++) {
            if (i % 2 == 0) {
                sb.append(word1.charAt(w1));
                w1++;
            } else {
                sb.append(word2.charAt(w2));
                w2++;
            }
            if (word1.length() == w1 ) {
                sb.append(word2, w2, word2.length());
                break;
            }
            if (word2.length() == w2 ) {
                sb.append(word1, w1, word1.length());
                break;
            }
        }
        return sb.toString();
    }
}
