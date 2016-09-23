package leetcode392;

/**
 * Created by DamonLiu on 16/9/23.
 * <p>
 * Given a string s and a string t, check if s is subsequence of t.
 * <p>
 * You may assume that there is only lower case English letters in both s and t.
 * t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
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
            return true && isSubsequence(t.substring(1), s.substring(indexForStringTFirstLetter + 1));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
    }
}
