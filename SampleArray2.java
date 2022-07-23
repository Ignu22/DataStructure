import java.util.HashSet;
import java.util.Set;

public class SampleArray2{

    public static int[] sum(int[] array, int target) {
        
        Set<Integer> nums=new HashSet<>();
        for(int i=0;i<array.length;i++){
            int num = array[i];
            int match = target - num;
            if(nums.contains(match)){
                return new int[]{num,match};
            }
            else{
                nums.add(num);
            }

        }
        
            
        
        return new int[0];
    }


    public static void main(String[] args) {
      
        int[] array ={6,5,7,9,4,0,2};
        int target =10;
        int[] result = sum(array,target);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}