package Week_06;

public class Week_06 {
//    不同路径
     class Solution {
     public int uniquePaths(int m, int n) {
         int[][] dp = new int[m][n];
         for (int i = 0; i < m; i ++) {
             for (int j = 0; j < n; j ++) {
                 if (i == 0 || j == 0) {
                     dp[i][j] = 1;
                 }else {
                     dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                 }
             }
         }
         return dp[m - 1][n - 1];
     }
 }
//空间优化
    class Solution {
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 0; i < m; i ++) {
                for (int j = 1; j <= n; j ++) {
                    dp[j] += dp[j - 1];
                }
            }
            return dp[n];
        }
    }
//    不同路径 II
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[] dp = new int[n + 1];
    dp[1] = 1;

    for (int i = 0; i < m; i ++) {
        for (int j = 1; j <= n; j ++) {
            if (obstacleGrid[i][j - 1] == 1) {
                dp[j] = 0;
            }else {
                dp[j] += dp[j - 1];
            }
        }
    }
    return dp[n];
}
//    最长公共子序列
public int longestCommonSubsequence(String text1, String text2) {
    // if (text1 == null || text2 == null) return 0;
    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m + 1][n + 1];

    char[] char1 = text1.toCharArray();
    char[] char2 = text2.toCharArray();
    for (int i = 1; i <= m; i ++) {
        for (int j = 1; j <= n; j ++) {
            if (char1[i - 1] == char2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            }else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
    return dp[m][n];
}
//            爬楼梯
//    三角形最小路径和
public int minimumTotal(List<List<Integer>> triangle) {
    int row = triangle.size();
    int[] dp = new int[row + 1];
    for (int i = row - 1; i >= 0 ; i --) {
        for (int j = 0; j <= i; j ++) {
            dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
        }
    }
    return dp[0];
}
//            最大子序和
//1.暴力，枚举起点和终点，优化起点和终点必须大于零，O(n^2)
//2.DP,
// a. 分治（子问题）max_sum(i) = Max(sub_max_sum(i - 1), 0) + a[i]
// b. 状态数组 f[i]
// c. DP方程: f[i] = Max(f[i - 1], 0) + a[i]
class Solution {
    public int maxSubArray(int[] nums) {
        // int[] dp = new int[nums.length + 1];
        int ans = nums[0];
        // dp = nums;
        for (int i = 1; i < nums.length; i ++) {
            nums[i] = Math.max(nums[i - 1], 0) + nums[i];
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }
}
//            零钱兑换
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i ++) {
        for (int coin : coins) {
            if (i >= coin) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }
    return dp[amount] == amount + 1 ? -1 : dp[amount];
}
//    打家劫舍
public int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int len = nums.length;
    int[] dp = new int[len];
    if(len == 1) return nums[0];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < len; i ++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[len - 1];
}
//    打家劫舍 II
public int rob(int[] nums) {
    int n = nums.length;
    if (n <= 1) return n == 0 ? 0 : nums[0];
    int[] dp1 = new int[n];
    int[] dp2 = new int[n];

    dp1[0] = nums[0];
    dp1[1] = Math.max(nums[0], nums[1]);

    dp2[0] = 0;
    dp2[1] = nums[1];

    for (int i = 2; i < n - 1; i ++) {
        dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
    }

    for (int i = 2; i < n; i ++) {
        dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
    }
    return Math.max(dp1[n - 2], dp2[n - 1]);
}
//    买卖股票的最佳时机
    //暴力法
public int maxProfit(int[] prices) {
    int len = prices.length;
    if(len < 2) return 0;

    int res = 0;
    for (int i = 0; i < len; i ++) {
        for (int j = i + 1; j < len; j ++) {
            res = Math.max(res, prices[j] - prices[i]);
        }
    }
    return res;
}
//DP二维数组
public int maxProfit(int[] prices) {
    int len = prices.length;
    if (len < 2) return 0;
    int[][] dp = new int[len][2];
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < len; i ++) {
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
    }
    return dp[len - 1][0];
}
//DP空间优化
public int maxProfit(int[] prices) {
    int len = prices.length;
    if (len < 2) return 0;
    int[] dp = new int[2];
    dp[0] = 0;
    dp[1] = -prices[0];
    for (int i = 1; i < len; i ++) {
        dp[0] = Math.max(dp[0], dp[1] + prices[i]);
        dp[1] = Math.max(dp[1], -prices[i]);
    }
    return dp[0];
}

//    跳跃游戏
public boolean canJump(int[] nums) {
    if(nums.length == 0) return false;
    if(nums.length == 1) return true;
    int[] dp = new int[nums.length + 1];
    dp[0] = nums[0];
    for (int i = 1; i <= nums.length; i ++) {
        if (i > dp[i - 1]) return false;
        else {
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
            if (dp[i] >= nums.length - 1) return true;
        }
    }
    return false;
}
//    跳跃游戏 II
public int jump(int[] nums) {
    int res = 0;
    int len = nums.length - 1;
    while (len > 0) {
        for (int i = 0; i < len; i ++) {
            if (nums[i] + i >= len) {
                len = i;
                res ++;
                break;
            }
        }
    }
    return res;
}
//最小路径和
public int minPathSum(int[][] grid) {
    if (grid.length == 0 || grid == null) return 0;
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m + 1][n + 1];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < m; i ++) {
        dp[i][0] = dp[i - 1][0] + grid[i][0];
    }
    for (int j = 1; j < n; j ++) {
        dp[0][j] = dp[0][j - 1] + grid[0][j];
    }
    for (int i = 1; i < m; i ++) {
        for (int j = 1; j < n; j ++) {
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        }
    }
    return dp[m - 1][n - 1];
}
}
