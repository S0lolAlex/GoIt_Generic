import java.io.IOException;

public class MyArrayList<T> {
    private T[] array ;

    public MyArrayList(T[] array){
        this.array = array;
    }

    public MyArrayList(){
        array = (T[]) new Object[0];

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

    public void clear(){
        array = (T[]) new Object[0];
        System.out.println("Array is null");
    }

    public int size(){
        return array.length;
    }

    public T get(int index){
        return array[index];
    }

}
