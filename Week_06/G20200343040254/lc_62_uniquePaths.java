package week06;

import java.util.Arrays;

public class lc_62_uniquePaths {

	public static int uniquePaths_01(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++)
			dp[i][0] = 1;

		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		uniquePaths_01(3, 2);
	}

	public static int uniquePaths_02(int m, int n) {
		int[] c = new int[n];
		Arrays.fill(c, 1);

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				c[j] += c[j - 1];
			}
		}
		return c[n - 1];
	}

	public static int uniquePaths_03(int m, int n) {
//		long result = 1;
//	     for(int i=0;i<Math.min(m-1,n-1);i++)
//	         result = result*(m+n-2-i)/(i+1); 
//	     return (int)result;
//		
		long r = 1;

		int c = Math.min(m - 1, n - 1);
		for (int i = 0; i < c; i++) {
			r =r* (m + n - 2 - i) / (i + 1);
		}
		return (int) r;
	}
}
