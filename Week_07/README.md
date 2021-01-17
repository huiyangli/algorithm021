学习笔记

字典树

最大限度地减少 无谓的字符串比较，查询效率 比哈希表高。

基本性质

1. 结点本身不存完整单词；

2. 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的 字符串；

3. 每个结点的所有子结点路径代表的字符都不相同。

并查集

配对，组团问题。

Java实现模版

    class UnionFind {
        private int count = 0; private int[] parent; 
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
        }
    } 
        public int find(int p) { 
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            } 
            return p;
        } 
    
        public void union(int p, int q) { 
            int rootP = find(p); int rootQ = find(q); 
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }
    }
    
高级搜索

• 剪枝：减去多余的查找，不必要的查找

• 双向 BFS：从头和尾同时BFS，将queue改为set

• 启发式搜索（A*）：priority 搜索

AVL 树

1. Balance Factor（平衡因子）： 是它的左子树的高度减去它的右子树的高度（有时相反）。 balance factor = {-1, 0, 1}

2. 通过旋转操作来进行平衡（四种）：左，右，左右，右左

Red-black Tree

红黑树是一种近似平衡的二叉搜索树（Binary Search Tree），它能够确保任何一 个结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉 搜索树：

• 每个结点要么是红色，要么是黑色

• 根结点是黑色

• 每个叶结点（NIL结点，空结点）是黑色的。

• 不能有相邻接的两个红色结点

• 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点。