import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
public class RandomPrime
{
    public static void main(String arg[])
    {
        Random ran = new SecureRandom();
        BigInteger a = BigInteger.probablePrime(20, ran);
        int b = a.intValue();
        System.out.println(b);
    }
}