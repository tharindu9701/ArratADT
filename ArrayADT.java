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
            if(i==0)
            System.out.print("Array : ["+array[i]+",");
            else if(i==size-1)
            System.out.print(array[i]+"]");
            else 
            System.out.print(array[i]+",");
        }
        System.out.println();
    }

    // intersection of two arrays

    public void intersection(int arr1[], int arr2[]){

        ArrayADT result = new ArrayADT(5);
        for(int i=0; i < arr1.length; i++){
            for(int j=0; j < arr2.length; j++){
                if (arr1[i] == arr2[j]){
                    result.insert(result.size, arr1[i]);
                }
            }
        }result.traverse();
    }

    public static void main(String args[]){
        ArrayADT arr1 = new ArrayADT(5);
        ArrayADT arr2 = new ArrayADT(5);

        Scanner input = new Scanner(System.in);


        // inserting elements
        System.out.println("Enter the elements for the first array : ");
        for(int i=0; i <= arr1.array.length-1;i++){
            System.out.print((i+1) + " element - ");
            int value = input.nextInt();
            arr1.insert(i,value);
        }
        System.out.println("Enter the elements for the second array : ");
        for(int i=0; i <= arr2.array.length-1;i++){
            System.out.print((i+1) + " element - ");
            int value = input.nextInt();
            arr2.insert(i,value);
        }

        //accessing and modifying
        /*System.out.println("Element at index 2: "+arr1.get(2));
        arr1.set(2,9);
        System.out.println("Modified element at index : " +arr1.get(2));
1
        //Determining the size
        System.out.println("Size of the array : " + arr1.getSize());

        //delete the element
       
        System.out.println("Enter the delete index : ");
        int index = input.nextInt();
        arr1.delete(index);
        System.out.println("Size after the deleting element : "+ arr1.getSize());

        //searching element
        
        System.out.println("Search element : ");
        int value = input.nextInt();
        System.out.println("Element :" +arr1.search(value));*/

        //Traversing the array
        arr1.traverse();
        arr2.traverse();

        //intersection of two arrays
        System.out.print("Intersection of two arrays : ");
        arr1.intersection(arr1.array,arr2.array);


    }


}