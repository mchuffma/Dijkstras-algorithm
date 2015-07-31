package eos.ncsu.edu.csc316.project3;


/**
 * Priority queue used in shortest path apgorithm.
 * @author Michael Huffman
 *
 */
public class Vpriorityqueue {

	/**
	 * Node used in queue.
	 * @author Michael
	 *
	 */
	public class VNode {
		Vertice one;
		VNode left;
		VNode right;
		int key;
		public VNode(Vertice one, int key) {
			this.one = one;
			this.left = null;
			this.right = null;
			this.key = key;
		}
	}

	VNode front;
	VNode tail;
	/**
	 * Constructor.
	 */
	public Vpriorityqueue() {
		this.front = null;
		this.tail = null;
	}
	/**
	 * Puts a vertice in the list based on given key.
	 * @param ne - vertice to be inserted.
	 * @param key - key used to sort.
	 */
	public void put(Vertice ne, int key) {
		if(front == null) {
			VNode we = new VNode(ne, key);
			front = we;
			tail = front;
		} else if(front.key < key) {
			VNode we = new VNode(ne, key);
			front.left = we;
			front.left.right = front;
			front = we;
		} else {
			VNode current = front;
			VNode here = null;
			VNode prev = null;
			if(front.right != null) {
				prev = front.right;
			}
			while(current != null) {
				if(current.key < key) {
					here = current;
					if(current.right != null) {
						prev = current.right;
					}
					break;
				}
				
				current = current.right;
			}
			if(here == null) {
				tail.right = new VNode(ne, key);
				tail.right.left = tail;
				tail = tail.right;
				
			} else {
				VNode here2 = here.left;
				here2.right = new VNode(ne, key);
				here.left = here2.right;
				VNode move = here2.right;
				
				move.right = here;
				move.left = here2;
			}
		}
	}
	int currentv = 0;
	/**
	 * Removes the smallest node from the queue.
	 * @return smallest node.
	 */
	public Vertice remove() {
		if(front.right != null) {
		     VNode prev = tail.left;
		     VNode ret = tail;
		     prev.right = null;
		     ret.left = null;
		     tail = prev;
		     currentv = ret.key;
		     return ret.one;
			} else {
				VNode ret = front;
				front = null;
				tail = null;
				currentv = ret.key;
				return ret.one;
			}
	}
	/**
	 * @return boolean value of if the queue is empty.
	 */
	public boolean isEmpty() {
		return front == null;
	}
	/**
	 * Find a vertice in the list and returns its key.
	 * @param v - vertice to find
	 * @return key found.
	 */
	public int find(Vertice v) {
		VNode current = front;
		while(current != null) {
			if(current.one.name.equals(v.name)) {
				return current.key;
			}
			current = current.right;
		}
		return 0;
	}
	/**
	 * Sets a vnode's key.
	 * @param v - vertice in vnode.
	 * @param q - new key.
	 */
	public void set(Vertice v, int q) {
		VNode current = front;
		while(current != null) {
			if(current.one.name.equals(v.name)) {
				current.key = q;
				return;
			}
			current = current.right;
		}
		
	}
	/**
	 * Remove a specific vertice from the list.
	 * @param v - vertice to be removed
	 * @return weight of the node.
	 */
	public int remove(Vertice v) {
		VNode check = front;
		while(check != null) {
			if(check.one.name.equals(v.name)) {
				if(check.left == null) {
					front = check.right;
					front.left = null;
					check.right = null;
					return check.key;
				} else if(check.right == null) {
					tail = check.left;
					tail.right = null;
					return check.key;
				} else {
					check.left.right = check.right;
					check.right.left = check.left;
					check.right = null;
					check.left = null;
					return check.key;
				}
			}
			check = check.right;
		}
		return -1;
	}
}
