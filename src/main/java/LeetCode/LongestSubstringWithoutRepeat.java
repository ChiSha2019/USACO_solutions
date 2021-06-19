package LeetCode;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s) {
        int r = 0;
        int l = 0;
        int maxUnrepeatedLen = 0;
        HashSet<Character> mySet = new HashSet<>();
        while (r< s.length() && l<s.length()){
            char newChar = s.charAt(r);
            if (mySet.contains(newChar)){
                if (r-l > maxUnrepeatedLen) maxUnrepeatedLen = r-l;
                mySet.remove(s.charAt(l));
                l++;
            }else{
                mySet.add(s.charAt(r));
                r++;
            }
        }
        if (mySet.size() > maxUnrepeatedLen) maxUnrepeatedLen = mySet.size();
        return maxUnrepeatedLen;
    }
}
