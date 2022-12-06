import java.util.LinkedList;

public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> last;
    private int size = 0;

   public void add(E e){
        Node<E> newNode = new Node<>(null,e);
        if(size == 0 ){
            head = newNode;
        }else if(size == 1){
            last = new Node<>(head,e);
            head.next = last;
        }else{
            Node<E> current = new Node<>(last,e);
            last.next = current;
            last = current;
        }
        size++;
    }

    public E get(int index){
       if(0 > index || index > size) throw new IndexOutOfBoundsException("index is invalid");

        return getNodeByIndex(index).current;
   }

    public void clear(){
       head = new Node<>(null,null);
       size = 0;
    }

    public void remove(int index){
        if(0 > index || index > size) throw new IndexOutOfBoundsException("Выход за пределы");

        Node<E> newNode = getNodeByIndex(index);
        if(index == 0 ){
            head = head.next;
            head.prev = null;
        }else if(index == size){
         last = last.prev;
         last.next = null;
        }else{
        newNode.prev.next = newNode.next;
        newNode.next.prev = newNode.prev;}
        size --;
    }

    private Node<E> getNodeByIndex(int index){
       Node<E> tempNode = head;
       for(int i = 1; i < index;i++){
           tempNode = tempNode.next;
       }
       return tempNode;
    }
    public int size() {
       return size;
    }
    private class Node<E>{
        E current;
        Node<E> prev;
        Node<E> next;


        private Node(Node<E> prev, E current){
            this.current = current;
            this.prev = prev;
            this.next = null;
        }
    }

}
