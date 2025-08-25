public class ArrayExample{
    public static boolean isSortedAscending(int[] arr){
        for (int i=0; i <arr.length-1; i++){
            if(arr[i] > arr[i+1])
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {5,4,3,2,1};
        int[] arr3 = {9};
        int[] arr4 = {};

        System.out.println("Array 1 is sorted inascending order : "+ isSortedAscending(arr1));
        System.out.println("Array 2 is sorted inascending order : "+ isSortedAscending(arr2));
        System.out.println("Array 3 is sorted inascending order : "+ isSortedAscending(arr3));
        System.out.println("Array 4 is sorted inascending order : "+ isSortedAscending(arr4));
       
    }


}