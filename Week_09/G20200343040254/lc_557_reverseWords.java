package week09;

public class lc_557_reverseWords {
	public String reverseWords_01(String s) {
		String[] words = s.split(" +");

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < words.length; i++) {
			sb.append(reverse(words[i])).append(" ");
		}

		return sb.toString();
	}

	private String reverse(String s) {
		char[] chs = s.toCharArray();
		for (int i = 0, j = chs.length - 1; i < j; i++, j--) {
			char tmp = chs[i];
			chs[i] = chs[j];
			chs[j] = tmp;
		}

		return new String(chs);
	}

	public String reverseWords_02(String s) {
		String words[] = s.split(" ");
		StringBuilder res = new StringBuilder();
		for (String word : words) {
			res.append(new StringBuffer(word).reverse().toString() + " ");
		}
		return res.toString().trim();
	}
}
