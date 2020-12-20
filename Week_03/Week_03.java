package Week_03;

public class Week_03 {
//    括号生成
//left 可以随时加，只要别超标；
//right 必须之前有左括号，且左括号个数大于右括号
class Solution {
    private List<String> res ;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        recursive(0, 0, n, "");
        return res;
    }

    public void recursive (int left, int right, int n, String s) {
        //terminator
        if (left == n && right == n){
            res.add(s);
            return;
        }
        //drill down
        if (left < n) {
            recursive(left + 1, right, n, s + "(");
        }
        if (left > right)
            recursive(left, right + 1, n, s + ")");
    }
}
//验证二叉搜索树
//递归解法
class Solution {
    public boolean isValidBST(TreeNode root) {
        return recursive(root, null, null);
    }

    public boolean recursive(TreeNode root, Integer lower, Integer upper) {
        //空树符合条件
        if (root == null) return true;

        int val = root.val;

        if (!recursive(root.left, lower, val)) return false;
        if (!recursive(root.right, val, upper)) return false;
        //任何左节点大于根 或 右节点小于根 不符合
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        return true;
    }
}


    //中序遍历， 左中右
    class Solution {
        TreeNode prev;
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isValidBST(root.left)) return false;

            if (prev != null && prev.val >= root.val) return false;

            prev = root;

            if (!isValidBST(root.right)) return false;



            return true;
        }
    }
//        二叉树的最大深度
class Solution {
    public int maxDepth(TreeNode root) {
        int res = recur(root, 0);
        return res;
    }
    public int recur(TreeNode root, int depth){
        //terminator
        if (root == null){
            return depth;
        }
        //drill down
        depth = Math.max(recur(root.left, depth+1), recur(root.right, depth+1));
        return depth;
    }
}
//    二叉树的最小深度
public int minDepth(TreeNode root) {
    if (root ==  null) return 0;
    if (root.left == null && root.right == null) return 1;

    int min_depth = Integer.MAX_VALUE;
    if (root.left != null) {
        min_depth = Math.min(minDepth(root.left), min_depth);
    }
    if (root.right != null) {
        min_depth = Math.min(minDepth(root.right), min_depth);
    }

    return min_depth + 1;
}
//Pow(x, n)
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return quickPow(x, N);
    }

    public double quickPow(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickPow(x, N / 2);
        // if (N % 2 == 0) {
        //     return y * y;
        // }
        // return y * y * x;
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
//    电话号码的字母组合
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList();
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<String>();
        recur("", 0, digits, res, map);
        return res;
    }

    public void recur(String s, int i, String digits, List<String> res, HashMap<Character, String> map) {
        //terminator
        if (i == digits.length()) {
            res.add(s);
            return;
        }

        //current logical
        String letter = map.get(digits.charAt(i));
        for (int j = 0; j < letter.length(); j ++) {
            //drill down
            recur(s + letter.charAt(j), i + 1, digits, res, map);
        }
    }
}
//            二叉树的最近公共祖先
class Solution {

    private TreeNode ans;

    public Solution() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
}
//    从前序与中序遍历序列构造二叉树
class Solution {
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int size = preorder.length;
        map = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i ++) {
            map.put(inorder[i], i);
        }
        return buildBTree(preorder, inorder, 0, size - 1, 0, size - 1);
    }

    public TreeNode buildBTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        //terminator
        if (preorder_left > preorder_right) return null;

        //current processing logical
        int inorder_root_index = map.get(preorder[preorder_left]);
        TreeNode root = new TreeNode(preorder[preorder_left]);
        int left_tree = inorder_root_index - inorder_left;

        //drill down
        root.left = buildBTree(preorder, inorder, preorder_left + 1, preorder_left + left_tree, inorder_left, inorder_root_index - 1);
        root.right = buildBTree(preorder, inorder, preorder_left + left_tree + 1, preorder_right, inorder_root_index + 1, inorder_right);

        //reverse

        return root;

    }
}
}
