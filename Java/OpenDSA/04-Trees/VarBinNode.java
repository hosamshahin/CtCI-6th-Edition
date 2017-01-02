// Base class for expression tree nodes
interface VarBinNode {
    // All subclasses must implement
    boolean isLeaf();
}

/**
 * Leaf node
 */
class VarLeafNode implements VarBinNode {
    // Operand value
    private String operand;

    VarLeafNode(String val) {
        operand = val;
    }

    boolean isLeaf() {
        return true;
    }

    String value() {
        return operand;
    }
}

/**
 * Internal node
 */
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
}

    /**
     * Preorder traversal
     */
    static void traverse(VarBinNode rt) {
        if (rt == null) {
            // Nothing to visit
            return;
        }

        if (rt.isLeaf()) {
            // Process leaf node
            Visit.VisitLeafNode(((VarLeafNode) rt).value());
        } else {
            // Process internal node
            Visit.VisitInternalNode(((VarIntlNode) rt).value());
            traverse(((VarIntlNode) rt).leftchild());
            traverse(((VarIntlNode) rt).rightchild());
        }
    }