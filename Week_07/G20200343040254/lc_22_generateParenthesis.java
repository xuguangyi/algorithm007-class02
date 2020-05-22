package week07;

import java.util.ArrayList;
import java.util.List;

public class lc_22_generateParenthesis {

	private void helper(String s, int l, int r, int n, List<String> result) {
		if (l == n && r == n) {
			result.add(s);
		}

		if (l < n) {
			helper(s + "(", l + 1, r, n, result);
		}

		if (r < n && r < l) {
			helper(s + ")", l, r + 1, n, result);
		}
	}

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		helper("", 0, 0, n, result);
		return result;
	}
}
