import java.math.*;
class Solution {
    public int integerReplacement(int n) {
        return convert(new BigInteger(Integer.toString(n)), 0);
    }
    
    public int convert(BigInteger n, int count) {
        if(n.equals(new BigInteger("1"))) {
            return count;
        }
        if(n.remainder(new BigInteger("2")).equals(new BigInteger("0"))) {
            return convert(n.divide(new BigInteger("2")), count + 1);
        } else {
            return Math.min(convert(n.add(new BigInteger("1")), count + 1), convert(n.subtract(new BigInteger("1")), count + 1));
        }
    }
}