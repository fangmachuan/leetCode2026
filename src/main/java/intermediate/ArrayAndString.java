package intermediate;

import java.util.*;

public class ArrayAndString {

    ////给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
    ////k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
    ////
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if(nums.length < 3){
                return null;
            }
            Arrays.sort(nums);
            List<List<Integer>> allList = new ArrayList<>();
            for (int indexI = 0; indexI < nums.length; indexI++) {
                if (nums[indexI] > 0){
                    break;
                }
                int left = indexI + 1;
                int right = nums.length - 1;
                while (left < right){
                    int temp = nums[indexI] + nums[left] + nums[right];
                    if (temp == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[indexI]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        if (!allList.contains(list)){
                            allList.add(list);
                        }
                    }
                    if (temp > 0){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
            return  allList;
        }
    }

    public static void main(String[] args) {
        new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }


    //无重复字符的最长子串
    static class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            if (s.isEmpty()){
                return 0;
            }
            if (s.length() == 1){
                return 1;
            }
            char[] charArray = s.toCharArray();
            int maxLength = 0;
            for (int i = 0; i < charArray.length; i++) {
                List<String> list = new ArrayList<>();
                list.add(String.valueOf(charArray[i]));
                for (int j = i + 1; j < charArray.length; j++) {
                    if (list.contains(String.valueOf(charArray[j]))){
                        break;
                    }
                    list.add(String.valueOf(charArray[j]));
                }
                maxLength = Math.max(maxLength, list.size());
            }
            return maxLength;
        }

        public static void main(String[] args) {
            System.out.println(new Solution2().lengthOfLongestSubstring("au"));
        }
    }


    //最长回文子串
    //给你一个字符串 s，找到 s 中最长的 回文 子串。
    static class Solution3 {
        public String longestPalindrome(String s) {
            if (s.isEmpty()){
                return "";
            }
            if (s.length() == 1){
                return s;
            }


        }
    }

}
