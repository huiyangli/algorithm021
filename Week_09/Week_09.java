package Week_09;

public class Week_09 {
//    不同路径
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
//            打家劫舍
public int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int len = nums.length;
    int[] dp = new int[len + 1];
    if (nums.length == 1) return nums[0];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < len; i ++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[len - 1];
}
//    最小路径和
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
//            买卖股票的最佳时机
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
//    字符串中的第一个唯一字符
public int firstUniqChar(String s) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i ++) {
        char ch = s.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    for (int j = 0; j < s.length(); j ++) {
        if (map.get(s.charAt(j)) == 1) {
            return j;
        }
    }
    return -1;
}
    //有效的字母异位词
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;

    int[] map = new int[26];

    for (int i = 0; i < s.length(); i ++) {
        map[s.charAt(i) - 'a'] ++;
    }
    for (int i = 0; i < t.length(); i ++) {
        map[t.charAt(i) - 'a'] --;
        if (map[t.charAt(i) - 'a'] < 0) {
            return false;
        }
    }
    return true;
}
}
