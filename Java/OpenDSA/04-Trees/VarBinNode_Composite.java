/**
 * Base class: Composite
 */
interface VarBinNode {
    boolean isLeaf();

    void traverse();
}

/**
 * Leaf node: Composite
 */
class VarLeafNode implements VarBinNode {
    private String operand;                 // Operand value

    VarLeafNode(String val) {
        operand = val;
    }

    boolean isLeaf() {
        return true;
    }

    String value() {
        return operand;
    }

    void traverse() {
        Visit.VisitLeafNode(operand);
    }
}

/**
 * Internal node: Composite
 */
// Internal node
class VarIntlNode implements VarBinNode {
    // Left child
    private VarBinNode left;
    // Right child
    private VarBinNode right;
    // Operator value
    private Character operator;

    VarIntlNode(Character op, VarBinNode l, VarBinNode r) {
        operator = op;
        left = l;
        right = r;
    }

    boolean isLeaf() {
        return false;
    }

    VarBinNode leftchild() {
        return left;
    }

    VarBinNode rightchild() {
        return right;
    }

    Character value() {
        return operator;
    }

    void traverse() {
        Visit.VisitInternalNode(operator);
        if (left != null) {
            left.traverse();
        }
        if (right != null) {
            right.traverse();
        }
    }
}

    /**
     * Preorder traversal
     */
    static void traverse(VarBinNode rt) {
        if (rt != null) {
            rt.traverse();
        }
    }