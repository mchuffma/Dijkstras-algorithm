package eos.ncsu.edu.csc316.project3;
/**
 * Edge object used for the map.
 * @author Michael Huffman
 *
 */
public class Edge {

	Edge left;
	Edge right;
    int edgenum;
	Vertice vconnect1;
	Vertice vconnect2;
	Node nconnect1;
	Node nconnect2;
	int place;
	int prev;
	boolean explored;
	/**
	 * constructor i did not use for edge object.
	 * @param place
	 * @param vconnect1
	 * @param vconnect2
	 * @param nconnect1
	 * @param nconnect2
	 * @param left
	 * @param right
	 */
	public Edge(int place, Vertice vconnect1, Vertice vconnect2, Node nconnect1, Node nconnect2, Edge left, Edge right) {
		this.place = place;
		this.vconnect1 = vconnect1;
		this.vconnect2 = vconnect2;
		this.nconnect1 = nconnect1;
		this.nconnect2 = nconnect2;
		this.left = left;
		this.right = right;
	}
	
	
	/**
	 * Constructor for edge class.
	 * @param vconnect1 - first vertice.
	 * @param vconnect2 - the second vertice.
	 * @param place - weight of the edge.
	 * @param edgenum - represents the total edges created by the map.
	 */
	public Edge(Vertice vconnect1, Vertice vconnect2, int place, int edgenum) {
		this.edgenum = edgenum;
		this.place = place;
		this.vconnect1 = vconnect1;
		this.vconnect2 = vconnect2;
		this.nconnect1 = null;
		this.nconnect2 = null;
		this.left = null;
		this.right = null;
		this.explored = false;
	}
}
