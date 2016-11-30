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
	protected List<Node> data;

	public PriorityQueue() {
		data = new LinkedList<>();
	}

	// @citation mattori helped the shit out of us. 
	public void enqueue(Node n) {
		for (int i = 0; i < data.size(); i++) {
			if (n.freq < data.get(i).freq) {
				data.add(i, n);
				return;
			}
		}
		data.add(n);
	}

	public Node dequeue() {
		return data.remove(0);
	}

	public void print() {
		for (Node cur : data) {
			System.out.println(((char) cur.ch) + " : " + cur.freq);
		}
	}
}
