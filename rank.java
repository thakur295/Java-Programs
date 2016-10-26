class BST {

	private Node root;

	private class Node {
		private final int key;
		private Node right;
		private Node left;
		private int N;

		public Node(int key) {
			this.key = key;
			N = 1;
		}
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return sizeOf(root);
	}

	private int sizeOf(Node x) {
		return x == null ? 0 : x.N;
	}

	public void insert(int key) {
		root = insert(root, key);
	}

	private Node insert(Node x, int key) {
		if (x == null) return new Node(key);
		if (key < x.key) x.left = insert(x.left, key);
		else if (key > x.key) x.right = insert(x.right, key);
		//else update value
		x.N = 1 + sizeOf(x.left) + sizeOf(x.right);
		return x;
	}

	public boolean search(int key) {
		Node x = search(root, key);
		return x != null;
	}

	private Node search(Node x, int key) {
		if (x == null) return null;
		if (key == x.key) return x;
		if (key < x.key) return search(x.left, key);
		return search(x.right, key);
	}

	public int getMin() {
		return getMin(root).key;
	}

	private Node getMin(Node x) {
		if (x.left == null)	return x;
		return getMin(x.left);
	}

	public int getMax() {
		return getMax(root).key;
	}

	private Node getMax(Node x) {
		if (x.right == null) return x;
		return getMax(x.right);
	}

	public void delMin() {
		if (root == null) return;
		root = delMin(root);
	}

	private Node delMin(Node x) {
		if (x.left == null)	return x.right;
		x.left = delMin(x.left);
		x.N = 1 + sizeOf(x.left) + sizeOf(x.right);
		return x;
	}

	public void delMax() {
		if (root == null) return;
		root = delMax(root);
	}

	private Node delMax(Node x) {
		if (x.right == null) return x.left;
		x.right = delMax(x.right);
		x.N = 1 + sizeOf(x.left) + sizeOf(x.right);
		return x;
	}

	public void del(int key) {
		root = del(root, key);
	}

	private Node del(Node x, int key) {
		if (x == null)	return null;
		if (key == x.key) {
			if (x.left == null)	return x.right;
			if (x.right == null) return x.left;
			Node t = x;
			x = getMax(t.left);
			x.left = delMax(t.left);
			x.right = t.right;
			x.N = 1 + sizeOf(x.left) + sizeOf(x.right);
			return x;
		} else if (key < x.key)	return del(x.left, key);
		return del(x.right, key);
	}

	public int getRank(int key) {
		if (search(key)) getRank(root, key);
		return -1;
	}

	private int getRank(Node x, int key) {
		if (key == x.key) return sizeOf(x.left);
		else if (key < x.key) return getRank(x.left, key);
		else return 1 + sizeOf(x.left) + getRank(x.right, key);
	}

	public int getFirstCommonAncestor(int k1, int k2) {
		Node ancestor = getFirstCommonAncestor(root, k1, k2, null);
		return ancestor == null ? null : ancestor.key;
	}

	private Node getFirstCommonAncestor(Node node, int k1, int k2, Node parent) {
		if (k1 > node.key && k2 > node.key) return getFirstCommonAncestor(node.right, k1, k2, node);
		if (k1 < node.key && k2 < node.key) return getFirstCommonAncestor(node.left, k1, k2, node);
		if (k1 == node.key && k2 == node.key) return parent;
		return node;
	}

	public void inOrder() {
		inOrder(root);
		System.out.println("");
	}

	private void inOrder(Node x) {
		if (x == null) return;
		inOrder(x.left);
		System.out.print(x.key + " ");
		inOrder(x.right);
	}

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(5);
		bst.insert(2);
		bst.insert(3);
		bst.insert(9);
		bst.insert(8);
		bst.inOrder();
		bst.del(5);
		bst.inOrder();
	}
}

 