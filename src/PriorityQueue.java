import java.util.LinkedList;
import java.util.List;

public class PriorityQueue {
	//	
	//	List<Patient>[] patients = 
	//	public class Patient {
	//		public int prio;
	//		public String name;
	//		public Patient(int prio, String name) {
	//			this.prio = prio;
	//			this.name = name;
	//		}
	//	}

	// invariant data is sorted
	protected List<Node> queue;

	public PriorityQueue() {
		queue = new LinkedList<>();
	}

	// @citation mattori helped the shit out of us. 
	public void enqueue(Node n) {
		for (int i = 0; i < queue.size(); i++) {
			if (n.freq < queue.get(i).freq) {
				queue.add(i, n);
				return;
			}
		}
		queue.add(n);
	}

	public Node dequeue() {
		return queue.remove(0);
	}

	public Node makeInternalNode() {
		int summary = queue.get(0).freq + queue.get(1).freq;
		return new Node(summary, this.dequeue(), this.dequeue());
	}
	
	public int size() {
		return queue.size();
	}

	public void print() {
		for (Node cur : queue) {
			System.out.println(((char) cur.ch) + " : " + cur.freq);
		}
	}
}
