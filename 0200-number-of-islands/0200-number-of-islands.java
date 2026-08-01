class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length, count = 0;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(i, j, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }

    class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void bfs(int i, int j, boolean[][] visited, char[][] grid) {
        int n = grid.length, m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Pair front = q.remove();
            int row = front.row;
            int col = front.col;

            // Bottom
            if (row + 1 < n && !visited[row + 1][col] && grid[row + 1][col] == '1') {
                q.add(new Pair(row + 1, col));
                visited[row + 1][col] = true;
            }

            // Right
            if (col + 1 < m && !visited[row][col + 1] && grid[row][col + 1] == '1') {
                q.add(new Pair(row, col + 1));
                visited[row][col + 1] = true;
            }

            // Left
            if (col > 0 && !visited[row][col - 1] && grid[row][col - 1] == '1') {
                q.add(new Pair(row, col - 1));
                visited[row][col - 1] = true;
            }

            // Top
            if (row > 0 && !visited[row - 1][col] && grid[row - 1][col] == '1') {
                q.add(new Pair(row - 1, col));
                visited[row - 1][col] = true;
            }
        }
    }
}