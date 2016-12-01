import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HuffmanTree {
	private Node root;
	private File f = new File("example.txt");

	/** Constructs a new Huffman Tree using a given Map
	 * @param m
	 * @citation stackoverflow.com/questions/1066589/iterate-through-a-hashmap
	 */

	public HuffmanTree(Map<Short, Integer> m) {
		PriorityQueue temp = new PriorityQueue();
		for (Short key : m.keySet()) {
			temp.enqueue(new Node(key, m.get(key)));
		}
		temp.enqueue(new Node((short) 256, 1));

		buildTree(temp);
		root = temp.dequeue();
		//root.printTree();
	}

	public void buildTree(PriorityQueue queue) {
		while (queue.size() >= 2) {
			Node condensed = queue.makeInternalNode();
			//System.out.println(condensed.freq);
			queue.enqueue(condensed);
			//queue.print();
			//System.out.println("!!!!!");
		}
	}


	public void encode(BitInputStream in, BitOutputStream out) {
		Map<Short, Integer> characterCounts = new HashMap<Short, Integer>();
		BitInputStream inCopy = in;
		while(inCopy.hasBits()) {
			short ch = (short) in.readBits(8);
			if(characterCounts.containsKey(ch)) {
				characterCounts.put(ch, characterCounts.get(ch) + 1);
			} else {
				characterCounts.put(ch, 1);
			}
		}
		HuffmanTree tree = new HuffmanTree(characterCounts);

	}
	public void decode(BitInputStream in, BitOutputStream out) {

	}

	public Map<Short, String> huffmanMap() {
		Map<Short, String> ret = new HashMap<>();
		String code = "";
		huffmanMapHelper(root, code, ret);
		for (Short key : ret.keySet()) {
			System.out.printf(ret.keySet().toString());
		}
		return ret;
	}

	public void huffmanMapHelper(Node cur, String code, Map<Short, String> m) {
		if (cur == null) {
			return;
		}
		if (cur.ch != null) {
			m.put(cur.ch, code);
		} else {
			String leftCode = code + "0";
			String rightCode = code + "1";
			if (cur.left != null) {
				huffmanMapHelper(cur.left, leftCode, m);
			} else if (cur.right != null) {
				huffmanMapHelper(cur.right, rightCode, m);
			}
		}
	}

	public static void main(String[] args) {
		Map<Short, Integer> m = new HashMap<Short, Integer>();
		m.put((short)'a', 3);
		m.put((short) ' ', 2);
		m.put((short) 'z', 1);
		m.put((short) 'b', 2);

		HuffmanTree h = new HuffmanTree(m);
		h.huffmanMap();
	}

}
