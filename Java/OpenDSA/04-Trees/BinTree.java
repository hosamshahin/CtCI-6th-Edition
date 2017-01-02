class BinTree implements BinNode {

    public static void preorder(BinNode rt) {
        // Empty subtree - do nothing
        if (rt == null) {
            return;
        }
        // Process root node
        visit(rt);
        // Process all nodes in left
        preorder(rt.left());
        // Process all nodes in right
        preorder(rt.right());
    }


    // bad implementation
    public static void ineff_BTinc(BinNode root) {
        if (root != null) {
            root.setValue(root.value() + 1);
            if (root.left() != null) {
                root.left().setValue((root.left().value()) + 1);
                ineff_BTinc(root.left().left());
            }
            if (root.right() != null) {
                root.right().setValue((root.right().value()) + 1);
                ineff_BTinc(root.right().right());
            }
        }
    }

    static int count(BinNode rt) {
        if (rt == null) {
            // Nothing to count
            return 0;
        }
        return 1 + count(rt.left()) + count(rt.right());
    }

    // bad implementation
    static int ineff_count(BinNode root) {
        if (root == null) {
            return 0;  // Nothing to count
        }
        int count = 0;
        if (root.left() != null) {
            count = 1 + ineff_count(root.left());
        }
        if (root.right() != null) {
            count = 1 + ineff_count(root.right());
        }
        if (root.left() == null && root.right() == null) {
            return 1;
        }
        return 1 + count;
    }

}
