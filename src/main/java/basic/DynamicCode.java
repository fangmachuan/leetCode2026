package basic;

public class DynamicCode {


    //爬楼梯
    static class Solution {
        public int climbStairs(int n) {
            if (n <= 2){
                return n;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }


    //爬楼梯
    static class Solution1 {
        public int climbStairs(int n) {
            if (n <= 2){
                return n;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for(int i = 3; i<= n; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }

        public static void main(String[] args) {
            System.out.println(new Solution1().climbStairs(3));
        }
    }


    //买卖股票的最佳时机
    static class Solution2 {
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            return 0;
        }
    }

}
