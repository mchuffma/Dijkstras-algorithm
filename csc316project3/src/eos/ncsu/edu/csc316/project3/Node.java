package eos.ncsu.edu.csc316.project3;


/**
 * Node class used in creation of the graph.
 * @author Michael Huffman
 *
 */
public class Node {
	
	Node left;
	Node right;
	String data;
	int count;
	Edge c;
/**
 * Constructor of a node using just a string.
 * @param d
 */
public Node() {
	
	this.left = null;
	this.right = null;
	this.c = null;
	
}
/**
 * Alternate constructor for a node, using both a string and a known count.
 * @param d
 * @param count
 */
public Node(int count) {
	
	this.left = null;
	this.right = null;
	this.count = count;
	this.c = null;
}
/**
 * Returns the left node of the current node.
 * @return left node.
 */
public Node getleft() {	
	return left;
}
/**
 * Returns the right node of the current node.
 * @return right node.
 */
public Node getright() {
	return right;
}
/**
 * Returns the count of the node.
 * @return count of node.
 */
public Edge getEdge() {
	return c;
}


}