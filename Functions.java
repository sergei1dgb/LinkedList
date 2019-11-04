/**
 * Created by Sergo on 02.11.2019.
 */
public interface Functions<E> {
    public void add(E element);
    public void addFirst(E element);
    public void addMiddle(int i, E element);
    public  void remove(int i);
    public void remove(E i);
    public  E getElemById(int i);
    public  LinkedList<E> getClassById(int i);
    public void clear();
    public int size();
}