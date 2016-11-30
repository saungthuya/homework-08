import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HuffmanTree {
	private Node root;
	private Map<Short, Integer> cur; //?
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
		
		temp.print();
		
	}
	
	public void buildTree() {
		
	}
	
	void encode(BitInputStream in, BitOutputStream out) {
		
	}
	
	void decode(BitInputStream in, BitOutputStream out) {
		
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
