package Helpers;

public class Base10ToBase2{
    public static String addzeros(String str){
        if(str.length() == 0){
            return "00000000";
        }else if(str.length() == 1){
            return "0000000"+str;
        }else if(str.length() == 2){
            return "000000"+str;
        }else if(str.length() == 3){
            return "00000"+str;
        }else if(str.length() == 4){
            return "0000"+str;
        }else if(str.length() == 5){
            return "000"+str;
        }else if(str.length() == 6){
            return "00"+str;
        }else if(str.length() == 7){
            return "0"+str;
        }else{
            return str;
        }
    }
    public static String toBinaryString(Integer b10int){
        return addzeros(Integer.toBinaryString(b10int));
    }
}