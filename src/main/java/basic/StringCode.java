package basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringCode {


    ////编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
    static class Solution {
        public void reverseString(char[] s) {
            int index = 0;
            for (int i = 0; i < s.length; i++) {
                if (index == s.length/2){
                    break;
                }
                char temp = s[i];
                s[i] = s[s.length-1-i];
                s[s.length-1-i] = temp;
               index = index + 1;
            }
        }

        public static void main(String[] args) {
            char[] s = new char[]{'h','e','l','l','o'};
            new Solution().reverseString(s);
        }
    }

    //整数反转
    //给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
    static class Solution2 {
        public int reverse(int x) {
            char[] charArray = String.valueOf(x).toCharArray();
            int index = 0;
            for (int i = 0; i < charArray.length; i++) {
                if (index == charArray.length/2){
                    break;
                }
                char temp = charArray[i];
                charArray[i] = charArray[charArray.length-1-i];
                charArray[charArray.length-1-i] = temp;
                index = index + 1;
            }
            if (charArray[charArray.length - 1] == '-'){
                for (int i = charArray.length - 1; i > 0; i--) {
                    charArray[i] = charArray[i - 1];
                }
                charArray[0] = '-';
            }
            try {
               return Integer.parseInt(new String(charArray).trim());
            }catch (NumberFormatException e){

                return 0;
            }
        }

        public static void main(String[] args) {
            System.out.println(new Solution2().reverse(1534236469));
        }
    }


    //字符串中的第一个唯一字符
    static class Solution3 {
        public int firstUniqChar(String s) {
            char[] charArray = s.toCharArray();
            Map<String, Integer> countMap = new HashMap<>();
            for (int i = 0; i < charArray.length; i++) {
                countMap.put(String.valueOf(charArray[i]), countMap.getOrDefault(String.valueOf(charArray[i]), 0) + 1);
            }
            for (int i = 0; i < charArray.length; i++) {
                if (countMap.get(String.valueOf(charArray[i])) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    //有效的字母异位词

    static class Solution4 {
        public boolean isAnagram(String s, String t) {
            char[] scharArray = s.toCharArray();
            char[] tcharArray = t.toCharArray();
            Arrays.sort(scharArray);
            Arrays.sort(tcharArray);
            return Arrays.equals(scharArray, tcharArray);
        }
    }


    //验证回文串
    static class Solution5 {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            char[] charArray = s.toCharArray();
            String newS = "";
            for (int i = 0; i < charArray.length; i++) {
                //只保留字母
                if (!Character.isLetterOrDigit(charArray[i])) {
                    continue;
                }
                newS = newS + charArray[i];
            }
            charArray = newS.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] != charArray[charArray.length - i-1]){
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            System.out.println(new Solution5().isPalindrome("A man, a plan, a canal: Panama"));
        }
    }


    //字符串转换整数 (atoi)  不做
    static class Solution6 {
        public int myAtoi(String s) {
            return Integer.parseInt(s);
        }
    }

    // 实现 strStr()
    static class Solution7 {
        public int strStr(String haystack, String needle) {
            if(haystack.length() < needle.length()){
                return -1;
            }
            char[] charArray = haystack.toCharArray();
            char[] charArray1 = needle.toCharArray();
            char  start =  charArray1[0];
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == start){
                    for (int j = 0; j < charArray1.length; j++) {
                        if (i+j >= charArray.length){
                            return -1;
                        }
                        if (charArray[i+j] != charArray1[j]){
                            break;
                        }
                        if (j == charArray1.length-1){
                            return i;
                        }
                    }
                }
            }
            return -1;
        }
    }

    //外观数列
    static class Solution8 {
        public String countAndSay(int n) {
            String returns  = "";
            Map<Integer, Integer> countMap = new HashMap<>();
            String s = String.valueOf(n);
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                countMap.put((int) charArray[i], countMap.getOrDefault(charArray[i], 0) + 1);
            }
            String  newS = "";
            for (Integer key : countMap.keySet()){
                newS = newS + countMap.get(key);
            }
            return newS;

        }

        public static void main(String[] args) {
            System.out.println(new Solution8().countAndSay(2));
        }

    }



    //最长公共前缀
    static class Solution9 {
        public String longestCommonPrefix(String[] strs) {
            String arrS1 = strs[0];
            for (int i = 1; i < strs.length; i++) {
                String arrS2 = strs[i];
                int arr1length = arrS1.length();
                for (int i1 = 0; i1 < arr1length; i1++) {
                    if (arrS2.startsWith(arrS1)){
                    }else {
                        arrS1 = arrS1.substring(0, arrS1.length()-1);
                    }
                }
            }
            return arrS1;
        }

        public static void main(String[] args) {
            System.out.println(new Solution9().longestCommonPrefix(new String[]{"reflower","flow","flight"}));
        }
    }




}
