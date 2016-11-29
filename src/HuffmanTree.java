import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class HuffmanTree {
	private Node root;
	private Map<Short, Integer> cur; //?
	private File f = new File("example.txt");
	
	/** Constructs a new Huffman Tree using a given Map
	 * @param m
	 * @citation stackoverflow.com/questions/1066589/iterate-through-a-hashmap
	 */
	public HuffmanTree(Map<Short, Integer> m) {
		cur = m;
		PriorityQueue<Node> temp = null;
		Iterator<Entry<Short, Integer>> iter = m.entrySet().iterator();
		Node n;
		// 1. Iterate through map.
		while (iter.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<Short, Integer> pair = 
					(Map.Entry<Short, Integer>) iter.next();

			n = new Node(pair.getKey(), pair.getValue());
			
		}
		
		// 2. Take each item from map and create a node.
		// 3. Insert the node into the priority queue
		
	}
	
	void encode(BitInputStream in, BitOutputStream out) {
		
	}
	
	void decode(BitInputStream in, BitOutputStream out) {
		
	}

}
