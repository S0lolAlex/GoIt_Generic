import java.util.LinkedList;

public class MyLinkedList<E> {
    private Node<E> head;

   public void add(E e){
        Node<E> newNode = new Node<>(null,e);
        if(head == null){
            head = newNode;
        }else{
        Node<E> last = head;
        while(last.next != null){
            last = last.next;
        }
        newNode.prev = last;
        newNode.size = newNode.prev.size + 1;
        last.next = newNode;}
    }

    public E get(int index){
       if(index > size() - 1) throw new IndexOutOfBoundsException("list is empty or index is invalid");
        Node<E> currNode = head;
        while(currNode != null){
            if(currNode.size == index){
                return currNode.current;
            }
            currNode = currNode.next;
        }
        return null;
   }

    public void clear(){
       head = null;
    }

    public void remove(int index){
        if(index >= size()) throw new IndexOutOfBoundsException("Выход за пределы");
        Node<E> currNode = head,prev = null;

        if(currNode.size == index){
            head = currNode.next;
            head.prev = null;
            currNode = head;
            while(currNode != null){
                currNode.size--;
                currNode = currNode.next;
            }
        }
        currNode = head;
        while(currNode != null && currNode.size != index){
            currNode = currNode.next;
        }
        if(index != 0){
        prev = currNode.prev;
        currNode = currNode.next;
        currNode.prev = prev;
        prev.next = currNode;

        while(currNode != null){
            currNode.size--;
            currNode = currNode.next;
        }
        }
    }
    public int size() {
        if(head == null) throw new NullPointerException("list is empty");
       Node<E> currNode = head;

        while(currNode.next != null){
            currNode = currNode.next;
        }
       return currNode.size + 1;
    }
    private class Node<E>{
        E current;
        Node<E> prev;
        Node<E> next;
        int size = 0;

        private Node(Node<E> prev, E current){
            this.current = current;
            this.prev = prev;
            this.next = null;
        }
    }

    public static void main(String[] args) {
       MyLinkedList<Integer> list = new MyLinkedList<>();
       for(int i = 0;i < 100; i++){
            list.add(i * i);
        }
        System.out.println(list.size());
       list.remove(0);
        System.out.println(list.get(98));
    }

}
