

public class LinkedList<E> {
    private E element;
    private LinkedList<E> prev;
    private LinkedList<E> next;

    public LinkedList(LinkedList<E> prev, E element, LinkedList<E> next){
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public E getElement(){return element; }

    public void setElement(E element) {
        this.element = element;
    }

    public LinkedList<E> getPrev() {
        return prev;
    }

    public void setPrev(LinkedList<E> prev) {
        this.prev = prev;
    }

    public LinkedList<E> getNext() {
        return next;
    }

    public void setNext(LinkedList<E> next) {
        this.next = next;
    }

}