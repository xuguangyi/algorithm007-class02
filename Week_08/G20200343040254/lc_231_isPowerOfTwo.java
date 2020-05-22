package week08;

public class lc_231_isPowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		return (n > 0) && (n & (n - 1)) == 0;
	}
}
