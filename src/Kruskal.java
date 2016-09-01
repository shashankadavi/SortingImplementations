import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This class implements the Kruskal's Algorithm for shortest path
 * 
 * @author Shashank
 */

public class Kruskal {
	ArrayList<mySet> sets; // List of all sets of vertices

	/**
	 * constructor to initialize the sets
	 */

	Kruskal() {
		sets = new ArrayList<mySet>();
	}

	/**
	 * this method performs the union of two sets of edges
	 */

	public void union(int a[]) {
		sets.get(a[0]).addAll(sets.get(a[1]));
		sets.remove(a[1]);
		a[1] = -1;

	}

	/**
	 * this method inserts edge into a set
	 */

	public boolean insert(Edge e) {
		int a[] = { -1, -1 };
		boolean in = getIndex(e, a);

		if (!in) {
			return in;
		}

		if (a[0] == -1) {
			mySet newSet = new mySet();
			newSet.add(e);
			sets.add(newSet);
		} else {
			if (a[1] == -1) {
				sets.get(a[0]).add(e);
			} else {
				union(a);
				sets.get(a[0]).add(e);
			}
		}

		return in;
	}

	/**
	 * this method gets the index of an edge in the present sets
	 */

	public boolean getIndex(Edge e, int[] a) {

		for (int i = 0; i < sets.size(); i++) {
			int c = sets.get(i).check(e);
			if (c == 2) {
				return false;
			} else if (c == 1) {
				if (a[0] == -1) {
					a[0] = i;
				} else {
					a[1] = i;
				}
			}

		}

		return true;

	}

	public static void main(String[] args) {
		int noOfVertices = 0;
		int noOfEdges = 0;
		int count = 0;

		boolean insert = true;
		Edge[] edges = new Edge[3];// Array of edges to store all edges

		Scanner sc = null;

		sc = new Scanner(System.in);
		noOfVertices = Integer.parseInt(sc.next());

		noOfEdges = Integer.parseInt(sc.next());

		edges = new Edge[noOfEdges];

		int i = 0;
		while (i < noOfEdges) {

			int vertex1 = Integer.parseInt(sc.next()); // source vertex
			int vertex2 = Integer.parseInt(sc.next()); // destination vertex
			int cEdge = Integer.parseInt(sc.next());// weight of edge

			edges[i++] = new Edge(vertex1, vertex2, cEdge);// add all edges from
															// input

		}

		sc.close();

		List<Edge> edgeList = Arrays.asList(edges);

		System.out.println(edgeList);

		long n1 = System.currentTimeMillis();
		Collections.sort(edgeList);
		Kruskal k1 = new Kruskal();

		for (int i1 = 0; i1 < edgeList.size(); i1++) {
			insert = k1.insert(edgeList.get(i1));
			if (insert) {
				count++;
			}
			if (count == noOfEdges) {
				break;
			}
		}
		long n2 = System.currentTimeMillis();

		for (int i1 = 0; i1 < k1.sets.size(); i1++) {
			mySet t = k1.sets.get(i1);
			for (int j = 0; j < t.edgeSet.size(); j++) {
				System.out.println(t.edgeSet.get(j));
			}
		}
		System.out.println(n2 - n1);

	}
}
