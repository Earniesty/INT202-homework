package sit.int202.classicmodelfri;

public class CheckParam {
    public static boolean isValidString(String [] stringArr){
        for (int i = 0; i < stringArr.length; i++){
            if(stringArr[i] == null || stringArr[i].isEmpty()){
                return false;
            }
        }
        return true;
    }
}