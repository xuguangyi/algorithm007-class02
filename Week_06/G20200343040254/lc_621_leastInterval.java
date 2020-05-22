package week06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class lc_621_leastInterval {
	public static int leastInterval_01(char[] tasks, int n) {

		int[] tts = new int[26];

		for (char c : tasks) {
			tts[c - 'A']++;
		}

		Arrays.parallelSort(tts);

		int time = 0;

		while (tts[25] > 0) {

			int i = 0;
			while (i <= n) {
				if (tts[25] == 0) {
					break;
				}

				if (i < 26 && tts[25 - i] > 0) {
					tts[25 - i]--;
				}
				time++;
				i++;
			}
			Arrays.parallelSort(tts);
		}
		return time;
	}

	public static int leastInterval_02(char[] tasks, int n) {

		int[] tts = new int[26];
		for (char c : tasks) {
			tts[c - 'A']++;
		}

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(26, Collections.reverseOrder());

		for (int i : tts) {
			if (i > 0)
				heap.add(i);
		}

		int time = 0;
		while (!heap.isEmpty()) {
			int i = 0;
			List<Integer> l = new ArrayList<Integer>();
			while (i <= n) {
				if (!heap.isEmpty()) {
					if (heap.peek() > 1) {
						l.add(heap.poll() - 1);
					} else {
						heap.poll();
					}
				}

				time++;

				if (heap.isEmpty() && l.size() == 0) {
					break;
				}
				i++;
			}

			for (Integer t : l) {
				heap.add(t);
			}
		}
		return time;
	}

	public static int leastInterval_03(char[] tasks, int n) {
		int[] tts = new int[26];
		for (char c : tasks) {
			tts[c - 'A']++;
		}

		Arrays.parallelSort(tts);

		int max = tts[25] - 1, idle_slots = max * n;

		for (int i = 24; i > 0 && tts[i] > 0; i--) {
			idle_slots -= Math.min(tts[i], max);
		}
		return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
	}

	public static void main(String[] args) {
		char[] chs = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
		int i = leastInterval_03(chs, 2);
		System.out.println(i);
	}
}
