class Solution {
    int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        int fresh = 0;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (!queue.isEmpty() && fresh > 0 ) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                Pair curr = queue.poll();
                int r = curr.row;
                int c = curr.col;
                for (int[] dir : direction) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr < 0 || nc < 0 || nr >= row || nc >= col || grid[nr][nc] != 1) {
                        continue;
                    }
                    if (grid[nr][nc] == 1) {
                        fresh--;
                        queue.add(new Pair(nr, nc));
                        grid[nr][nc] = 2;
                    }
                }
            }
            res++;
        }
        if (fresh == 0) {
            return res;
        }
        return -1;
    }
}

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}