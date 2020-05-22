package week07;

public class lc_64_minPathSum {
	public int minPathSum_01(int[][] grid) {
		int N = grid.length;
		int M = grid[0].length;
		int[][] dp = new int[N][M];

		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				if (i == N - 1 && j != M - 1) {
					// row
					dp[i][j] = grid[i][j] + dp[i][j + 1];
				} else if (j == M - 1 && i != N - 1) {
					// col
					dp[i][j] = grid[i][j] + dp[i + 1][j];
				} else if (i != N - 1 && j != M - 1) {
					dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
				} else {
					dp[i][j] = grid[i][j];
				}
			}
		}
		return dp[0][0];
	}

	public int minPathSum(int[][] grid) {
		int N = grid.length;
		int M = grid[0].length;
		int[] dp = new int[M];

		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				if (i == N - 1 && j != M - 1) {
					dp[j] = grid[i][j] + dp[j + 1];
				} else if (j == M - 1 && i != N - 1) {
					dp[j] = grid[i][j] + dp[j];
				} else if (i != N - 1 && j != M - 1) {
					dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
				} else {
					dp[j] = grid[i][j];
				}
			}
		}
		return dp[0];

	}
}
