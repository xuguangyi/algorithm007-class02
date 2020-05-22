package week09;

import java.util.HashMap;

public class lc_387_firstUniqChar {

	public int firstUniqChar_01(String s) {
		
		if (s == null || s.length() == 0)
			return -1;
		
		char[] chs = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>(chs.length);
		for (char c : chs) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		for (int i = 0; i < chs.length; i++) {
			char c = chs[i];
			if (map.get(c) == 1) {
				return i;
			}
		}
		
		return -1;
	}

	public int firstUniqChar_02(String s) {
		
		if (s == null || s.length() == 0)
			return -1;
		
		char[] chs = s.toCharArray();
		
		int[] a = new int[26];
		
		//优化hash计算及查找
		for (char c : chs) {
			a[c - 'a'] +=1;
		}
		
		for (int i = 0; i < chs.length; i++) {
			char c = chs[i];
			if (a[c - 'a'] == 1) {
				return i;
			}
		}
		
		return -1;
	}
}
