package Week_02;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Week_02 {
//    有效的字母异位词
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
//    字母异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();

        HashMap<String, List> map = new HashMap<String, List>();
        for (String s : strs) {
            char[] ch = new char[26];
            char[] s1 = s.toCharArray();
            for (char ch1 : s1) {
                ch[ch1 - 'a'] ++;
            }
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }

        return new ArrayList(map.values());
    }
//    两数之和
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (!map.containsKey(target - nums[i])) {
                map.put((nums[i]), i);
            }else{
                return new int[] {map.get(target - nums[i]), i};
            }
        }
        return new int[0];
    }
//    二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder (TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
//    二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        preorder(root, answer);
        return answer;
    }

    public void preorder(TreeNode root, List<Integer> list) {
        if(root != null){
            list.add(root.val);
            preorder(root.left, list);
            preorder(root.right, list);
        }
        return;
    }
//    N叉树的后序遍历
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        postOrder(root, res);
        return res;
    }

    public void postOrder(Node root, List<Integer> list) {
        if (root != null) {
            for (Node children : root.children) {
                postOrder(children, list);
            }

            list.add(root.val);
        }

    }
//    N叉树的前序遍历
    public List<Integer> preorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        preorderN(root, answer);
        return answer;
    }
    public void preorderN(Node root, List<Integer> list){
        if(root != null){
            list.add(root.val);
            for(Node children : root.children){
                preorderN(children, list);
            }
        }
        return;
    }
//    最小的k个数
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[]{};
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });


        for (int a : arr) {
            if (heap.size() < k) {
                heap.add(a);
            }else if(a < heap.peek()) {
                heap.remove();
                heap.add(a);
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i ++) {
            res[i] = heap.remove();
        }

        return res;
    }
//    丑数​
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        long[] uglyNumbers = new long[]{2,3,5};
        Set<Long> set = new HashSet<>();
        for(long uglyNumber : uglyNumbers) {
            heap.add(uglyNumber);
            set.add(uglyNumber);
        }

        long res = 1;
        for(int i = 1; i < n; i ++) {
            res = heap.poll();
            for (int j = 0; j < 3; j ++) {
                if (!heap.contains(res * uglyNumbers[j])) {
                    heap.add(res * uglyNumbers[j]);
                    set.add(res * uglyNumbers[j]);
                }
            }
        }
        return (int)res;
    }
//    前 K 个高频元素
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequent = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!frequent.containsKey(num)) frequent.put(num, 1);
            frequent.put(num, frequent.get(num) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        for (int key : frequent.keySet()) {
            if(heap.size() < k) {
                heap.add(key);
            }else if(frequent.get(key) > frequent.get(heap.peek())) {
                heap.remove();
                heap.add(key);
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i ++) {
            res[i] = heap.remove();
        }
        return res;
    }
}
