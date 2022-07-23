public class Encrypt{
    public static String change(String str, int key){
        int newKey = key % 26;
        char[] chararray = new char[str.length()];
        
        for(int i=0;i<str.length();i++){
            int position = str.charAt(i) + newKey;
            
            if(position<=122){
                chararray[i] = (char) position;
            }else{
                chararray[i]= (char) (96+position%122);
            }
        }return new String(chararray);
    }
    public static void main (String[] args) {
        String value = "Hai";
        System.out.println(change(value,2));
;    }
}