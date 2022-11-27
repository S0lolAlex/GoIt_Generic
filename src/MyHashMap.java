import java.util.Objects;

public class MyHashMap<K,V> {
    private Node<K,V> list;
    int size ;

    public MyHashMap(){
        list = new Node<K,V>(null,null,null);
        size = 0;
    }

    public V put(K key, V value){
        Node<K,V> newNode = new Node<K,V>(null,null,null);
        Node<K,V> temp = list;
        if(list.getKey() == null){
            list.setKey(key);
            list.setValue(value);
            list.setNext(newNode);
            size++;
            return null;
        }
        while(temp.getNext() != null){
            if(key == temp.getKey()){
                V oldValue = temp.getValue();
                temp.setValue(value);
                return oldValue;
            }
            newNode = temp;
            temp = temp.getNext();
            list = newNode;
        }
        newNode = new Node<K,V>(key,value,null);
        list.setNext(newNode);
        size++;
        return null;
    }

    public void clear(){
       list =  new Node<K,V>(null,null,null);
       size = 0;
    }

    public int getSize(){
        return size;
    }

    public void remove(K key){
        Node<K,V> temp = list;
        Node<K,V> newNode ;
        while(temp.getKey() != null){
            if(key == temp.getKey()){
                if(temp.getNext()!= null){
                    list.setNext(list.getNext());
                }else{ list.setNext(null);}
                size--;
                return;
            }
            newNode = temp;
            temp = temp.getNext();
            list = newNode;
        }
    }

    public V get(K key){
        Node<K,V> temp = list;
        Node<K,V> newNode;
        while(temp.getKey() != null){
            if(key == temp.getKey()){
                return temp.getValue();
            }
            newNode = temp;
            temp = temp.getNext();
            list = newNode;
        }
        return null;
    }


}
class Node <K,V>{
    private K key;
    private V value;
    private Node<K,V> next;

    public Node(K key, V value, Node<K,V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue(){
        return value;
    }
    public void setKey(K key){
        this.key = key;
    }

    public void setValue(V value){
        this. value = value;
    }

    public Node<K,V> getNext(){
        return next;
    }

    public void setNext(Node<K,V> next){
        this.next = next;
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if(o instanceof Node){
            Node<K,V> newNode = (Node<K,V>)o;
            return Objects.equals(key,newNode.getKey())
                    && Objects.equals(value, newNode.getValue())
                    || Objects.equals(hashCode(), newNode.hashCode());
        }
        return false;
    }
}
