import java.util.Scanner;

class ArrayADT{
    int[] array;
    int size;

    public ArrayADT(int capacity){
        array = new int[capacity];
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == array.length;
    }

    public int get(int index){
        if(index <0 || index >= size){
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
        return array[index];
    }

    public void set(int index, int value){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
        array[index]=value;
    }

    public int getSize(){
        return size;
    }

    public void insert(int index, int value){
        if(index < 0 || index > array.length-1){
            System.out.print("Index is out of range");
        }
        else if(isFull()){
            System.out.println("This array is full.");
        }
        else{
            for(int i = size -1; i>=index; i--){
                array[i+1] = array[i];
            }
            array[index] = value;
            size++;
            System.out.println(value + " inserted at "+index);
        }
    }

    public void delete(int index){
        if(index < 0 || index >= array.length-1){
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
        else if(isEmpty()){
            System.out.println("array is empty.");
        }
        else{
            for(int i = index; i<size-1; i++){
                array[i] = array[i+1];
            }
            array[size - 1 ] =0;
            size--; 
        }

    }

    public int search(int value){
        if(isEmpty()){
            System.out.println("Array is empty.");
            return -1;
        }
        else{
            for(int i=0; i <= size -1; i++){
                if(array[i]== value){
                    return i;
                }
            }
            return -1;
        }
    }

    public void traverse() {
        for(int i = 0; i <= size -1; i++){
            System.out.println(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        ArrayADT arr = new ArrayADT(5);

        Scanner input = new Scanner(System.in);


        // inserting elements
        for(int i=0; i <= arr.array.length-1;i++){
            System.out.print(i + "index is : ");
            int value = input.nextInt();
            arr.insert(i,value);
        }

        //accessing and modifying
        System.out.println("Element at index 2: "+arr.get(2));
        arr.set(2,9);
        System.out.println("Modified element at index : " +arr.get(2));

        //Determining the size
        System.out.println("Size of the array : " + arr.getSize());

        //delete the element
       
        System.out.println("Enter the delete index : ");
        int index = input.nextInt();
        arr.delete(index);
        System.out.println("Size after the deleting element : "+ arr.getSize());

        //searching element
        
        System.out.println("Search element : ");
        int value = input.nextInt();
        System.out.println("Element :" +arr.search(value));

        //Traversing the array
        arr.traverse();


    }


}