public class BinarySearch{
    public static int Binary(int[] arr, int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int middle = start +(end - start)/2;
            if(arr[middle]==target){
                return middle;
            }else if (arr[middle] > target){
                end=middle-1;
            }else if(arr[middle] < target){
                start=middle+1;
            }
        }
        return -1;
    }
    public static void main (String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        System.out.println(Binary(arr,4));
    }
}