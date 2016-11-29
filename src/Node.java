
public class Node implements Comparable<Object> {
	private Short ch;
	private int freq;
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
		this.ch = null;
		this.freq = freq;
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Node) {
			Node other = (Node) o;
			if (other.freq > freq) {
				return other.freq - freq;
			} else if (other.freq < freq) {
				return freq - other.freq;
			} else {
				return 0;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
}
