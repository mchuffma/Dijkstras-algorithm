package eos.ncsu.edu.csc316.project3;

/**
 * My adjacency representation of this graph.
 * 
 * @author Michael Huffman
 * 
 */
public class AJGraph {

	Vertice vFront = null;
	Edge eFront = null;
	Vertice vTail = null;
	Edge eTail = null;
	int edgenumber;

	public AJGraph() {
		this.vFront = null;
		this.eFront = null;
		this.vTail = null;
		this.eTail = null;
		this.edgenumber = 0;
	}

	/**
	 * Method to insert a vertex.
	 * 
	 * @param name
	 *            - name of vertice
	 */
	public void insertVertex(String name) {
		if (vFront == null) {
			vFront = new Vertice(name);
			vTail = vFront;
		} else {
			vTail.right = new Vertice(name);
			vTail.right.left = vTail;
			vTail = vTail.right;
			if (vTail.name.equals(vTail.left.name)) {
				vTail.name += "2";
				vTail.left.name += "1";
			}
		}
	}

	/**
	 * 
	 * @param o
	 *            - first vertice
	 * @param t
	 *            - second vertice
	 * @param dis
	 *            - weight
	 * @return
	 */
	public boolean insertEdge2(String o, String t, int dis) {
		Vertice current = vFront;
		while (!current.name.equals(o)) {
			current = current.right;
		}
		Vertice one = current;
		current = vFront;
		while (!current.name.equals(t)) {
			current = current.right;
		}
		Vertice two = current;
		if (two.isConnected(one)) {
			Node e2 = one.addconnect();
			if (e2 == null) {
				return false;
			}
			Node current2 = two.connect;
			Node qw = null;
			while (current2 != null) {
				if (current2.c.vconnect2.name.equals(one.name)) {
					qw = current2;
					break;
				}
				current2 = current2.right;
			}
			qw.c.nconnect2 = e2;
			e2.c = qw.c;
			return true;
		} else {
			Node e1 = one.addconnect();
			if (e1 == null) {
				return false;
			}
			Edge n = new Edge(one, two, dis, edgenumber);
			edgenumber++;
			e1.c = n;
			n.nconnect1 = e1;
			if (eFront == null) {
				eFront = n;
				eTail = n;
			} else {
				eTail.right = n;
				eTail.right.left = n;
				eTail = eTail.right;

			}

			return true;
		}
	}

	/**
	 * A method that changes the wieght of an edge.
	 * 
	 * @param o
	 *            - first vertice
	 * @param t
	 *            - the second
	 * @param dis
	 *            - new weight
	 */
	public void changeWeight(String o, String t, int dis) {
		Vertice current = vFront;
		while (!current.name.equals(o)) {
			current = current.right;
		}
		Vertice one = current;
		current = vFront;
		while (!current.name.equals(t)) {
			current = current.right;
		}
		Vertice two = current;
		Node current2 = two.connect;
		Node qw = null;
		while (current2 != null) {
			if (current2.c.vconnect2.name.equals(one.name) || current2.c.vconnect2.name.equals(two.name)) {
				qw = current2;
				break;
			}
			current2 = current2.right;
		}
		Edge change = qw.c;
		if (change.prev == 0) {
			change.prev = change.place;
			change.place = dis;
		} else {
			change.place = dis;
		}

	}

	int q = 0;
	int f = 0;

	/**
	 * Helper method for depth first.
	 * 
	 * @param check
	 *            - vertice
	 */
	public void DFSh(String check) {
		Vertice current = vFront;
		while (!current.name.equals(check)) {
			current = current.right;
		}
		Vertice one = current;
		DFS(one);
		
	}

	public void DFS(Vertice check) {
		check.visited = true;
		System.out.println(check.name);
		
		q++;
		Node current = check.connect;
		while (current != null) {

			if (current.c.explored == false && current.c.place != 0) {
				f++;
				Vertice newcheck = adjacent(check, current.c);
				if (newcheck.visited == false) {
					current.c.explored = true;
					DFS(newcheck);
				} else {
					// return;
					current.c.explored = true;
				}
			}
			current = current.right;
		}

	}

