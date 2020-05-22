package week09;

public class lc_5_longestPalindrome {
	public String longestPalindrome_01(String s) {
		if (s == null || s.length() == 0)
			return s;

		int n = s.length();
		String res = "";
		boolean[][] dp = new boolean[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
				if (dp[i][j] && j - i + 1 > res.length()) {
					res = s.substring(i, j + 1);
				}
			}
		}
		return res;
	}

	private int lo, maxLen;

	public String longestPalindrome(String s) {
		if (s == null || s.length() < 2)
			return s;
		int len = s.length();

		for (int i = 0; i < len - 1; i++) {
			ext(s, i, i);// odd length
			ext(s, i, i + 1); // even length
		}
		return s.substring(lo, lo + maxLen);
	}

	private void ext(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}

		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}

}
