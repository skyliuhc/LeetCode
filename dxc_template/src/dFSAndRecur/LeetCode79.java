package dFSAndRecur;

public class LeetCode79 {
    int n, m;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int u) {
        if (board[x][y] != word.charAt(u)) {
            return false;
        }
        if (u == word.length() - 1) {
            return true;
        }
        board[x][y] = '.';
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m) {
                if (dfs(board, a, b, word, u + 1)){
                    return true;
                }
            }
        }
        board[x][y] = word.charAt(u);
        return false;
    }


}
