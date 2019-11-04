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
        s.addMiddle(4, "I am a running aroud element1");
        s.addMiddle(4, "I am a running aroud element2");
        s.add("Sasha_Last");
        s.addFirst("Sergo_First");
        s.addMiddle(4, "I am a running aroud element3");
        s.remove(12);
        s.remove(1);
        s.remove("Sasha54323423");
        s.add("Sasha5");
        s.add("Sergo");
        for(int i=0; i<s.size(); i++) {
            System.out.println(s.getElemById(i) + " " + i);
        }
    }


    @Override
    public void add(E  element) {
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
        if(size()==0){
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
        if(size()==0){
            System.out.println("This is a first element for LinkedList");
            node = new LinkedList<E>(first,  element, last);
            first.setNext(node);
            last.setPrev(node);
            count++;
        }
        else if(size()!=0 && i==0){
            addFirst(element);
        }
        else if(size()!=0 && i>=size()){
            add(element);
        }

        else if(size()!=0 && i>0 && i<size()){
            node = new LinkedList<E>(getClassById(i-1), element, getClassById(i));
            node.getPrev().setNext(node);
            node.getNext().setPrev(node);
            count++;
        }
    }

    @Override
    public void remove(int i) {
        if(size()==0){
            System.out.println("List is empty");
        }
        else if(i==size()){
            System.out.println("This element doesn`t exists");
        }
        else if(size()>0 && i<size()){
            node = getClassById(i);
            getClassById(i-1).setNext(node.getNext());
            node.getNext().setPrev(getClassById(i-1));
            count--;
        }
    }

    @Override
    public void remove(E i) {
        if(size()==0){
            System.out.println("List is empty");
        }
        else {
           for(int j = 0; j<size(); j++){
               if(getElemById(j).equals(i)) {
                   remove(j);
               }
           }
            System.out.println("This element doesn`t exist");
        }
    }

    @Override
    public  E getElemById(int i) {
        LinkedList<E> target =  first.getNext();
          for(int j = 0; j<i; j++){
            target = target.getNext();
        }
        return target.getElement();
    }

    @Override
    public LinkedList<E> getClassById(int i){
        LinkedList<E> target = first.getNext();
        for(int j = 0; j<i; j++){
            target = target.getNext();
        }
        return target;
    }

    @Override
    public int size() {
        return count;
    }
}