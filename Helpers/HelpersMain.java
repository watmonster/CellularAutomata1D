package Helpers;

import java.math.BigInteger;
import java.util.Arrays;

public class HelpersMain {
    public static void main(String[] args){
        int[] result = BaseNtoBase10.b10tobN(BigInteger.valueOf(13),3);
        System.out.println(Arrays.toString(result));
        BigInteger result2 = BaseNtoBase10.bNtob10(result, 3);
        System.out.println(result2.intValue());
    }
}//Arrays.toString(list.toArray())