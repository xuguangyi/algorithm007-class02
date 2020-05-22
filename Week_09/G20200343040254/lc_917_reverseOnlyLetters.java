package week09;

import java.util.Stack;

public class lc_917_reverseOnlyLetters {

	public String reverseOnlyLetters_01(String S) {
		Stack<Character> stack = new Stack<>();

		for (char c : S.toCharArray()) {
			if (Character.isLetter(c)) {
				stack.push(c);
			}
		}

		StringBuilder ans = new StringBuilder(S.length());
		for (char c : S.toCharArray()) {
			if (Character.isLetter(c)) {
				ans.append(stack.pop());
			} else {
				ans.append(c);
			}
		}
		return ans.toString();
	}

	public String reverseOnlyLetters_02(String S) {
		
		StringBuilder ans = new StringBuilder(S.length());
		int j = S.length() - 1;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (Character.isLetter(c)) {
				while (!Character.isLetter(S.charAt(j))) {
					j--;
				}
				ans.append(S.charAt(j--));
			} else {
				ans.append(c);
			}
		}

		return ans.toString();
	}
}
