学习笔记

位运算
• 位运算符
左移>>，右移<<，按位或|，按位与&，按位取反~，按位异或^。

异或操作的一些特点：

x^0=x

x ^ 1s = ~x

x ^ (~x) = 1s

x^x=0// 注意 1s = ~0

c = a ^ b => a ^ c = b, b ^ c = a// 交换两个数

a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c // associative

• 指定位置的位运算
1. 将 x 最右边的 n 位清零：x & (~0 << n)

2. 获取 x 的第 n 位值（0 或者 1）： (x >> n) & 1

3. 获取 x 的第 n 位的幂值：x & (1 << n)

4. 仅将第 n 位置为 1：x | (1 << n)

5. 仅将第 n 位置为 0：x & (~ (1 << n))

6. 将 x 最高位至第 n 位（含）清零：x & ((1 << n) - 1)

• 位运算的应用
• 判断奇偶：

x % 2 == 1 —> (x & 1) == 1

x % 2 == 0 —> (x & 1) == 0

• x >> 1 —> x / 2.

即： x = x / 2; —> x = x >> 1;

mid = (left + right) / 2; —>

mid = (left + right) >> 1;

• X = X & (X-1) 清零最低位的 1

• X & -X => 得到最低位的 1

• X & ~X => 0

LRU Cache

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
    
排序

![image](https://github.com/huiyangli/algorithm021/blob/main/Week_08/sort.png)

快排代码，归并代码要写熟练，归并关联题目比较多。