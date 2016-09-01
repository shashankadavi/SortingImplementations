import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class implements the heap sort using an array and a logical partition
 * 
 * @author Shashank
 */
public class HeapSort {
	// start index set to 1 for the array
	public static final int START_ARRAY = 1;
	// this variable divides the array into sub parts of unsorted and
	// sorted(heap as intermediate)
	private int partition = START_ARRAY;
	// this is the input and also represents the sorted array
	private int[] array;

	/**
	 * This is parameterized constructor, which initiates the sorting process
	 * 
	 * @param Inputs
	 *            ' Array
	 */
	public HeapSort(int[] myArray) {
		array = myArray;
		init();
	}

	/**
	 * This method initiates the sorting process
	 */
	public void init() {
		/*
		 * this loop arranges the array according to heap property. partition
		 * logically divides array into sorted and unsorted parts
		 */
		for (int elementIndex = START_ARRAY; elementIndex < array.length; elementIndex++) {
			buildHeap(elementIndex);
			partition++;
		}
		partition--;

		/*
		 * this loop constructs the heap array into sorted array partition
		 * variable logically decides which element is last and also to be
		 * inserted in place of root
		 */
		while (partition >= START_ARRAY) {
			breakHeap();
			partition--;
		}
		partition++;
	}

	/**
	 * this method removes root element from heap array and inserts into
	 * logically sorted array(i.e. at the back) and hence, the resultant is an
	 * array sorted in desc order
	 */
	public void breakHeap() {
		replace(partition, START_ARRAY);
		int currentIndex = START_ARRAY;
		int childIndex = 2 * currentIndex;
		/*
		 * this loop ends on condition when child index goes beyond the range of
		 * heap array
		 */
		while (true) {
			// if no child node
			if (childIndex + 1 >= partition) {
				break;
			}
			// if there is a child whose parent is greater
			if (array[currentIndex] > array[childIndex]
					|| array[currentIndex] > array[childIndex + 1]) {
				/*
				 * decides which child is smaller and hence to be replaced and
				 * updates the child and parent nodes on heap array
				 */
				if (array[childIndex] < array[childIndex + 1]) {
					replace(childIndex, currentIndex);
					currentIndex = childIndex;
					childIndex = 2 * currentIndex;
				} else {
					replace(childIndex + 1, currentIndex);
					currentIndex = childIndex + 1;
					childIndex = 2 * currentIndex;
				}
			} else {
				// if the parent node is smaller
				break;
			}
		}
	}

	/**
	 * this method build up heap array from unsorted array. takes the element to
	 * insert in heap array as an argument and inserts it in the back and
	 * optimizes according to the heap property
	 * 
	 * @param element
	 *            To Insert
	 */
	public void buildHeap(int elementToInsert) {
		// till we aren't done i.e the pointer reaches root node
		while (elementToInsert >= START_ARRAY) {
			/*
			 * calculates the parent index and checks if heap property is
			 * maintained if the parent root goes beyond the reach of heap,
			 * break else replace the parent and child to optimize and thus,
			 * maintain the heap property
			 */
			int parent = elementToInsert / 2;
			if (parent < START_ARRAY) {
				break;
			}
			if (array[parent] > array[elementToInsert]) {
				replace(parent, elementToInsert);
			}
			// updates the parent
			elementToInsert = parent;
		}
	}

	/**
	 * this method swaps the elements at the specified indexes
	 * 
	 * @param index1
	 * @param index2
	 */
	public void replace(int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	/**
	 * this method returns the string representation of the sorted array which
	 * is read from last to first as the sorted array is maintained
	 */
	@Override
	public String toString() {
		String arrayToString = "";
		for (int i = array.length - 1; i >= START_ARRAY; i--) {
			arrayToString += array[i] + " ";
		}
		return arrayToString;
	}

	/**
	 * this is main method, it reads the inputs and instatiates HeapSort and
	 * prints the output
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=null;
		int size=1000000;
		int[] input = new int[size + HeapSort.START_ARRAY];
		
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
		HeapSort h1 = new HeapSort(input);
		//System.out.println();
		long t2=System.currentTimeMillis();
		System.out.println("Time taken:"+(t2-t1)+"ms");

		
		/*for (int i = HeapSort.START_ARRAY; i < input.length; i++) {
			input[i] = input.length - i;
		}*/
		
	}
}