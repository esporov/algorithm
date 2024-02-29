package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _455_Assign_Cookies {

    public static void main(String[] args) {
        findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8});
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int j = 0;
        int i = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                j++;
                i++;
                result++;
            } else {
                j++;
            }
        }
        return result;
    }
}

//    public static int findContentChildren(int[] g, int[] s) {
//        int result = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < g.length; i ++){
//            if (!map.containsKey(g[i])){
//                map.put(g[i],1);
//            } else{
//                map.put(g[i], map.get(g[i]) + 1);
//            }
//        }
//        for (int i = 0; i < s.length; i ++){
//            if (map.containsKey(s[i])){
//                if (map.get(s[i]) > 0){
//                    map.put(s[i], map.get(s[i]) - 1);
//                    result++;
//                }
//            }
//        }
//        return result;
//    }
//}
