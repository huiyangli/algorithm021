package src.src;

public class test {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,6,7};
        merge(nums1, 3, nums2, 3);
        System.out.println(nums1);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p_nums1_copy = 0, p_nums2 = 0, p_nums1 = 0;
        while(p_nums1_copy < m && p_nums2 < n) {
            nums1[p_nums1] = (nums1_copy[p_nums1_copy] < nums2[p_nums2]) ? nums1_copy[p_nums1_copy] : nums2[p_nums2];
            p_nums1 ++;
            p_nums1_copy ++;
            p_nums2 ++;
        }
        if (p_nums1_copy <  m) {
            System.arraycopy(nums1_copy, p_nums1_copy, nums1, p_nums1_copy + p_nums2, m - p_nums1_copy);
        }
        if (p_nums2 < n) {
            System.arraycopy(nums2, p_nums2, nums1, p_nums1_copy + p_nums2, n - p_nums2);
        }
    }
}
