public class Main {

	public static void main(String[] args) {
		/*
		 * Inorder traverse String vs. StringBuilder
		 */
		{
			final int NUM = 10000;
			final int T6 = 1_000_000;

			Integer[] arr1 = new Integer[NUM];
			for (int i = 0; i < NUM; ++i) {
				arr1[i] = i;
			}
			TreeNode tree1 = TreeNode.arrayToTree(arr1);

			// In-order printout
			tree1.printInOrder();
			System.out.println();

			// Concatenate with String
			long ts1 = System.nanoTime();
			String s = "Str: ";
			s = tree1.inOrder(s); // slow
			long te1 = System.nanoTime();

			// Concatenate with StringBuilder
			StringBuilder sb = new StringBuilder("Sb:  ");
			long ts2 = System.nanoTime();
			tree1.inOrder(sb); // fast
			long te2 = System.nanoTime();

			// System.out.println(s);
			System.out.println("Inorder traversal of " + NUM + " units, String costs " + (te1 - ts1) / T6 + " ms");
			// System.out.println(sb.toString());
			System.out
					.println("Inorder traversal of " + NUM + " units, StringBuilder costs " + (te2 - ts2) / T6 + " ms");
		}

		// ====================================================
		/*
		 * BFS & DFS
		 */
		{
			System.out.println("===== Tree1 =====");
			TreeNode tree1 = TreeNode.arrayToTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 });
			System.out.println("** DFS(pre-order):");
			tree1.printPreOrder();
			System.out.println();

			System.out.println("** DFS(in-order):");
			tree1.printInOrder();
			System.out.println();

			System.out.println("** DFS(post-order):");
			tree1.printPostOrder();
			System.out.println();

			System.out.println("** BFS:");
			tree1.printBFS();
			System.out.println();

			System.out.println("===== Tree2 =====");
			TreeNode tree2 = TreeNode
					.arrayToTree(new Integer[] { 1, null, 2, null, null, 3, 4, null, null, null, null, 5, null, 6, 7 });
			System.out.println("** DFS(pre-order):");
			tree2.printPreOrder();
			System.out.println();

			System.out.println("** DFS(in-order):");
			tree2.printInOrder();
			System.out.println();

			System.out.println("** DFS(post-order):");
			tree2.printPostOrder();
			System.out.println();

			System.out.println("** BFS:");
			tree2.printBFS();
			System.out.println();
		}
	}

}
