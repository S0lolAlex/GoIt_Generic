import java.io.IOException;

public class MyArrayList<T> {
    private final int START_LENGTH = 10;
    private Object[] array=  new Object[START_LENGTH];
    private int arraySize;


    public MyArrayList(Object[] array){
        arraySize = this.array.length;
        if(array.length < arraySize){
        System.arraycopy(array,0,this.array,0,array.length);
        }else{
            while(array.length > arraySize){
            this.array = new Object[arraySize * 2];
            }
            System.arraycopy(array,0,this.array,0,array.length);
        }
    }
    public MyArrayList(){    }

    public boolean add(T value){
        arraySize = array.length;
       int  lastValueIndex;
        if(array[arraySize - 1] != null){
             lastValueIndex = arraySize;
            Object[] result =  new Object[lastValueIndex + 10];
            System.arraycopy(array,0,result,0,lastValueIndex);
            array = result;
            array[lastValueIndex] = value;
        }else{
            lastValueIndex = 0;
            while(array[lastValueIndex]!= null){
                lastValueIndex++;
            }
            array[lastValueIndex] = value;
        }
        return true;
    }

    public Object remove(int index){
        arraySize = array.length;
        if(index > size() - 1) throw new IndexOutOfBoundsException("Превышен индекс");
        Object[] result =  new Object[arraySize - 1];
        Object valueRemove = array[index];
        if(index == 0){
            System.arraycopy(array,0,result,1,arraySize - 1);
        }else if(index == arraySize -1){
            System.arraycopy(array, 0, result, 0, index - 1);
        }else{
            System.arraycopy(array, 0, result, 0, index);
            System.arraycopy(array, index + 1, result, index, arraySize - (index + 1) );
        }
        array = result;
       return valueRemove;
    }

    public void clear(){
        array =  new Object[10];
    }

    public int size(){
        int lastValueIndex = 0;
        if(array[array.length - 1] != null) return array.length;
        while(array[lastValueIndex]!=null){
            lastValueIndex++;
        }
        return lastValueIndex;
    }

    public Object get(int index){
        if(array[index] == null) throw new IndexOutOfBoundsException("Нет такого индекса");
        return array[index];
    }

}
