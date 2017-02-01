
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.ArrayList;
/**
 * BiNode: binary tree implementation
 * 
 * @author Wolfgang Renz, MMLab, HAW Hamburg 
 * @version Oct. 2015
 */
public class Tree
{
	//	private  BiNode bn;
	private class BiNode
	{
		public String item; //content
		public BiNode left; //left child
		public BiNode right; //right child

		BiNode(String item) // Leaf constructor
		{
			this.item= item;
			this.right= null;
			this.left= null;
		}

		BiNode(String item, BiNode left, BiNode right)
		{
			this.item= item;
			this.right= right;
			this.left= left;
		}
	}

	private BiNode root= null;

	public Tree(ArrayList<String> str)
	{
		root= construct(str); //additional error treatment necessary
	}

	/**
	 * Methode contruct that builds the arithmetic tree
	 *
	 * @param str Postfix Expression Tokenized
	 * @return root of the arithmetic tree
	 */
	private BiNode construct(ArrayList<String> str){

		Stack<BiNode> ds= new Stack<BiNode>();
		for (String s : str)
		{
			if ((s.equals("+")) || (s.equals("-")) || (s.equals("/")) || (s.equals("*")))
			{
				BiNode right = ds.pop();
				ds.push(new BiNode(s, ds.pop(), right));
			}
			else
			{
				//				try
				//				{
				//					BiNode bn=new BiNode("test",null,null);
				//this.bn=new BiNode(s);
				ds.push(new BiNode(s));
				//				}
				//				catch(NumberFormatException e)
				//				{
				//					// TODO error message
				//				}
			}
		}
		BiNode result= ds.pop();
		return result;
	}

	private void postOrderTraversal(BiNode parent, StringBuffer str)
	{
		if(parent.left!=null||parent.right!=null) //inner node
		{
			postOrderTraversal(parent.left, str);
			postOrderTraversal(parent.right, str);
		}
		str.append( parent.item+" ");
	}

	public void postOrderTraversal(StringBuffer str)
	{
		postOrderTraversal(root, str);
	}

	//further: instance methods
	public static void main(String[] args)
	{
		boolean debug = true;

		if(debug)
			try {
				System.setIn(new FileInputStream("Postfix.txt"));
			}
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		ArrayList<String> input= new ArrayList<String>();

		while(!StdIn.isEmpty())
		{
			input.add( StdIn.readString());
		}
		Tree root= new Tree(input);
		StringBuffer sb= new StringBuffer();
		root.postOrderTraversal( sb);
//		System.out.println(sb);
		StdOut.print(sb);
		StdOut.println();

	}
	
}








