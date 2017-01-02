// Binary tree node ADT
interface BinNode {
  // Get and set the element value
  public Object value();
  public void setValue(Object v);

  // return the children
  public BinNode left();
  public BinNode right();

  // return TRUE if a leaf node, FALSE otherwise
  public boolean isLeaf();
}