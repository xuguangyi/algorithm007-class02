package week09;

public class lc_541_reverseStr {

	public String reverseStr(String s, int k) {
		if (s == null || s.length() == 0)
			return s;

		char[] chs = s.toCharArray();

		for (int st = 0; st < chs.length; st += 2 * k) {
			int i = st;
			int j = Math.min(st + k -1, chs.length - 1);
			while(i < j) {
				char c = chs[i];
				chs[i++] = chs[j];
				chs[j--] = c;
			}
		}
		
		return new String(chs);

	}
}
