import java.util.ArrayList;
import java.math.BigDecimal;
public class PrimeGen
{
    public static ArrayList<Long> primes = new ArrayList<Long>();
    public static void main(String[] args)
    {
        primes.add((long)2);
        primes.add((long)3);
        java.util.Scanner s = new java.util.Scanner(System.in);
        while(true)
        {
            System.out.print("\nPlease enter a number: ");
            long num =-1;
            if(s.hasNextLong())
            {
                num = s.nextLong();}
            else
            {
                continue;
            }
            if(num==-1)
            {
                System.exit(0);
            }
            long startTime = System.currentTimeMillis();
            growPrimes(num);
            for(long i = 0;i<=num;i++)
            {
                isPrime(i);
            }
            long endTime = System.currentTimeMillis();
            System.out.println(primes.size()+" primes found in "+((double) (endTime-startTime))/1000+" seconds.");
            System.out.print("Please enter \'all\' to view all or '10' to view the largest 10: ");
            String disp = s.next().toLowerCase();
            if(disp.compareTo("all")==0)
            {
                System.out.println(primes.toString());   
            }
            else if(disp.compareTo("10")==0)
            {
                for(int i = 10; i>0; i--)
                {
                    System.out.print(primes.get(primes.size()-i)+" ");
                }
            }
            System.out.println();
        }
    }

    public static void growPrimes(long number)
    {
        if(primes.get(primes.size()-1)<=number) //need to grow Array
        {
            for(long i = primes.get(primes.size()-1)+1; i< number; i++)
            {   
                if(isPrime(i))
                {
                    primes.add(i);
                }
            }
        }
    }

    public static boolean isPrime(long number)
    {
        boolean isPrime = true; // will be set to false if num isn't prime.
        long sqrtNum = (long) Math.pow(number, 0.5)+1;
        if(number%2==0)
        {
            return false; // No even numbers
        }
        for(int i=0; primes.get(i)<sqrtNum; i++)
        {
            if(number%primes.get(i)==0)
            {   
                return false;
            }
        }
        return true;
    }
}