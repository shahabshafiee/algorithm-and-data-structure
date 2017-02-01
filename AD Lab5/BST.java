
public class BST<Key extends Comparable<Key>, Value>
implements Symbol_Table<Key, Value>
{
	private Node root;
	//--------------------------Node Class--------------------
	private class Node
	{
		Key key;
		Value val;
		Node left, right;

		//------------------constructor-----------------------
		Node(Key key, Value val)
		{
			this.key = key;
			this.val= val;
		}
	}
	//-------------------get method-------------------
	@SuppressWarnings("null")
	public Value get(Key key)
	{
		
		Node x = root;
		while (x != null)
		{
			int cmp = key.compareTo(x.key);
			if (cmp == 0) return x.val;
			else if (cmp <= 0) x = x.left;
			else if (cmp > 0) x = x.right;
		}
		return null;
	}
	//---------------------put method----------------------
	public void put(Key key,Value val)
	{ 
		root = putNode(root, key, val); 
	}

	private Node putNode(Node x, Key key, Value val)
	{
		if (x == null) return new Node(key, val);
		int cmp = key.compareTo(x.key);
		if(cmp==0)x.val=val;
		if (cmp <0) x.left = putNode(x.left, key, val);
		else x.right = putNode(x.right, key, val);
		return x;
	}
}