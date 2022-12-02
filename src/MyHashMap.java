public class MyHashMap<K,V> {
    Node<K,V> head;
    int size ;

    public void put(K key, V value){
        Node<K,V> newNode = new Node<>(key,value);
        newNode.next = null;

        if(head == null){
            head = newNode;
            size++;
        }
         Node<K,V> last = head;
            while (last.next != null) {
                if(last.key == key){
                    System.out.println(last.value);
                    last.value = value;
                    return;
                }
                last = last.next;
            }
            last.next = newNode;
            size++;
    }

    public void clear(){
       head =  null;
       size = 0;
    }

    public int size(){
        return size;
    }

    public void remove(K key){
        if(head == null) throw new NullPointerException("list empty");
        Node<K,V> currNode = head, prev = null,temp = head;
        boolean consist = false;
        if(head != null){
            while(temp != null){
                if(temp.key == key){
                    consist = true;
                }
                temp = temp.next;
            }
            if (consist == false)throw new IndexOutOfBoundsException("ключа нет");
        }

        if (currNode != null && currNode.key == key) {
            head = currNode.next;
        System.out.println(currNode.value);
        if(size > 1){size--;}else {size = 0;}
        }
        while (currNode != null && currNode.key != key) {
            prev = currNode;
            currNode = currNode.next;
        }
        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(currNode.value);
            size--;
        }
        if (currNode == null) {
            System.out.println("key not found");
        }

    }

    public V get(K key){
        if(head == null) throw new NullPointerException("list empty");
        Node<K,V> currNode = head,temp = head;
        V value = null;
        boolean consist = false;

        if(head != null){
            while(temp != null){
                if(temp.key == key){
                    consist = true;
                }
                temp = temp.next;
            }
            if (consist == false)throw new IndexOutOfBoundsException("ключа нет");
        }

        while (currNode != null) {
            if(currNode.key == key){
               return currNode.value;
            }
            currNode = currNode.next;
        }
        return value;
    }

}
class Node <K,V>{
     K key;
     V value;
    Node<K,V> next;

    public Node(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

}
