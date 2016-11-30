
public class Node implements Comparable<Node> {
	protected short ch;
	protected int freq;
	private Node left;
	private Node right;

	/** Used to construct leaf nodes
	 */
	public Node(Short ch, int freq) {
		this.ch = ch;
		this.freq = freq;
		left = null;
		right = null;
	}

	/** Additional constructor takes left and right node arguments
	 * Used for interior nodes
	 *
	 */
	public Node(int freq, Node left, Node right) {
		this.ch = (short) 0;
		this.freq = freq;
		this.left = left;
		this.right = right;
	}
	
	public Node(Short ch, int freq, Node left, Node right) {
		this.ch = ch;
		this.freq = freq;
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(Node other) {
		return freq - other.freq;
	}
	
	public void printTree() {
		if (this.left != null) {
			this.left.printTree();
		}
		System.out.println((char) ch + " : " + freq);
		
		if (this.right!= null) {
			this.right.printTree();
		}
	}
}
