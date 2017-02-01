public class EncodingDecoding {

	private Node root = new Node();
	private class Node {
		char ch;
		Node left, right;
		
		Node() {//building the tree by using preorder traversal 
			ch = StdIn.readChar();
			if (ch == '*') {
				left = new Node();
				right = new Node();
			}
		}
		boolean isInternal() {//check if the node is a leaf or an inner node
			if (this.ch == '*')
				return true;
			return false;
		}
	}
	
	//------------------------------encode------------------------------
	
	public String[] encode() {
		String[] st = new String[128];
		encode(st, this.root, "");
		return st;
	}	
	public void encode(String[] st, Node x, String s) {
		if (!x.isInternal()) {
			st[x.ch] = s;
			return;
		}
		encode(st, x.left, s + '0');//add a zero every time that we go left
		encode(st, x.right, s + '1');//add a one every time that we go right
	}
	
	//-------------------------------decode-----------------------------
	
	public void decode(String str, int N) {
		int index = 0;
		for (int i = 0; i < N; i++) {
			Node x = root;
			while (x.isInternal()) {
				if (index == str.length())
					break;
				char bit = str.charAt(index);
				index += 1;
				if (bit == '0')
					x = x.left;
				else if (bit == '1')
					x = x.right;
			}
			System.out.print(x.ch);
		}
	}
}
