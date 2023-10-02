package leetcode.arrays_and_hashing;

//https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75
public class _151_Reverse_Words_in_a_String {

    public static void main(String[] args) {

    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" ");
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].length() != 0) {
                sb.append(strs[i]).append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
