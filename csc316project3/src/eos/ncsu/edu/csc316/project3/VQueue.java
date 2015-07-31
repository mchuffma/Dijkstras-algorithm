package eos.ncsu.edu.csc316.project3;
/**
 * Regular queue class used in inplementation of the breadth first.
 * @author Michael Huffman
 *
 */
public class VQueue {
	/**
	 * Node used in queue.
	 * @author Michael
	 *
	 */
	public class VNode {
		Vertice one;
		VNode left;
		VNode right;
		/**
		 * Constructor.
		 * @param one - vertice to be inserted.
		 */
		public VNode(Vertice one) {
			this.one = one;
			this.left = null;
			this.right = null;
		}
	}

	VNode front;
	VNode tail;
	/**
	 * Constructor.
	 */
	public VQueue() {
		VNode front = null;
		VNode tail = null;
	}
	/**
	 * puts a vertice in the queue.
	 * @param ne - vertice put into queue.
	 */
	public void put(Vertice ne) {
		VNode n = new VNode(ne);
		if(front == null) {
			
			front = n;
			tail = front;
		} else {
			n.right = front;
			front.left = n;
			front = n;
		}
	}
	/**
	 * removes back of queue.
	 * @return node in back.
	 */
	public Vertice remove() {
		if(front.right != null) {
	     VNode prev = tail.left;
	     VNode ret = tail;
	     prev.right = null;
	     ret.left = null;
	     tail = prev;
	     return ret.one;
		} else {
			VNode ret = front;
			front = null;
			tail = null;
			return ret.one;
		}
	}
	/**
	 * @return boolean value of emptyness of the queue.
	 */
	public boolean isEmpty() {
		if(front == null) {
			return true;
		} else {
			return false;
		}
	}
}
