
public class HeapSort_test {
	
	int[] input=new int[20];
	
	int parent=-1;
	
	
	public void HeapSort(int[] array,int length){
		BuildHeap(array);
		
			
	}
	public void BuildHeap(int a[]){
		int i=0;
		int child1=2*i;
		int child2=2*i+1;
		
		if(parent==-1){
			parent++;
			input[parent]=a[0];
			
		}
		if(parent==0){
		input[1]=a[1];
		input[2]=a[2];
		
		}
		for(int j=1;j<input.length;j++){
		for(int k=3;k<a.length;k++){
			
			
		}
		}
	}
	public void Heapify(){
		
		
		
	}
	public void swap(int i, int j){
		int temp = input[i];
		input[i]=input[j];
		input[j]=temp;
		
	}

	
	public static void main(String[] args) {
	int[] input=new int[20];
	HeapSort h1=new HeapSort();
	for(int i=0;i<20;i++){
		input[i]=i;
	}
    
	h1.BuildHeap(input);
	
	}	

}
