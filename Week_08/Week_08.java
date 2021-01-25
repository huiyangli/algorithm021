package Week_08;

public class Week_08 {
//    位1的个数
// you need to treat n as an unsigned value
// x & (x - 1) 清零最低位
 public int hammingWeight(int n) {
     int count = 0;
     while (n != 0) {
         count ++;
         n = n & (n - 1);
     }
     return count;
 }
//for循环判断每位是否为1，为1 count++
//%2， /2
public int hammingWeight(int n) {
    int count = 0;
    for (int i = 0; i < 32; i ++) {
        int res = n % 2;
        System.out.println(res);
        if (res == 1) {
            count ++;
        }
        if (res == 0) {
            break;
        }
        n = n / 2;
    }
    return count;
}
//2的幂
// 二进制数中有且仅有一个“1”
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
//            颠倒二进制位
public int reverseBits(int n) {
    int ans = 0;
    for (int i = 0; i < 32; i ++) {
        ans = ans << 1;
        ans = ans | (n & 1);
        n = n >> 1;
    }
    return ans;
}
//    有效的字母异位词
public boolean isAnagram(String s, String t) {
    if(s.length() != t.length()) {
        return false;
    }

    char[] s1 = s.toCharArray();
    char[] t1 = t.toCharArray();
    Arrays.sort(s1);
    Arrays.sort(t1);
    return Arrays.equals(s1,t1);
}
//    LRU缓存机制
    public class LRUCache {

        private Map<Integer, Integer> map;

        public LRUCache(int capacity) { map = new LinkedCappedHashMap<>(capacity); }

        public int get(int key) { if(!map.containsKey(key)) { return -1; } return map.get(key); }

        public void put(int key, int value) { map.put(key,value); }

        private static class LinkedCappedHashMap<K,V> extends LinkedHashMap<K,V> {
            int maximumCapacity;
            LinkedCappedHashMap(int maximumCapacity) {
                super(16, 0.75f, true); this.maximumCapacity = maximumCapacity;
            }

            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maximumCapacity;
            }

    }

}
}
