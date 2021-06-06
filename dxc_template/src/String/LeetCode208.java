package String;

public class LeetCode208 {
    class Trie {


        class TireNode {
            private boolean isEnd;
            TireNode[] next;
            public TireNode() {
                this.isEnd = false;
                this.next = new TireNode[26];
            }
        }

        private TireNode root;

        public Trie() {
            root = new TireNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TireNode node = root;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TireNode();
                }
                node = node.next[c - 'a'];
            }
            node.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TireNode node = root;
            for (char c : word.toCharArray()) {
                node = node.next[c - 'a'];
                if (node == null) {
                    return false;
                }
            }
            return node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TireNode node = root;
            for (char c : prefix.toCharArray()) {
                node = node.next[c - 'a'];
                if (node == null) {
                    return false;
                }
            }
            return true;
        }

    }
}
