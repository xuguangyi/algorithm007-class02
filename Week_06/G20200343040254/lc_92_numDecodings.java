package week06;

public class lc_92_numDecodings {

	public int numDecodings_01(String s) {

		if (s == null || s.length() == 0)
			return 0;

		char[] chs = s.toCharArray();
		int dp[] = new int[chs.length + 1];

		dp[0] = 1;
		dp[1] = chs[0] == '0' ? 0 : 1;

		if (chs.length <= 1)
			return dp[1];

		for (int i = 2; i <= chs.length; i++) {

			int n = (chs[i - 2] - '0') * 10 + (chs[i - 1] - '0');

			if (chs[i - 1] == '0' && chs[i - 2] == '0') {
				return 0;
			} else if (chs[i - 2] == '0') {
				dp[i] = dp[i - 1];
			} else if (chs[i - 1] == '0') {
				if (n > 26)
					return 0;
				dp[i] = dp[i - 2];
			} else if (n > 26) {
				dp[i] = dp[i - 1];
			} else {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}

		return dp[dp.length - 1];

	}

	public int numDecodings_02(String s) {

		/**
		 * if（chs[i] == 0） dp[i] = 0; if (chs[i] + chs[i+1] <=26) { dp[i] = dp[i+1] +
		 * dp[i+2]; } else dp[i] = dp[i+1];
		 */

		if (s == null || s.length() == 0)
			return 0;

		char[] chs = s.toCharArray();
		int len = chs.length;
		int dp[] = new int[len + 1];

		dp[len] = 1;
		dp[len - 1] = chs[len - 1] == '0' ? 0 : 1;

		for (int i = len - 2; i >= 0; i--) {
			if (chs[i] == '0') {
				dp[i] = 0;
				continue;
			}

			if ((chs[i] - '0') * 10 + (chs[i + 1] - '0') <= 26) {
				dp[i] = dp[i + 1] + dp[i + 2];
			} else {
				dp[i] = dp[i + 1];
			}
		}

		return dp[0];
	}

	public int numDecodings_03(String s) {

		if (s == null || s.length() == 0)
			return 0;

		char[] chs = s.toCharArray();
		int len = chs.length;

		int x = 1, ans;
		ans = chs[len - 1] == '0' ? 0 : 1;

		for (int i = len - 2; i >= 0; i--) {

			if (chs[i] == '0') {
				x = ans;
				ans = 0;
				continue;
			}

			if ((chs[i] - '0') * 10 + (chs[i + 1] - '0') <= 26) {
				ans += x;
				x = ans - x;
			} else {
				x = ans;
			}
		}

		return ans;
	}
}
