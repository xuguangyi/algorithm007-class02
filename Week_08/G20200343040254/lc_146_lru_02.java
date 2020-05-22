package week08;

import java.util.HashMap;

class lc_146_lru {
	class Node {
		int key;
		int value;
		Node prev;
		Node next;
	}

	private HashMap<Integer, Node> cache = null;

	private int size;

	private int capacity;

	private Node head = null;

	private Node tail = null;

	public lc_146_lru(int capacity) {

		this.capacity = capacity;
		this.cache = new HashMap<>(capacity);

		this.size = 0;
		this.head = new Node();
		this.tail = new Node();

		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	private void add(Node n) {
		n.prev = this.head;
		n.next = head.next;

		this.head.next.prev = n;
		this.head.next = n;
	}

	private void remove(Node n) {
		Node prev = n.prev;
		Node next = n.next;

		prev.next = next;
		next.prev = prev;
	}

	private void moveToHead(Node n) {
		remove(n);
		add(n);
	}

	private Node popTail() {
		Node p = this.tail.prev;
		remove(p);
		return p;
	}

	public int get(int key) {
		Node n = this.cache.get(key);
		if (n == null) {
			return -1;
		}

		moveToHead(n);
		return n.value;
	}

	public void put(int key, int value) {
		Node n = this.cache.get(key);
		if (n == null) {
			Node nn = new Node();
			nn.key = key;
			nn.value = value;
			this.cache.put(key, nn);
			add(nn);
			this.size++;

			if (this.size > this.capacity) {
				Node tail = popTail();
				this.cache.remove(tail.key);
				this.size--;
			}
		} else {
			n.value = value;
			moveToHead(n);
		}
	}

	public static void main(String[] args) {
		lc_146_lru lru = new lc_146_lru(100);
		lru.put(0, 0);
		System.out.println("---\t" + lru.get(0));
	}
}
