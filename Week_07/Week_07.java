package Week_07;

public class Week_07 {
//    实现 Trie (前缀树)
private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i ++) {
            char currentChar = word.charAt(i);
            if (!node.containKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i ++) {
            char currentChar = word.charAt(i);
            if (node.containKey(currentChar)) {
                node = node.get(currentChar);
            }else {
                return null;
            }
        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
//    岛屿数量
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) return 0;

    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    // int wordLength = beginWord.length();
    int count = 1;
    while(!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i ++) {
            String word = queue.poll();
            if (changeLetter(word, endWord, queue, visited, wordSet)) {
                return count += 1;
            }
        }
        count ++;
    }
    return 0;
}

    private boolean changeLetter(String currentWord, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        // int wordLength = endWord.length();
        char[] letterChar = currentWord.toCharArray();
        for (int j = 0; j < endWord.length(); j ++){
            char currentLetter = letterChar[j];
            for (char k = 'a'; k <= 'z'; k ++) {
                if (k == currentLetter) continue;

                letterChar[j] = k;
                String nextWord = String.valueOf(letterChar);

                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)){
                        return true;
                    }

                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            letterChar[j] = currentLetter;
        }
        return false;
    }
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
                    DFS (i, j, grid);
                }
            }
        }
        return res;
    }
    private void DFS(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';


        DFS(i - 1, j, grid);
        DFS(i + 1, j, grid);
        DFS(i, j - 1, grid);
        DFS(i, j + 1, grid);
    }
//            单词接龙
}
