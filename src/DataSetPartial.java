import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class DataSetPartial {
	public static void main(String[] args) {
		
		
		FileWriter f=null;
		try {
			f = new FileWriter("Input35.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    BufferedWriter writeFile=new BufferedWriter(f);
	    
	    int data=1000000;
	    int size=(int)data/4;
	    Random r=new Random();
	    
	    
	    for(int i=0;i<size;i++){
	    	try {
				writeFile.write(i+"");
				writeFile.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    } 
	    for(int i=size;i<data;i++){
	    	try {
	    		int no=1+r.nextInt(size);
				writeFile.write(no+"");
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
