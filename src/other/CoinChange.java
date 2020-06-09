package other;

/**
 * 322. Coin Change
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {
    /**
     * dp
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int size = coins.length;
        dp[0] = 0;
        for (int i = 1; i < amount + 1; ++i) {
            int min = -1;
            for (int j = 0; j < size; ++j) {
                int value = coins[j];
                if (i - value >= 0) {
                    if (dp[i - value] != -1) {
                        min = ((min != -1) && (min < dp[i - value])) ? min : dp[i - value];
                    }
                }
            }
            dp[i] = min == -1 ? min : min + 1;
        }
        return dp[amount];
    }

}
