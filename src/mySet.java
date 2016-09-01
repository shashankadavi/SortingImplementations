import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class mySet {
	ArrayList<Edge> edgeSet = new ArrayList<Edge>(); // List of all edges
	Set<Integer> s;// Set of vertices

	/**
	 * default constructor
	 */

	mySet() {
		s = new HashSet<Integer>();
	}

	/**
	 * this method adds an edge to the list and the vertex to the set
	 */

	public void add(Edge e) {

		s.add(e.from);
		s.add(e.to);

		edgeSet.add(e);

	}

	/**
	 * this method adds all edges to the list
	 */

	public void addAll(mySet m) {
		this.edgeSet.addAll(m.edgeSet);
		this.s.addAll(m.s);

	}

	/**
	 * this method checks if both vertices of an edge is already there in the
	 * set
	 */
	public int check(Edge e) {
		int count = 0;
		if (s.contains(e.from)) {
			count++;

		}
		if (s.contains(e.to)) {
			count++;

		}
		return count;
	}

	/**
	 * this method converts the members to string and returns
	 */
	public String toString() {
		return edgeSet.toString();
	}

}
