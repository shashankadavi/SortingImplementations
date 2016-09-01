import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class implements the quick sort using the median of medians algorithm 
 * 
 * @author Shashank
 */

public class MY_CHOICE_QSORT {
	//index set for counting partitions
	static int  count=0;
	
	
	/**
	 * this method finds the medians
	 */
	public void forMedian(int[] a){
		for(int i=0;i<a.length;i+=3){
			if(i+2>=a.length){
				break;
			}
			for(int x=i;x<i+3;x++){
				for(int y=x;y>i;y--){
					if(a[y]<a[y-1]){
						int temp=a[y];
						a[y]=a[y-1];
						a[y-1]=temp;
					}
				}
				
				
			}
			
		}
		
		
		
	}
	
	/**
	 * this method implements quick sort
	 */
	
	public void quickSort(int[] array, int first, int last) {
		if(last-first==1){
			if(array[last]<array[first]){
				int temp=array[last];
				array[last]=array[first];
				array[first]=temp;
			}
			return;
		}
		if(first>=last){
			return;
		}
		

		forMedian(array);
	
		int i = first;
		int j = last;
		int pivot = 0;
	
		
		pivot=(int )Math.random()% ((last-first+1)/3);
		pivot=pivot*3+1+first;
		count++;
		
		int pivotElement = array[pivot];

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
		// System.out.println("here");
	}

	
	
	public static void main(String[] args) {
		MY_CHOICE_QSORT q1 = new MY_CHOICE_QSORT();
		Scanner sc=null;
		int size=50000;
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
