// Binary tree node implementation: supports comparable objects
class BSTNode implements BinNode {
    // Element for this node
    private Comparable element;
    // Pointer to left child
    private BSTNode left;
    // Pointer to right child
    private BSTNode right;

    // Constructors
    BSTNode() {
        left = right = null;
    }

    BSTNode(Comparable val) {
        left = right = null;
        element = val;
    }

    BSTNode(Comparable val, BSTNode l, BSTNode r) {
        left = l;
        right = r;
        element = val;
    }

    // Get and set the element value
    public Comparable value() {
        return element;
    }

    public void setValue(Comparable v) {
        element = v;
    }

    // We need this one to satisfy BinNode interface
    public void setValue(Object v) {
        if (!(v instanceof Comparable)) {
            throw new ClassCastException("A Comparable object is required.");
        }
        element = (Comparable) v;
    }

    // Get and set the left child
    public BSTNode left() {
        return left;
    }

    public void setLeft(BSTNode p) {
        left = p;
    }

    // Get and set the right child
    public BSTNode right() {
        return right;
    }

    public void setRight(BSTNode p) {
        right = p;
    }

    // return TRUE if a leaf node, FALSE otherwise
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }
}