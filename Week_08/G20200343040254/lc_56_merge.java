package week08;

import java.util.Arrays;
import java.util.Comparator;

public class lc_56_merge {
	public int[][] merge(int[][] intervals) {

		if (intervals == null || intervals.length <= 1)
			return intervals;

		// sort by ascending staring index
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		Arrays.parallelSort(intervals,(o1,o2) -> o1[0] - o2[0]);

		int[][] ans = new int[intervals.length][2];
		int i = -1;
		for (int[] s : intervals) {
			if (i == -1 || s[0] > ans[i][1]) {
				ans[++i] = s;
			} else {
				ans[i][1] = Math.max(ans[i][1], s[1]);
			}
		}

		return Arrays.copyOf(ans, i + 1);
	}
}
