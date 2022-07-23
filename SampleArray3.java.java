class SampleArray3{

    public static int[] move(int[] array, int target){
        int i=0;
        int j=array.length-1;
        while(i<j){
            if(array[i]!=target){
                i++;
            }
            if(array[j]==target){
                j--;
            }
            if(array[i]==target && array[j]!=target){
                int temp =array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        return array;


    }


    public static void main(String[] args) {
        int[] array={6,5,4,6,7,8,5,6,6,4,5,6};
        int target=6;
        int[] result= move(array,target);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }



}