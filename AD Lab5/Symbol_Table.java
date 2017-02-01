public interface Symbol_Table <Key extends Comparable<Key>, Value> {
	
	public void put(Key key, Value val);
	public Value get(Key key);
	
}
