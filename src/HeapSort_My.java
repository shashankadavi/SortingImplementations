

public class HeapSort_My {
	public static final int s=1;
	private int part=s;
	int[] array;
	
	public void HeapSort(int[] myArray){
		array=myArray;
		init();
	}
	
	public void check(){
		printArray(array);
		System.out.println(part);
		
	}
	public void init(){
		for(int i=s;i<array.length;i++){
		buildHeap(i);
		part++;
		}
		part--;
		check();
		while(part>=s){
			breakHeap();
			part--;
		}
		part++;
	}
	
	public void breakHeap(){
		replace(part, s);
		int i=s;
		int child=2*i;
		String x="jab tak suraj chand rahega";
		while(x.equals("jab tak suraj chand rahega")){
			
			if(child+1>=part){
				if(child>=part){
					check();
					System.out.println("----done1");
					break;
				}else{
					//child 1 in range
					if(array[child]>array[i]){
						
						System.out.println(array[i]+" "+array[child]);
						replace(child, i);
						check();
						System.out.println("----done2");
						break;
					}
				}
			}	
			System.out.print("cur: "+array[i]+" child "+array[child]+" & "+array[child+1]+" ");check();
			
			if(array[i]>array[child] || array[i]>array[child+1]){
				if(array[child]<array[child+1]){
					replace(child, i);
					i=child;
					child=2*i;
				}else{
					replace(child+1, i);
					i=child+1;
					child=2*i;
				}
				
			}else{
				check();
				System.out.println("----done3");
				
				break;
			}
		
			
		}
		
	}
	
	public void buildHeap(int i){
		while(i>=s){
			int parent=i/2;
			if(parent<s){
				break;
			}
			if(array[parent]>array[i]){
				replace(parent, i);
			}
			i=parent;
		}
	}
	
	public void replace(int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	public void printArray(int[] anArray){
		System.out.print(" Sorted [");
		for(int i=part;i<array.length;i++){
			System.out.print(" "+anArray[i]+" ");
		}
		//System.out.print(" "+anArray[array.length-1]+" ");
		System.out.print("] ");
		System.out.print(" unsorted [");
		
		for(int i=s;i<part;i++){
			System.out.print(" "+anArray[i]+" ");
		}
		System.out.print("] \n");
	}

	public static void main(String[] args) {
	
		int size=1000;
		int[] input=new int[size+HeapSort.s];
		for(int i=HeapSort.s;i<input.length;i++){
			input[i]=input.length-i;
		}
		
		HeapSort obj=new HeapSort(input);		
		System.out.print("output: ");obj.printArray(input);
		
		
	}
	
}
