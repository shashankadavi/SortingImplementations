public class Edge implements Comparable<Edge> {
	public int from = 0;
	public int to = 0;
	public int cost = 0;

	/**
	 * default constructor
	 */
	Edge() {

	}

	/**
	 * constructor to initialize an edge
	 */

	Edge(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	/**
	 * this method compares two edges on basis of cost
	 */

	@Override
	public int compareTo(Edge e1) {
		// System.out.println(cost);
		// System.out.println(e1.cost);

		if (cost > e1.cost) {
			return 1;
		} else if (cost == e1.cost) {
			return 0;
		} else if (cost < e1.cost) {
			return -1;
		}

		return 0;
	}

	/**
	 * this method converts the members to string and returns
	 */
	public String toString() {
		return from + "-" + to + " -> " + cost;
	}

}
