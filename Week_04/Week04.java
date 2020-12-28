package Week_04;

public class Week04 {
//    二叉树的层次遍历
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allRes = new ArrayList<>();
    if (root ==  null) {
        return allRes;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);

    while(!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < size; i ++) {
            TreeNode node = nodes.poll();
            res.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allRes.add(res);
    }
    return allRes;
}
//    括号生成
//left 可以随时加，只要别超标；
//right 必须之前有左括号，且左括号个数大于右括号
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recursive(0, 0, n, "", res);
        return res;
    }

    public void recursive (int left, int right, int n, String s, List<String> res) {
        //terminator
        if (left == n && right == n){
            res.add(s);
            return;
        }
        //drill down
        if (left < n) {
            recursive(left + 1, right, n, s + "(", res);
        }
        if (left > right)
            recursive(left, right + 1, n, s + ")", res);
    }
}
//    柠檬水找零
public boolean lemonadeChange(int[] bills) {
    if (bills == null || bills.length == 0) return false;
    int five = 0, ten = 0;
    for (int i = 0; i < bills.length; i ++) {
        if (bills[i] == 5) {
            five += 1;
        }else if (bills[i] == 10) {
            five -= 1;
            ten += 1;
        }else if (ten > 0 && five > 0) {
            ten -= 1;
            five -= 1;
        }else {
            five -= 3;
        }
        if (five < 0) return false;
    }
    return true;
}
//    分发饼干
public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int res = 0;
    for (int i = 0; i < s.length; i ++) {
        if (s[i] >= g[res]) {
            res ++;
        }if (res == g.length) break;
    }
    return res;
}
//    岛屿数量
private int m;
    private int n;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == '1') {
                    res ++;
                    DFS(grid, i, j);
                }
            }
        }
        return res;
    }

    private void DFS(char[][] grid, int i, int j) {
        //terminator
        if (i < 0 || j < 0 || i >= m ||  j >= n || grid[i][j] == '0') return;
        //current process logical
        grid[i][j] = '0';
        //drill down
        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);
        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
    }
//    搜索旋转排序数组
    // 如果 target 在[mid+1,high] 序列中，则low = mid+1,否则 high = mid,关键是如何判断 target在[mid+1,high]序列中,具体判断如下：
// 当[0, mid] 序列是升序: nums[0] <= nums[mid], 当target > nums[mid] || target < nums[0] ,则向后规约
// 当[0, mid] 序列存在旋转位: nums[0] > nums[mid],当target < nums[0] && target > nums[mid],则向后规约
// 当然其他其他情况就是向前规约了

    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int mid = (right -left) / 2 + left;
                if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                    left = mid + 1;
                } else if (nums[0] > nums[mid] && target > nums[mid] && target < nums[0]) {
                    left = mid + 1;
                } else right = mid;
            }
            return left == right && nums[left] == target ? left : -1;
        }
    }
//    寻找旋转排序数组中的最小值
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right -left) / 2 + left;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
}
