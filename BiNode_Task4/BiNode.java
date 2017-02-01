
/**
 * BiNode: binary tree implementation
 * 
 * @author Wolfgang Renz, MMLab, HAW Hamburg 
 * @version Oct. 2015
 */
public class BiNode
{
    public String item; //content
    public BiNode left; //left child
    public BiNode right; //right child

    BiNode(String item) // Leaf constructor
    {
        this(item, null, null);
    }

    BiNode(String item, BiNode left, BiNode right)
    {
        this.item= item;
        this.right= right;
        this.left= left;
    }
    //further: instance methods

    public static String inOrderTraversal(BiNode parent, String str)
    {
        // insert your code here!!!
        return str;
    }

    public static void main(String[]a)
    {
        BiNode three= new BiNode ("3");
        BiNode four= new BiNode ("4");
        BiNode five= new BiNode ("5");
        BiNode plus= new BiNode ("+", four, three);
        BiNode root= new BiNode ("*", five, plus);
        //test-code that has to print
        // ( 5 * ( 4 + 3 ) )
        System.out.println(inOrderTraversal(root, ""));
    }
}