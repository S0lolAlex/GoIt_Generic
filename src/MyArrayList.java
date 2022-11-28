import java.io.IOException;

public class MyArrayList<T> {
    private final int START_LENGTH = 10;
    private Object[] array;
    private int tempSize;


    public MyArrayList(Object[] array){
        initArray();
        tempSize = this.array.length;
        if(array.length < tempSize){
        System.arraycopy(array,0,this.array,0,array.length);
        }else{
            while(array.length > tempSize){
            this.array = new Object[this.array.length * 2];
            tempSize = this.array.length;
            }
            System.arraycopy(array,0,this.array,0,array.length);
        }
    }
    public MyArrayList(){
        initArray();
    }

    private void initArray(){
        array = new Object[START_LENGTH];
    }

    public boolean add(T value){
        tempSize = array.length - 1;
        if(tempSize == getLastIndex()){
            Object[] result =  new Object[getLastIndex() + 10];
            System.arraycopy(array,0,result,0,getLastIndex());
            array = result;
            array[getLastIndex()] = value;
        }else{

            array[getLastIndex()] = value;
        }
        return true;
    }

    public Object remove(int index){
        tempSize = array.length;
        if(index > size() - 1) throw new IndexOutOfBoundsException("Превышен индекс");
        Object[] result =  new Object[tempSize - 1];
        Object valueRemove = array[index];
        if(index == 0){
            System.arraycopy(array,0,result,1,tempSize - 1);
        }else if(index == tempSize -1){
            System.arraycopy(array, 0, result, 0, index - 1);
        }else{
            System.arraycopy(array, 0, result, 0, index);
            System.arraycopy(array, index + 1, result, index, tempSize - (index + 1) );
        }
        array = result;
       return valueRemove;
    }

    public void clear(){
        array =  new Object[START_LENGTH];
    }

    private int getLastIndex(){
        int lastIndex = 0;
        if(array[array.length - 1] != null) return array.length;
        while(array[lastIndex]!=null){
            lastIndex++;
        }
        return lastIndex;
    }

    public int size(){
        if(getLastIndex() == 0) throw new IndexOutOfBoundsException("массив пуст");

        return getLastIndex();
    }

    public Object get(int index){
        if(array[index] == null) throw new IndexOutOfBoundsException("Нет такого индекса");
        return array[index];
    }

}
