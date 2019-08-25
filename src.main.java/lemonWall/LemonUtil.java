package lemonWall;

public class LemonUtil {

    public static boolean isBlank(String str){
        return str == null?true:str.length()==0?true:false;
    }

    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }

}
