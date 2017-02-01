
public class MainClass {

	public static void main(String[] args) {
		String s1 = "she_sells_sea_shells_by_the_seashore";//sample sentence
		String s2 = "***sbl****hea*t*y*ro_"; //preorder traversal

		System.out.println("the original sentence is: \n"+s1);
		System.out.println("\nPlease enter a preorder traversal :");

		EncodingDecoding sentence1 = new EncodingDecoding();//create a new object of class
		String [] str = sentence1.encode();//calling the encode method
		String code = "";
		int zeros = 0, ones = 0;
		for (int i=0; i<s1.length(); i++)
			code += str[s1.charAt(i)];//adding the elements from str to code by using ascii values of characters

		for (int i=0; i<code.length(); i++){//updating the number of zeros and ones
			if (code.charAt(i) == '0') zeros += 1;
			else ones += 1;
		}
		System.out.println("\nThe code is :\n" +code+"\n");
		System.out.println("Total number of bits = " + (zeros + ones ));
		System.out.println("Total number of zeros = " + zeros );
		System.out.println("Total number of ones = " +  ones );
		System.out.println();
		
		for(int i=0;i<128;i++){
			if(str[i]!=null){
				System.out.println((char)i+" is transformed to: "+    str[i]);
			}
		}
		System.out.println("\nThe decoded text is : ");		
		sentence1.decode(code, s1.length());
		System.out.println();
	}
}