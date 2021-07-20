/**
 * tags:
 */
public class WordSearch79 {
    public static void main(String[] args) {
        WordSearch79 w = new WordSearch79();
        System.out.println(w.exist(new char[][]{{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }}, "ABCCED"));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWord(board, word, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isWord(char[][] board, String word, int i, int j) {
        if (board[i][j] != word.charAt(0)) {
            return false;
        }

        return isWord(board, word, i, j, 1);
    }

    private boolean isWord(char[][] board, String word, int i, int j, int k) {
        if (k >= word.length()) {
            return true;
        }

        boolean isWord = false;
        if (i < board.length - 1) {
            if (board[i + 1][j] == word.charAt(k)) {
                if (isWord(board, word, i + 1, j, k + 1)) {
                    return true;
                }
            }
        }

        if (j < board[0].length - 1) {
            if (board[i][j + 1] == word.charAt(k)) {
                isWord = isWord(board, word, i, j + 1, k + 1);
            }
        }

        return isWord;
    }
}
