package week08;

public class lc_63_uniquePathsWithObstacles {

	public int uniquePathsWithObstacles_01(int[][] obstacleGrid) {
		int width = obstacleGrid[0].length;
		int[] dp = new int[width];
		dp[0] = 1;

		for (int[] row : obstacleGrid) {
			for (int i = 0; i < width; i++) {
				if (row[i] == 1) {
					dp[i] = 0;
				} else if (i > 0) {
					dp[i] += dp[i - 1];
				}
			}
		}

		return dp[width - 1];
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if (obstacleGrid == null)
			return 0;
		if (obstacleGrid.length == 0)
			return 0;
		if (obstacleGrid[0].length == 0)
			return 0;

		int R = obstacleGrid.length;
		int C = obstacleGrid[0].length;
		int[][] dp = new int[R][C];

		dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

		// col
		for (int i = 1; i < R; i++) {
			if (obstacleGrid[i][0] == 1) {
				dp[i][0] = 0;
			} else {
				dp[i][0] = dp[i - 1][0];
			}
		}

		// row
		for (int i = 1; i < C; i++) {
			if (obstacleGrid[0][i] == 1) {
				dp[0][i] = 0;
			} else {
				dp[0][i] = dp[0][i - 1];
			}
		}

		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}

		return dp[R - 1][C - 1];
	}
}
