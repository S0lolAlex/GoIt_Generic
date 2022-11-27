import java.util.LinkedList;

public class MyLinkedList<E> {
    private Node<E> prevList;
    private Node<E> lastList;

    private int size = 0;

    public MyLinkedList(){
        clear();
    }

    public void add(E e){
        Node<E> newNode = new Node<>(prevList, e, lastList);
        lastList.prevNode = newNode;
        prevList.nextNode = newNode;

        size++;

    }

    public E get(int index){
        Node<E> tmp = prevList.getNextNode();
        for(int i = 0; i < index;i++){
            tmp = getLastList(tmp);
        }
        return tmp.getCurrent();
    }

    private Node<E> getLastList(Node<E> current){
        return current.getNextNode();
    }

    public void clear(){
        lastList = new Node<E>(prevList,null, null);
        prevList = new Node<E>(null, null, lastList);
        size = 0;

    }

    public void remove(int index){
        if(index > size) throw new IndexOutOfBoundsException("Выход за пределы");
        Node<E> tmp = prevList.getNextNode();
        for(int i = 0; i < index;i++){
            tmp = getLastList(tmp);
        }
        Node<E> tmp2 = tmp.getPrevNode();
        tmp2.setNextNode(tmp);
        tmp.setPrevNode(tmp2.getNextNode());
        size--;
    }

    private class Node<E>{
        private E current;
        private Node<E> prevNode;
        private Node<E> nextNode;

        private Node(Node<E> prevNode, E current, Node<E> nextNode){
            this.current = current;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }

        public E getCurrent() {
            return current;
        }

        public Node<E> getPrevNode() {
            return prevNode;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public void setCurrent(E current) {
            this.current = current;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }

        public void setPrevNode(Node<E> prevNode) {
            this.prevNode = prevNode;
        }
    }

    public int size() {
        return size;
    }


}
