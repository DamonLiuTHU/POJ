package leetcode392;

/**
 * Created by DamonLiu on 16/9/23.
 */
//public class Solution {
//
//}

public class Solution {
    public boolean isSubsequence(String t, String s) {
        if (t.length() == 0) {
            return true;
        }
        int indexForStringTFirstLetter = s.indexOf(t.charAt(0));
        if (indexForStringTFirstLetter >= 0) {
            return true && isSubsequence(t.substring(1),s.substring(indexForStringTFirstLetter + 1));
        } else {
            return false;
        }
    }
    public static void main(String[] args){
        System.out.println(new Solution().isSubsequence("abc","ahbgdc"));
    }
}
