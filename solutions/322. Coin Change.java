class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= amount; i++){
            dp[0][i] = amount + 1;
        }
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i - 1] <= j){
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if(dp[coins.length][amount] >= amount + 1){
            return -1;
        }
        return dp[coins.length ][amount];
    }
}
