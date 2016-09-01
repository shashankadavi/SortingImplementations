import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class DataSetRandom {
	public static void main(String[] args) {
		
	
	FileWriter f=null;
	try {
		f = new FileWriter("Input25.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    BufferedWriter writeFile=new BufferedWriter(f);
    
    int data=1000000;
    Random r=new Random();
    
    
    for(int i=0;i<data;i++){
    	try {
    		int no=1+r.nextInt(data);
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
