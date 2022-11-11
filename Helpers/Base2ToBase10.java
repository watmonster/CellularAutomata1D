package Helpers;

public class Base2ToBase10 {
    public static int zeroOne(char zo){
        if(zo == '0'){
            return 0;
        }else{
            return 1;
        }
    }

    public static int b2tb10(int[] b2list){
        int total = 0;
        for(int i = 0; i < 8; i++){
            //System.out.println(zeroOne(b2str.charAt(i))*(Math.pow(2,7-i)));
            total += (b2list[i]*(Math.pow(2,7-i)));
        }
        return total;
    }
}
