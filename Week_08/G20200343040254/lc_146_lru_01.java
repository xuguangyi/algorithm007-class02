package week08;

import java.util.LinkedHashMap;
import java.util.Map;

class lc_146_lru_01 extends LinkedHashMap<Integer, Integer> {

	private static final long serialVersionUID = -203917373985411874L;

	private int capacity;

	public lc_146_lru_01(int capacity) {
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}

	public int get(int key) {
		return super.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		super.put(key, value);
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}
}
