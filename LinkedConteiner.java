/**
 * Created by Sergo on 02.11.2019.
 */

public class LinkedConteiner<E> implements Functions<E> {

    LinkedList<E> first;
    LinkedList<E> last;
    LinkedList<E> node;
    private int count =0;

    LinkedConteiner(){
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
        s.addMiddle(3, "Sergo_Middle");
        s.addMiddle(8,"qweqw");
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

        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.getElemById(i) + " " + i);
        }

        s.remove(-1);
        s.removeAll();

        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.getElemById(i) + " " + i);
        }

        if (s.size() == 0) {
            System.out.println("__________________");
            System.out.println("Size of list = " + s.size());
            System.out.println("The list is cleared");
        }

        s.add("Sergo");
        s.add("Sergo");
        s.addFirst("Sergo_First");
        System.out.println();
        System.out.println("Getting the element number 2 after adding into the list three elements...");
        System.out.println(s.getElemById(2));

        if(s.contains("Sergo") == true)
            System.out.println("The element exists in the list");
        else
            System.out.println("The element doesn`t exist in the list");

        s.remove("Sergo");
        System.out.println("_______________________");
        System.out.println("Getting the elements after removing element with value 'Sergo'...");
        for(int i=0; i<s.size(); i++)
        System.out.println(s.getElemById(i));
    }

    @Override
    public void add(E  element) {
        if(size()==0){
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
        if(i<0 || i>size()){
            System.out.println("This index can`t be used");
            return;
        }
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
        else if(size()!=0 && i==size()){
            add(element);
        }

        else if(size()!=0 && i>0 && i<size()){
            node = new LinkedList<E>(getClassById(i).getPrev(), element, getClassById(i));
            node.getPrev().setNext(node);
            node.getNext().setPrev(node);
            count++;
        }
    }

    @Override
    public void remove(int i) {
        if (size() > 0) {
            if (i >= size() || i < 0) {
                System.out.println("This element doesn`t exists");
            } else if (i < size()) {
                node = getClassById(i);
                node.getPrev().setNext(node.getNext());
                node.getNext().setPrev(node.getPrev());
                count--;
            }
        }else{
            System.out.println("The list is empty");
        }
    }

    @Override
    public void remove(E i) {
        E s=null;
        if(size()>0){
           for(int j = 0; j<size(); j++){
               if(getElemById(j).equals(i)) {
                   s = getElemById(j);
                   remove(j);
                   j--;
               }
           }
        }
        if(s==null)
            System.out.println("The element doesn`t exist");
    }

    @Override
    public  E getElemById(int i) {
        LinkedList<E> target =  getClassById(i);
        return target.getElement();
    }

    @Override
    public LinkedList<E> getClassById(int i){
        LinkedList<E> target = null;
        if (size() > 0) {
            target = first.getNext();
            if (i >= 0 && i < size()) {
                for (int j = 0; j < i; j++)
                    target = target.getNext();
            } else {
                System.out.println("The element doesn`t exist");
            }
        }else{
            System.out.println("The list is empty");
        }
        return target;
    }

    @Override
    public void removeAll() {
        while(size()>0){
            remove(0);
        }
    }

    @Override
    public boolean contains(E i) {
        boolean exist = false;
        if(size()>0){
            for(int j=0; j<size(); j++){
                if(getElemById(j).equals(i)){
                    exist=true;
                    break;
            }
            }
        }else{exist=false;}

        return exist;
    }

    @Override
    public int size() {
        return count;
    }
}