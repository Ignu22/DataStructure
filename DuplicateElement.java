import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateElement
{
    public static boolean Duplicate(int[] arr){
        Set<Integer> check = new HashSet<>();
        for(int j: arr){
            if(check.contains(j)){
                return true;
            }else{
                check.add(j);
            }
        }return false;
    } 

	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		int a =s.nextInt();
		int[] arr=new int[a];
		for(int i=0;i<a;i++){
		    arr[i]=s.nextInt();
		}
		boolean res = Duplicate(arr);
		System.out.println(res);
	}
}
