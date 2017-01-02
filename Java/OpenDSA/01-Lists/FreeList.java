// Singly linked list node with freelist support
class Link {
    private Object e;  // Value for this node
    private Link n;    // Point to next node in list

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
        return e;
    }           // Return the value

    Object setElement(
            Object it) {
        return e = it;
    } // Set element value

    Link next() {
        return n;
    }                // Return next link

    Link setNext(Link inn) {
        return n = inn;
    }      // Set next link

    // Extensions to support freelists
    // Freelist for the class
    static Link freelist = null;

    // Return a new link, from freelist if possible
    static Link get(Object it, Link inn) {
        if (freelist == null) {
            // Get from "new"
            return new Link(it, inn);
        }
        // Get from freelist
        Link temp = freelist;
        freelist = freelist.next();
        temp.setElement(it);
        temp.setNext(inn);
        return temp;
    }

    // Return a link node to the freelist
    void release() {
        e = null;   // Drop reference to the element
        n = freelist;
        freelist = this;
    }
}