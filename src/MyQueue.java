public class MyQueue<T> {
    private T[] array;

    public MyQueue(){
        array = (T[]) new Object[0];

    }

    public MyQueue(T[] array){
        this.array = array;
    }

    public boolean add(T value){
        if(array == null) {
            array = (T[]) new Object[1];
            array[0] = value;
            return true;
        }
        int size = array.length + 1;
        try{
            T[] result = (T[]) new Object[size];
            int i = 0;
            for(T s : array){
                result[i++] = s;
            }
            result[result.length - 1] = value;
            array = result;}catch (ClassCastException e){
            return false;
        }
        return true;
    }

    public void clear(){
        array = (T[]) new Object[0];
    }

    public int size(){
        return array.length;
    }

    public T peek(){
        return array[0];
    }

    public T poll(){
        T value = array[0];
        if(array.length == 1 ) {array = null; return value;}
        int size = array.length - 1;
        T[] result = (T[]) new Object[size];
        int index = 0;
        for(int i = 1;i < size;i++){
            result[index++] = array[i];
        }
        array = result;
        return value;

    }
}
