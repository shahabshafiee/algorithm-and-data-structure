/**
 * 
 */

/**
 * @author shahab shafieihajiabady
 *
 */
public class PQmin {
	//---------------------------------attributes---------------------------------------
	public int k=0;//number of nodes
	public Integer[] Array=new Integer[1];
	//---------------------------------default constructor------------------------------
	public PQmin() {
	}

	//----------------------------------methods-----------------------------------------
	public int delMin()//return the root as the min value decrement the array and call heapReconstruction
	{
		int Min=Array[0];//select the root as min
		Array[0]=Array[k-1];//assign last leaf to root
		Array[k-1]=null;//delete last leaf
		k--;//decrement number of nodes
		heapReconstruction();//call heapReconstruction method
		return Min;	
	}
	public void insert(int N)//insert a new element
	{
		push(N);//calling Push method
		int m=k-1;
		if (k>1)
		{
			while (Array[m/2]>Array[m])//call swap if parent is greater than child
			{
				swap(m/2,m);
				m=m/2;
			}
		}
	}
	public void push(int n)//add new numbers to the array
	{
		if (k >= Array.length){
			resize(2*Array.length);//if array is full we extend it
		}
		Array[k++] = n;//
	}
	public void resize(int L)//extend the array
	{
		Integer[] temp = new Integer[L];
		for (int i = 0; i <k ; i++)//copy all the items into temp array
			temp[i] = Array[i];
		Array = temp;//assign the temp array to the new extended aaray
	}
	public void swap(int i , int j){//swap element i and j in Array
		int temp=0;
		temp=Array[i];
		Array[i]=Array[j];
		Array[j]=temp;
	}
	public void heapReconstruction(){//reconstruct the heap in a way that every parent is smaller than it's children
		int n=0,i=0;
		while (2*i<k)
		{
			if (Array[2*i+1]==null) //if the right leaf is null we go left
			{
				n=2*i;
			}
			else if(Array[2*i+1]!=null){//if the right leaf is not null but left branch is smaller than right branch we go left
				if (Array[2*i]<=Array[2*i+1])
				{
					n=2*i;
				}
				else //go right
				{
					n=2*i+1;
				}
			}
			if (Array[i]>Array[n])//if parent is greater than child then swap
			{
				swap(i,n);
				i=n;//start from the child 
			}
			else break;
		}
	}
}
