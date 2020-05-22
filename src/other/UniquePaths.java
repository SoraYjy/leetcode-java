package other;

/**
 * 62. Unique Paths
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {
    // 公式的话超过 int 了
//    public int uniquePaths(int m, int n) {
//        return (int) (getTN(m - 1 + n - 1) / (getTN(m - 1) * getTN(n - 1)));
//    }
//
//    private long getTN(int n) {
//        if (n == 0) return 1;
//        long res = 1;
//        for (int i = 1; i <= n; ++i) {
//            res *= i;
//        }
//        return res;
//    }

    /**
     * dp
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 2));
    }
}
