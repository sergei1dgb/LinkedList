/**
 * Created by Sergo on 02.11.2019.
 */
public interface Functions<E> {
    public void add(E element);
    public void addFirst(E element);
    public void addMiddle(int i, E element);
    public <E> void remove(int i);
    public void remove(E i);
    public <E> E getElemById(int i);
    public <E>  LinkedList<E> getClassById(int i);
    public int size();
}