/** Microsoft */
package misc;


public class SearchInRotatedArray {
    public static int search(int arr[],int key){
        int pivot = findPivot(arr);
        System.out.println("pivot: "+pivot);
        if(pivot==-1)
            binarySearch(arr,0,arr.length-1,key);
        if(arr[pivot]==key)
            return pivot;
        if(arr[0] > key)
            return binarySearch(arr,0,pivot-1,key);

        return binarySearch(arr,pivot+1,arr.length-1,key);
    }
    private static int binarySearch(int arr[],int low,int high,int key){
        if(high < low)
            return -1;
        int mid = (high+low)/2;
        if(arr[mid]==key)
            return mid;
        if(arr[mid]>key)
            return binarySearch(arr,0,mid,key);
        return binarySearch(arr,mid+1,high,key);
    }
    private static int findPivot(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1])
                return i;
        }
        return -1;
    }

    public static void main(String args[]){
        int input[] = {1,2,3,7,4,5};
        System.out.println(search(input,7));
    }
}
