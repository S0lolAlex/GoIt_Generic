public class MyQueue<T> {
    private Object[] array;

    public MyQueue(){
        array =  new Object[0];

    }

    public MyQueue(Object[] array){
        this.array = array;
    }

    public boolean add(T value){
        if(array == null) {
            array =  new Object[1];
            array[0] = value;
            return true;
        }
        int size = array.length + 1;
            Object[] result =  new Object[size];
        System.arraycopy(array, 0, result, 0, array.length);
            result[result.length - 1] = value;
            array = result;
        return true;
    }

    public void clear(){
        array =  new Object[0];
    }

    public int size(){
        return array.length;
    }

    public Object peek(){
        if(array.length == 0) return null;
        return array[0];
    }

    public Object poll(){
        Object value = array[0];
        if(array.length == 1 ) {array = null; return value;}
        int size = array.length - 1;
        Object[] result =  new Object[size];
        System.arraycopy(array, 1, result, 0, size - 1);
        array = result;
        return value;
    }

    public static void main(String[] args) {
        MyQueue<String> example = new MyQueue<>();
        System.out.println(example.peek());
    }
}
