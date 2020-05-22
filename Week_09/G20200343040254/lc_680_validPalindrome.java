package week09;

public class lc_680_validPalindrome {
	public static boolean validPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				return helper(s, i + 1, j) || helper(s, i, j - 1);
			}
		}
		return true;
	}

	private static boolean helper(String s, int i, int j) {
		for (int k = i; k <= i + (j - i) / 2; k++) {
			if (s.charAt(k) != s.charAt(j - k + i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(validPalindrome("eccer"));
	}
}
