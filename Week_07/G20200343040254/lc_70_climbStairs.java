package week07;

public class lc_70_climbStairs {
	
	public int climbStairs(int n) {
		if (n <= 1)
			return n;

		int[] a = new int[n];
		a[0] = 1;
		a[1] = 2;

		for (int i = 2; i < n; i++) {
			a[i] = a[i - 1] + a[i - 2];
		}

		return a[n - 1];
	}
}
