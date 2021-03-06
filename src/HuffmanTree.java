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
		while(in.hasBits()) {
			short ch = (short) in.readBits(8);
			if(characterCounts.containsKey(ch)) {
				characterCounts.put(ch, characterCounts.get(ch) + 1);
			} else {
				characterCounts.put(ch, 1);
			}
		}
		HuffmanTree tree = new HuffmanTree(characterCounts);
		Map<Short, String> huffTable = tree.HuffmanMap();
		for (Short key : huffTable.keySet()) {
			String huffmanCode = huffTable.get(key);
			for (int i = 0; i < huffmanCode.length(); i++) {
				out.writeBit(Integer.parseInt(huffmanCode));
				// below is ugly code that might work
				out.writeBit(Integer.parseInt(Character.toString(huffmanCode.charAt(i))));
				System.out.println(Integer.parseInt(Character.toString(huffmanCode.charAt(i))));
			}
		}
	}
	
	public void decode(BitInputStream in, BitOutputStream out) {
		Short c = 0;
		while (in.hasBits()) {
			c = decodeHelper(in, root);
			out.writeBits(c, 8);
			
		} 
	}
	
	public Short decodeHelper(BitInputStream in, Node n) {
		if (n.isLeaf()) {
			return n.ch;
		} else {
			int bit = in.readBit();
			if (bit == 0) {
				return decodeHelper(in, n.left);
			} else {
				return decodeHelper(in, n.right);
			}
		}
	}

//	public Map<Short, String> huffmanMap() {
//		Map<Short, String> ret = new HashMap<>();
//		String code = "";
//		huffmanMapHelper(root, code, ret);
//		for (Short key : ret.keySet()) {
//			System.out.printf(ret.keySet().toString());
//		}
//		return ret;
//	}
//
//	public void huffmanMapHelper(Node cur, String code, Map<Short, String> m) {
//		if (cur == null) {
//			return;
//		}
//		if (cur.ch != null) {
//			m.put(cur.ch, code);
//		} else {
//			String leftCode = code + "0";
//			String rightCode = code + "1";
//			if (cur.left != null) {
//				huffmanMapHelper(cur.left, leftCode, m);
//			} else if (cur.right != null) {
//				huffmanMapHelper(cur.right, rightCode, m);
//			}
//		}
//	}
	
	public Map<Short, String> HuffmanMap() {
		Map<Short, String> m = new HashMap<Short, String>();
		String code = "";
		HuffmanMapH(this.root, code, m);
		return m;
	}
	
	public void HuffmanMapH(Node n, String str, Map<Short, String> m) {
		if (n.isLeaf()) {
			m.put((Short) n.ch, str);
		} else {
			if (n.left != null) {
				str = str + "0";
				HuffmanMapH(n.left, str, m);
				str = str.substring(0, str.length() - 1);
			} else if (n.right != null) {
				str = str + "1";
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
		
	}

}
