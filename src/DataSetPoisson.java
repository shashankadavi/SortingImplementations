import java.io.*;

public class DataSetPoisson {

	public static int getPoisson(double lambda) {
		double L = Math.exp(-lambda);
		double p = 1.0;
		int k = 0;

		do {
			k++;
			p *= Math.random();
		} while (p > L);

		return k - 1;
	}

	public static void main(String args[]) throws IOException {

		FileWriter out = new FileWriter("Input41.txt");
		
		BufferedWriter br = new BufferedWriter(out);
		int n;
		for(int i = 1; i <= 1000000; i++) {
			
			n = getPoisson(800);
			br.write(n + "");
			br.flush();
			br.newLine();
		}
		
		br.close();
		
		
	}

}
