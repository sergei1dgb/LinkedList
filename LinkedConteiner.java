/**
 * Created by Sergo on 02.11.2019.
 */
public class LinkedConteiner<E> implements Functions<E> {

    LinkedList<E> first;
    LinkedList<E> last;
    LinkedList<E> node;
    int count =0;

    public LinkedConteiner(){
        first = new LinkedList<E>(null, null, last);
        last = new LinkedList<E>(first, null, null);
    }

    public static void main(String[] args) {
        LinkedConteiner<String> s = new LinkedConteiner<String>();
        s.addFirst("Sasha");
        s.addFirst("Sasha1");
        s.addFirst("Sasha2");
        s.add("Sasha3");
        s.add("Sasha4");
        s.add("Sasha5");
        s.addFirst("Sasha2");
        s.add("Sasha6");
        s.addFirst("Sasha0");
       // s.addMiddle(4, "I am a running aroud element");
        for(int i=0; i<s.size(); i++) {
            System.out.println(s.getElemById(i) + " " + i);
        }
    }


    @Override
    public void add(E element) {
        if(count==0){
            node = new LinkedList<E>(first,  element, last);
            first.setNext(node);
            last.setPrev(node);
            count++;
        } else{
            node = new LinkedList<E>(last.getPrev(), element, last);
            last.setPrev(node);
            node.getPrev().setNext(node);
            count++;
        }
    }

    @Override
    public void addFirst(E element) {
        if(count==0){
            node = new LinkedList<E>(first,  element, last);
            first.setNext(node);
            last.setPrev(node);
            count++;
        } else{
            node = new LinkedList<E>(first, element, first.getNext());
            first.setNext(node);
            node.getNext().setPrev(node);
            count++;
        }
    }

    @Override
    public void addMiddle(int i, E element) {
        if(count==0){
            System.out.println("This is a first element for LinkedList");
            node = new LinkedList<E>(first,  element, last);
            first.setNext(node);
            last.setPrev(node);
            count++;
        }
        else if(count!=0 && i==0){
            addFirst(element);
        }
        else if(count!=0 && i>=count){
            add(element);
        }

        else if(count!=0 && i>0 && i<count){
            //node = new  getElemById(i);
            node = new LinkedList<E>(node.getPrev(), element, node.getNext());
            node.getPrev().setNext(node);
            node.getNext().setPrev(node);
            count++;
        }
    }

    @Override
    public E getElemById(int i) {
        LinkedList<E> target = first.getNext();
        for(int j = 0; j<i; j++){
            target = target.getNext();
        }
        return target.getElement();
    }

    @Override
    public int size() {
        return count;
    }
}