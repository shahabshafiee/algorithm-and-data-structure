/**
 * 
 */

/**
 * @author shahab shafieihajiabady
 *
 */
public class Client {

	public static void main(String[] args) {

		int i;
		PQmin PQ=new PQmin();//create a PQmin object
		for (i=0;i<10;i++)
		{
			PQ.insert((int)(1+Math.random()*100));//generate a random number between 1 and 100 and callin inser method
		}
		for (i=0; i<PQ.Array.length ;i++)
		{
			System.out.print(PQ.Array[i]+" ");

		}
		System.out.println();
		System.out.println();
		System.out.println("Length of the array is: " + PQ.Array.length);
		System.out.println("Length of the occupied cells is: " + PQ.k);
		System.out.println();
		
		while (PQ.k>0)
		{
			System.out.print(PQ.delMin()+" ");//calling delMin Method

		}
	}
}
