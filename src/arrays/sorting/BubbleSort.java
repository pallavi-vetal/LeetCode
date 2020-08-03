package arrays.sorting;

public class BubbleSort {
    public static int[] sort(int arr[]){
        for(int i=0; i<arr.length;i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    public static void main(String args[]){
        int arr[] = new int[10];
        int temp = 10;
        for(int i=0;i<10;i++){
            arr[i] = temp;
            temp--;
        }
        System.out.println("Before Sorting");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        int res[] = sort(arr);
        System.out.println("\nAfter Sorting");
        for(int i=0;i<arr.length;i++)
            System.out.print(res[i]+" ");

    }
}
