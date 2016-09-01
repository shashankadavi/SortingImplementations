import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * This class implements the quick sort using an array 
 * 
 * @author Shashank
 */
/**
 * thsi method recursively calls them and implements them
 */
public class QuickSort {
	//index set for counting partitions
	static  int count=0;
	
	public void quickSort(int[] array, int first, int last) {
		
		if (first >= last) {
			return;
		}
		int i = first;
		int j = last;
		int pivot = 0;
		try {
			pivot = (int) Math.random() % (last - first + 1);
			pivot = pivot + first;
		} catch (Exception e) {
			pivot = (last + first) / 2;
		}
		
		int pivotElement = array[pivot];
		count++;

		int temp1;
		int temp2;
		int k;

		
		temp1 = array[pivot];
		array[pivot] = array[i];
		array[i] = temp1;
		i++;
		
		while (i < j) {

			while (i < last && array[i] <= pivotElement)
				i++;

			while (j > first && array[j] > pivotElement)
				j--;

			if(i<j){
			temp2 = array[i];
			array[i] = array[j];
			array[j] = temp2;
			
			}
			

		}
		for (k = last; k > first; k--) {
			if (pivotElement > array[k]) {
				break;
			}
		}

		temp2 = array[k];
		array[k] = array[first];
		array[first] = temp2;

		quickSort(array, first, k - 1);
		quickSort(array, k + 1, last);
		
	}
	

	public static void main(String[] args) {
		QuickSort q1 = new QuickSort();
		

		
		Scanner sc=null;
		int size=1000;
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
		q1.quickSort(input,0,input.length-1);
		//System.out.println();
		long t2=System.currentTimeMillis();
		System.out.println("Time taken:"+(t2-t1)+"ms");
	}


	}

