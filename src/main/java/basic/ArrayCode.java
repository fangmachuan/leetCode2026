package basic;


import cn.hutool.core.date.DateUtil;

import java.time.LocalDateTime;
import java.util.*;

public class ArrayCode {

    // 26. 删除排序数组中的重复项
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int i = 0;
            for (int i1 = 0; i1 < nums.length; i1++) {
                if (nums[i] != nums[i1]) {
                    nums[i + 1] = nums[i1];
                }
                i++;
            }
            return i;
        }
    }

    //217 存在重复元素
    class Solution2 {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> integerSet = new HashSet<>();
            for (int num : nums) {
                integerSet.add(num);
            }
            return integerSet.size() != nums.length;
        }
    }


    //只出现一次的数字
    class Solution3 {
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int num : nums) {
                if (countMap.containsKey(num)) {
                    countMap.put(num, countMap.get(num) + 1);
                } else {
                    countMap.put(num, 1);
                }
            }
            for (Integer key : countMap.keySet()) {
                if (countMap.get(key) == 1) {
                    return key;
                }
            }
            return 0;
        }
    }


    //两个数组的交集 II
    //给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。

    class Solution4 {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int n1 : nums1) {
                if (countMap.containsKey(n1)) {
                    countMap.put(n1, countMap.get(n1) + 1);
                } else {
                    countMap.put(n1, 1);
                }
            }
            List<Integer> list = new ArrayList<>();
            for (int n2 : nums2) {
                if (countMap.containsKey(n2) && countMap.get(n2) > 0) {
                    countMap.put(n2, countMap.get(n2) - 1);
                    list.add(n2);
                }
            }
            if (list.isEmpty()) {
                return new int[0];
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }


    //加一
    //给定一个表示 大整数 的整数数组 digits，其中 digits[i] 是整数的第 i 位数字。这些数字按从左到右，从最高位到最低位排列。这个大整数不包含任何前导 0。
    //
    //将大整数加 1，并返回结果的数字数组。

    static class Solution5 {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length; i >0; i--) {
                if (digits[i-1] == 9){
                    digits[i-1] = 0;
                }else {
                    digits[i-1]++;
                    return digits;
                }
            }
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            return  newDigits;
        }

        public static void main(String[] args) {
            int[] digits = new int[]{1,2,3};
            System.out.println(Arrays.toString(new Solution5().plusOne(digits)));
        }
    }


    //移动0 //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    static class Solution6 {
        public void moveZeroes(int[] nums) {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0){
                    index = index + 1;
                    nums[index-1] = nums[i];
                }
            }
            for (int i = index; i< nums.length ; i++){
                nums[i] = 0;
            }
        }
    }

    //两数之和
    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
    static class Solution7 {
        public int[] twoSum(int[] nums, int target) {
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                temp = target;
                temp = temp - nums[i];
                for (int j = i+1; j < nums.length; j++){
                    if (temp - nums[j] == 0){
                        return new int[]{i,j};
                    }
                }
            }
            return null;
        }
    }



    public static void main(String[] args) {
        LocalDateTime orderTime = DateUtil.parse("2025-11-30 00:00:00").toLocalDateTime();
        LocalDateTime newOldTemplateTime = DateUtil.parse("2025-12-01 00:00:00").toLocalDateTime();
        System.out.println(orderTime.isBefore(newOldTemplateTime));

    }
}
