package week06;

public class lc_221_maximalSquare {
	public int maximalSquare_01(char[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return 0;
		if (matrix[0] == null || matrix[0].length == 0)
			return 0;

		int N = matrix.length;
		int M = matrix[0].length;
		int[][] dp = new int[N + 1][M + 1];

		int max = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max * max;

	}

	public int maximalSquare(char[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return 0;
		if (matrix[0] == null || matrix[0].length == 0)
			return 0;

		int N = matrix.length;
		int M = matrix[0].length;
		int[][] dp = new int[N][M];
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						// dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
						dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
					}

					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max * max;
	}
}
