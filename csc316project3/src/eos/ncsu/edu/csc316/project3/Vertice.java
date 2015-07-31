package eos.ncsu.edu.csc316.project3;
/**
 * Vertice object used in the creation of a map.
 * @author Michael Huffman
 *
 */
public class Vertice {

	Vertice left;
	Vertice right;
	String name;
	Node connect;
	int connected;
	boolean visited;
	Vertice superprev;
	/**
	 * Creates a vertice.
	 * @param name - name of the new vertice.
	 */
	public Vertice(String name) {
		
		this.left = null;
		this.right = null;
		this.name = name;
		this.connect = null;
		this.visited = false;
		this.connected = 0;
		this.superprev = null;
	}
	/**
	 * add a connection to the vertice.
	 * @return newly created node.
	 */
	public Node addconnect() {
		if(connected == 6) {
			return null;
		}
		if(connect == null) {
			connect = new Node(1);
			connected++;
			return connect;
		} else {
		Node current = connect;
		while(current.right != null) {
			current = current.right;
		}
		connected++;
		current.right = new Node(connected);
		current.right.left = current;
		return current.right;
		}
	}
	
	/**
	 * A method that sees if the vertice is connected to another vertice
	 * @param test - vetrice tested.
	 * @return bool value if it was connected.
	 */
	public boolean isConnected(Vertice test) {
		Node current = connect;
	    while(current != null) {
		if(current.c.vconnect1.name.equals(test.name) || current.c.vconnect2.name.equals(test.name)) {
			return true;
		}
		current = current.right;
	    }
	    return false;
	}
	
}
