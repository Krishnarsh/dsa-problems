class Solution {
    public int maxProfit(int[] prices) {
        int [] dp = new int [prices.length - 1];
        int res = 0;
        int ans = 0;
        for(int i = 0 ; i < prices.length - 1 ; i++) {
            dp[i] = prices[i+1] - prices[i];
            res += dp[i];
            if(res > ans) {ans = res;}
            else if(res < 0) res = 0;
        }
        return ans;
    }
}