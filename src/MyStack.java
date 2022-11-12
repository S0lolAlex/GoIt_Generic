public class MyStack<T> {
    T[] array;

    public MyStack(){

    }

    public MyStack(T[] array){
        this.array = array;
    }

    public boolean push(T value){
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

    public boolean remove(int index){
        T[] result = (T[]) new Object[array.length - 1];
        int i = 0,j = 0;
        try{
            for(T s : array){
                if(i++ == index){
                    continue;
                }
                result[j++] = s;
            }

            array = result;}
        catch(IndexOutOfBoundsException e){
            return false;
        }
        return true;
    }

    public T peek(){
        return array[array.length - 1];
    }

    public T poll(){
        T value = array[array.length - 1];
        if(array.length == 1 ) {array = null;return value;}
        int size = array.length - 1;
        T[] result = (T[]) new Object[size];
        for(int i = 0;i < size;i++){
            result[i] = array[i];
        }
        array = result;
        return value;

    }

}
