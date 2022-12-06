public class MyStack<T> {
    private Object[] array =  new Object[0];

    public MyStack(){

    }

    public MyStack(Object[] array){
        this.array = array;
    }

    public boolean push(T value){
        int size = array.length + 1;
        Object[] result = new Object[size];
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

    public boolean remove(int index){
        if(index > array.length - 1) throw new IndexOutOfBoundsException("Превышен индекс");
        Object[] result = new Object[array.length - 1];
        Object valueRemove = array[index];
        if(index == 0){
            System.arraycopy(array,0,result,1,array.length - 1);
        }else if(index == array.length -1){
            System.arraycopy(array, 0, result, 0, index - 1);
        }else{
            System.arraycopy(array, 0, result, 0, index);
            System.arraycopy(array, index + 1, result, index, array.length - (index + 1) );
        }
        array = result;
        return true;
    }

    public Object peek(){
        return array[array.length - 1];
    }

    public Object poll(){
        Object value = array[array.length - 1];
        if(array.length == 1 ) {array = null; return value;}
        int size = array.length - 1;
        Object[] result = new Object[size];
        System.arraycopy(array, 1, result, 0, array.length - 1);
        array = result;
        return value;
    }


}
