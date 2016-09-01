import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class implements the merge sort
 * 
 * @author Shashank
 */

public class MergeSort {
	/**
	 * this method recursively creates the subarrays
	 */
	
	public void mergeSort(int[] array, int start,int end) {
		if(start==end)
			return;
	
			mergeSort(array,start,(start+end)/2);
			mergeSort(array,(start+end)/2+1,end);
			merge(array,start,(start+end)/2+1,end);
		}
	
	/**
	 * this method recursively merges the sub arrays
	 */
	public void merge(int[] array, int i,int j,int k) {
		int oi=i;
		int mid=j;
		int[] temp=new int[array.length];
		
		for(int a=i;a<=j;a++){
			temp[a]=array[a];
		}
		for(int a=j+1;a<=k;a++){
			temp[a]=array[a];
		}
	
		while((i<mid) && (j<=k)){
			
			if(temp[i]<temp[j]){
				array[oi++]=temp[i++];
		
			}else{
				array[oi++]=temp[j++];
			}
		}
		
			while(i<mid){
				array[oi++]=temp[i++];
			}
			while(j<=k){
				array[oi++]=temp[j++];
			}
		

		
		

	}

	public static void main(String[] args) {

		MergeSort m1 = new MergeSort();
		Scanner sc=null;
		int size=1000000;
		int input[]=new int[size];
		
		try {
			 sc =  new Scanner(new FileInputStream(new File(args[0])));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<size;i++){
		input[i]=Integer.parseInt(sc.next());
		}
		long t1=System.currentTimeMillis();
		m1.mergeSort(input,0,input.length-1);
		//System.out.println();
		long t2=System.currentTimeMillis();
		System.out.println("Time taken:"+(t2-t1)+"ms");
	}

}
