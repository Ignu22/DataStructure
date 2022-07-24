import java.util.*;
public class InsertionSort{
    public static int[] insert(int[] arr){
        for(int i=1;i<arr.length-1;i++){
            int current =arr[i];
            int j=i-1;
            while(j>=0 && arr[j]> current){
                arr[j+1] =arr[j];
                j--;
            }
            arr[j+1] = current;
        }
        return arr;
    }
    public static void main (String[] args) {
        int[] arr={1,23,4,5,34,6,45};
        int[] result = insert(arr);
        Arrays.stream(result).forEach(System.out::println);
    }
}