// Doubly linked list node
class DLink {
    // Value for this node
    private Object e;
    // Pointer to next node in list
    private Link n;
    // Pointer to previous node
    private Link p;

    // Constructors
    Link(Object it, Link inp, Link inn) {
        e = it;
        p = inp;
        n = inn;
    }

    Link(Link inp, Link inn) {
        p = inp;
        n = inn;
    }

    // Get and set methods for the data members
    public Object element() {
        // Return the value
        return e;
    }

    public Object setElement(Object it) {
        // Set element value
        return e = it;
    }

    public Link next() {
        // Return next link
        return n;
    }

    public Link setNext(Link nextval) {
        // Set next link
        return n = nextval;
    }

    public Link prev() {
        // Return prev link
        return p;
    }

    public Link setPrev(Link prevval) {
        // Set prev link
        return p = prevval;
    }
}