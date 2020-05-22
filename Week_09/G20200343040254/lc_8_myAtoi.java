package week09;

public class lc_8_myAtoi {
	public static int myAtoi(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int ans = 0, i = 0, flag = 1;
		char[] chs = s.toCharArray();
		// 空格处理
		while (i < chs.length && chs[i] == ' ')
			i++;

		if (i == chs.length)
			return 0;

		// 正负号处理
		if (chs[i] == '-')
			flag = -1;

		// 跳过符号字符
		if (chs[i] == '+' || chs[i] == '-')
			i++;

		while (i < chs.length && Character.isDigit(chs[i])) {
			int r = chs[i] - '0';
			if (ans > (Integer.MAX_VALUE - r) / 10) {
				return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			ans = ans * 10 + r;
			i++;
		}
		return flag > 0 ? ans : -ans;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi(" "));
	}
}
