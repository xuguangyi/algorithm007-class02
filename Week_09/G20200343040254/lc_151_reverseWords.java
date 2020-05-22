package week09;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class lc_151_reverseWords {

	public String reverseWords_01(String s) {
		List<String> words = Arrays.asList(s.trim().split(" +"));
		Collections.reverse(words);
		return String.join(" ", words);
	}

	public String reverseWords_02(String s) {
		int l = 0, r = s.length() - 1;

		// 去掉开头的空白字符
		while (l <= r && s.charAt(l) == ' ')
			l++;

		// 去掉结尾的空白字符
		while (l <= r && s.charAt(r) == ' ')
			r--;

		Deque<String> d = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		while (l <= r) {
			char c = s.charAt(l);

			if (c == ' ' && sb.length() != 0) {
				d.offerFirst(sb.toString());
				sb.setLength(0);
			} else if (c != ' ') {
				sb.append(c);
			}
			l++;
		}

		d.offerFirst(sb.toString());

		return String.join(" ", d);
	}

	public String reverseWords_03(String s) {
		String[] words = s.trim().split(" +");
		// 费内存?
		Deque<String> d = new ArrayDeque<>(words.length);
		for (String w : words) {
			d.offerFirst(w);
		}
		return String.join(" ", d);
	}
}
