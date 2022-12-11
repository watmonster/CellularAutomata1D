package Helpers;

import java.math.BigInteger;

public class BaseNtoBase10 {
    public static BigInteger bNtob10(int[] bNlist, int base) {
        // BigInteger bigIntN = BigInteger.valueOf(n);
        int numDigits = (int) Math.pow((double) base, 3);
        BigInteger total = BigInteger.valueOf(0);
        for (int i = 0; i < numDigits; i++) {
            BigInteger bigIntN = BigInteger.valueOf(base);
            BigInteger placeValue = bigIntN.pow((numDigits - 1) - i);
            BigInteger iDigit = BigInteger.valueOf(bNlist[i]);
            total = total.add(iDigit.multiply(placeValue));
        }
        return total;
    }

    public static int[] b10tobN(BigInteger b10num, int base){
        int numDigits = (int) Math.pow((double) base, 3);
        int[] bNnum = new int[numDigits]; //in java, ints are automatically 0s
        BigInteger remaining = b10num;
        for(int i = numDigits-1; i > -1; i--){
            int thisdigit = remaining.mod(BigInteger.valueOf(base)).intValue();
            bNnum[i] = thisdigit;
            remaining.subtract(BigInteger.valueOf(thisdigit));
            remaining = remaining.divide(BigInteger.valueOf(base));
        }
        return bNnum;
    }
}
