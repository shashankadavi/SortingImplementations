
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class DataSetOrdered {
	
	public static void main(String[] args) {
		FileWriter f=null;
		try {
			f = new FileWriter("Input15.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    BufferedWriter writeFile=new BufferedWriter(f);
	    
	    int data=1000000;
	    
	    for(int i=0;i<data;i++){
	    	try {
				writeFile.write(i+"");
				writeFile.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	    
	   try {
		writeFile.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		
	}

}
