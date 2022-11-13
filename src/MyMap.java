

class MyHashMap<T,V> {
    public class MyMap<T,V> {
        private MyMap<T,V> next;
        private T key;
        private V value;

    }
    private MyMap<T,V> head;
    private MyMap<T,V> tail;
    private int size = 0;
    public V put(T key, V value)
    {   MyMap<T,V> t = head;
        V sValue;
        if(t.key == key){
            sValue = t.value;
            t.value = value;
            return sValue;
        }
        while (t.next != null) {
            if (t.next.key == key) {
                t = t.next;
                sValue = t.value;
                t.value = value;
                return sValue;
            }
            t = t.next;
        }
        MyMap<T,V> a = new MyMap<T,V>();
        a.key = key;
        a.value = value;
        size++;
        if(head == null)
        {
            head = a;
            tail = a;
        }
        else {
            a.next = head;
            head = a;
        }
        return null;
    }

    public V get(T key){
        V value = null;
        if(head == null)    {
            System.out.println("Список пуст");
        }
        if (head.key == key) {
            value = head.value;
        }
        MyMap<T,V> t = head;
        while (t.next != null) {
            if (t.next.key == key) {
                value = t.next.value;
             }
            t = t.next;
        }
        return value;
    }

    public void clear(){
        head = null;
        tail = null;
    }

    public int size(){return size;}

    public void remove(T key)
    {
        if(head == null)
            return;
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        if (head.key == key) {
            head = head.next;
            size--;
            return;
        }
        MyMap<T,V> t = head;
        while (t.next != null) {
            if (t.next.key == key) {
                if(tail == t.next)
                {
                    tail = t;
                }
                t.next = t.next.next;
                size--;
                return;
            }
            t = t.next;
        }
    }
}


