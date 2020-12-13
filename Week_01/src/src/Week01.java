//package src.src;
//
//import java.util.Deque;
//import java.util.LinkedList;
//
//public class Week01 {
//    public static void main(String[] args) {
//        //用 add first 或 add last 这套新的 API 改写 Deque 的代码
//        Deque<String> deque = new LinkedList<String>();
//        deque.addFirst("0");
//        deque.addLast("1");
//        deque.addFirst("2");
//        deque.addLast("3");
//
//        System.out.println(deque);
//
//        String str = deque.getFirst();
//        System.out.println(str);
//
////        while (deque.size() > 0) {
////            System.out.println(deque.getFirst());
////        }
//        System.out.println(deque);
//    }
//
////删除排序数组中的重复项
//public int removeDuplicates(int[] nums) {
//    int j = 0;
//    for (int i = 1; i < nums.length; i ++) {
//        if (nums[i] != nums[j]) {
//            j ++;
//            nums[j] = nums[i];
//        }
//    }
//    return j + 1;
//}
////旋转数组\
//    //暴力
//public void rotate(int[] nums, int k) {
//    int temp, a;
//    for (int i = 0; i < k; i ++) {
//        a = nums[nums.length - 1];
//        for (int j = 0; j < nums.length; j ++) {
//            temp = nums[j];
//            nums[j] = a;
//            a = temp;
//        }
//    }
//}
////翻转
//public void rotate(int[] nums, int k) {
//    k = k % nums.length; //处理nums的长度小于k的情况
//    reverse(nums, 0, nums.length - 1);
//    reverse(nums, 0, k - 1);
//    reverse(nums, k, nums.length - 1);
//}
//
//    public void reverse(int[] a, int start, int end) {
//        int temp;
//        while(start < end) {
//            temp = a[start];
//            a[start] = a[end];
//            a[end] = temp;
//            start ++;
//            end --;
//        }
//
//    }
//// 合并两个有序链表
//public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//    ListNode prevNode = new ListNode();
//    ListNode prev = prevNode;
//    while (l1 != null && l2 != null) {
//        if (l1.val <= l2.val) {
//            prev.next = l1;
//            l1 = l1.next;
//        }else {
//            prev.next = l2;
//            l2 = l2.next;
//        }
//        prev = prev.next;
//    }
//    ListNode last = l1 == null ? l2 : l1;
//    prev.next = last;
//    return prevNode.next;
//}
////两数之和
//public int[] twoSum(int[] nums, int target) {
//    for (int i = 0; i < nums.length; i++){
//        for (int j= i+1; j< nums.length; j++){
//            if (nums[j] == target - nums[i])
//                return new int[] {i,j};
//        }
//    }
//    throw new IllegalArgumentException("no result");
//}
////加1
//public int[] plusOne(int[] digits) {
//    int len = digits.length;
//    for (int i = len - 1; i >= 0; i --) {
//        if (digits[i] != 9) {
//            digits[i] +=1;
//            return digits;
//        }
//        digits[i] = 0;
//    }
//    digits = new int[len + 1];
//    digits[0] = 1;
//    return digits;
//}
//}
