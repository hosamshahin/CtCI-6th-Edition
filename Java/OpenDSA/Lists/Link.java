class Link {
    // Singly linked list node class
    // Value for this node
    private Object e;
    // Point to next node in list
    private Link n;

    // Constructors
    Link(Object it, Link inn) {
        e = it;
        n = inn;
    }

    Link(Link inn) {
        e = null;
        n = inn;
    }

    Object element() {
        // Return the value
        return e;
    }

    Object setElement(Object it) {
        // Set element value
        return e = it;
    }

    Link next() {
        // Return next link
        return n;
    }

    Link setNext(Link inn) {
        // Set next link
        return n = inn;
    }
}