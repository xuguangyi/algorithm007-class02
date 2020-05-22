package week07;

public class lc_547_findCircleNum {

	class FriendCircle {

		/**
		 * 总共的集合数量
		 */
		private int c;

		private final int[] parent;

		private final int[] rank;

		FriendCircle(final int n) {
			this.c = n;
			this.parent = new int[n];
			this.rank = new int[n];
			
			//创建并查集
			for (int i = 0; i < n; i++) {
				//自己是自己的老大
				this.parent[i] = i;
			}
		}

		public int find(int i) {
			while (i != this.parent[i]) {
				// 路径压缩
				this.parent[i] = this.parent[this.parent[i]];
				// 层层向上寻找老大
				i = this.parent[i];
			}
			return i;
		}

		/**
		 * 合并x、y的两个集合
		 * 
		 * @param x
		 * @param y
		 */
		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			if (rootX == rootY)
				return;

			// 在老大中，在选取一个老大
			if (this.rank[rootX] > this.rank[rootY]) {
				this.parent[rootY] = rootX;
			} else {
				this.parent[rootX] = rootY;
				if (this.rank[rootX] == this.rank[rootY]) {
					this.parent[rootX]++;
				}
			}

			// 合并后，总的集合数量减少一个
			this.c--;
		}

		public int getCount() {
			return this.c;
		}
	}

	public int findCircleNum(int[][] M) {
		int n = M.length;
		FriendCircle fc = new FriendCircle(n);

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (M[i][j] == 1) {
					fc.union(i, j);
				}
			}
		}
		return fc.getCount();
	}
}
