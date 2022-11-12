public class MyLinkedList<E> {

    private Node<E> prevList;
    private Node<E> lastList;

    private int size = 0;

    public MyLinkedList(){
        lastList = new Node<E>(null, prevList,null);
        prevList = new Node<E>(null, null, lastList);
    }

    public void add(E e){
        Node<E> prev = lastList;
        prev.setCurrent(e);
        lastList = new Node<E>(null, prev, null);
        prev.setLastNode(lastList);
        size++;

    }

    public E get(int index){
        Node<E> tmp = prevList.getLastNode();
        for(int i = 0; i < index;i++){
            tmp = getLastList(tmp);
        }
        return tmp.getCurrent();
    }

    private Node<E> getLastList(Node<E> current){
        return current.getLastNode();
    }

    public void clear(){
        lastList = new Node<E>(null, prevList,null);
        prevList = new Node<E>(null, null, lastList);

    }

    public void remove(int index){
        Node<E> tmp = prevList.getLastNode();
        for(int i = 0; i < index;i++){
            tmp = getLastList(tmp);
        }
        Node<E> tmp2 = tmp.getPrevNode();
        tmp2.setLastNode(tmp.getLastNode());
        tmp = tmp2.getLastNode();
        tmp.setPrevNode(tmp2.getLastNode());
    }

    private class Node<E>{
        private E current;
        private Node<E> prevNode;
        private Node<E> lastNode;

        private Node(E current, Node<E> prevNode, Node<E> lastNode){
            this.current = current;
            this.prevNode = prevNode;
            this.lastNode = lastNode;
        }

        public E getCurrent() {
            return current;
        }

        public Node<E> getPrevNode() {
            return prevNode;
        }

        public Node<E> getLastNode() {
            return lastNode;
        }

        public void setCurrent(E current) {
            this.current = current;
        }

        public void setLastNode(Node<E> lastNode) {
            this.lastNode = lastNode;
        }

        public void setPrevNode(Node<E> prevNode) {
            this.prevNode = prevNode;
        }
    }

    public int size() {
        return size;
    }

}
