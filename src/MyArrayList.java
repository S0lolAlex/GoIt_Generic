import java.io.IOException;

public class MyArrayList<T> {
    private T[] array= (T[]) new Object[10];

    public MyArrayList(T[] array){
        if(array.length < this.array.length){
        System.arraycopy(array,0,this.array,0,array.length);
        }else{
            while(array.length > this.array.length){
            this.array =(T[]) new Object[this.array.length * 2];
            }
            System.arraycopy(array,0,this.array,0,array.length);
        }
    }
    public MyArrayList(){    }

    public boolean add(T value){
       int  lastValueIndex;
        if(array[array.length - 1] != null){
             lastValueIndex = array.length;
            T[] result = (T[]) new Object[lastValueIndex + 10];
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

    public T remove(int index){
        T[] result = (T[]) new Object[array.length - 1];
        T valueRemove = array[index];
        if(index == 0){
            System.arraycopy(array,0,result,1,array.length - 1);
        }else if(index == array.length -1){
            System.arraycopy(array, 0, result, 0, index - 1);
        }else{
            System.arraycopy(array, 0, result, 0, index);
            System.arraycopy(array, index + 1, result, index, array.length - (index + 1) );
        }
        array = result;
       return valueRemove;
    }

    public void clear(){
        array = (T[]) new Object[10];
    }

    public int size(){
        int size = 0;
        if(array[array.length - 1] != null) return array.length;
        while(array[size]!=null){
            size++;
        }
        return size;
    }

    public T get(int index){
        if(array[index] == null) throw new IndexOutOfBoundsException("Нет такого индекса");
        return array[index];
    }

    public static void main(String[] args) {
        MyArrayList<String> example = new MyArrayList<>();
        example.add("1");
        example.add("2");
        example.add("3");
        example.add("4");
        example.add("5");
        example.add("6");
        example.add("7");
        example.add("8");
        example.add("9");
        example.add("10");
        example.add("11");
        System.out.println(example.get(6) + " " + example.size());
        example.remove(6);
        System.out.println(example.get(6) + " " + example.size());
        example.clear();
        System.out.println(example.size());
    }

}