	/**
	 * Returns the opposite vertice connect to given edge.
	 * 
	 * @param one
	 *            - first vertivce checked
	 * @param s
	 *            - the edge needed.
	 * @return vertice connected to the other end of the edge.
	 */
	public Vertice adjacent(Vertice one, Edge s) {
		if (s.vconnect1.name.equals(one.name)) {
			return s.vconnect2;
		} else {
			return s.vconnect1;
		}
	}

	/**
	 * Resets edges and vertices after a traversal.
	 */
	public void reset() {
		q = 0;
		f = 0;
		Vertice c1 = vFront;
		while (c1 != null) {
			c1.visited = false;
			c1 = c1.right;
		}
		Edge c2 = eFront;
		while (c2 != null) {
			c2.explored = false;
			c2 = c2.right;
		}
	}

	/**
	 * Helper method for breadth first traversal.
	 * 
	 * @param check
	 *            - vertice to do beadth first on
	 */
	public void BFSh(String check) {
		Vertice current = vFront;
		while (!current.name.equals(check)) {
			current = current.right;
		}
		Vertice one = current;
		BFS(one);
	}
/**
 * Method to do breadth first traversal.
 * @param check - vertice to start at.
 */
	public void BFS(Vertice check) {
		Vertice current = check;
		check.visited = true;
		System.out.println(check.name);
		f++;
		VQueue checker = new VQueue();
		checker.put(current);
		while (!checker.isEmpty()) {
			Node cut = check.connect;
			while (cut != null) {
				Vertice newv = adjacent(check, cut.c);
				if (newv.visited == false || cut.c.place == 0) {
					System.out.println(newv.name);
					f++;
					newv.visited = true;
					checker.put(newv);
				}
				cut = cut.right;
			}
			
			check = checker.remove();
		}
	}
/**
 * Helper method for shortest path. 
 * @param one - first vertice.
 * @param two - second vertice.
 */
	public void dih(String one, String two) {
		Vertice current = vFront;
		Vertice o = null;
		while (current != null) {
			if (current.name.equals(one)) {
				o = current;
			}
			current = current.right;
		}
		current = vFront;
		Vertice t = null;
		while (current != null) {
			if (current.name.equals(two)) {
				t = current;
			}
			current = current.right;
		}

		di(o, t);

	}
/**
 * sortest path algorithm
 * @param start - node to start at
 * @param end - node to find.
 */
	public void di(Vertice start, Vertice end) {
		
		Vertice current = start;
		Vertice newve = start;
		Vertice newv = null;
		Vpriorityqueue dia = new Vpriorityqueue();
		dia.put(start, 0);
		current = vFront;
		while (current != null) {
			if (current.name.equals(start.name)) {
				if (current.right == null) {
					break;
				} else {
					current = current.right;
				}
			}
			dia.put(current, Integer.MAX_VALUE);
			current = current.right;
		}
		while (!dia.isEmpty()) {
			if (newv != null) {
				newv.superprev = newve;
				newve = newv;
			}
			newv = dia.remove();

			if (newv.name.equals(end.name)) {
				System.out.println(dia.currentv);
				Vertice scheck = newve;
				

			}
			if (dia.find(newv) == Integer.MAX_VALUE) {
				break;
			}
			Node newnode = newv.connect;
			while (newnode != null) {
				Vertice v = adjacent(newv, newnode.c);
				int alt = dia.currentv + newnode.c.place;
				if (alt < dia.find(v)) {
					dia.set(v, alt);
					int f = dia.remove(v);
					dia.put(v, f);
				}
				newnode = newnode.right;
			}
		}
		

	}
/**
 * method that calculates the distance between two vertice.
 * @param one - the first vertice.
 * @param two - the second.
 * @return total distance between them.
 */
	public int distance(Vertice one, Vertice two) {
		Node current = one.connect;
		while (current != null) {
			Edge bu = null;
			if (current.c.vconnect1.name.equals(two.name)
					&& current.c.vconnect2.name.equals(one.name)) {
				bu = current.c;
				return bu.place;
			} else if (current.c.vconnect1.name.equals(one.name)
					&& current.c.vconnect2.name.equals(two.name)) {
				bu = current.c;
				return bu.place;
			}
		}
		return 0;
	}

	/**
	 * Resets all weight changes.
	 */
	public void superreset() {
		Edge current = eFront;
		while (current != null) {
			if (current.prev != 0) {
				current.place = current.prev;
				current.prev = 0;
			}
			current = current.right;
		}
	}
}
