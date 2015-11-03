import java.util.Random;
public class MonteCarlo
{
    public static void main(String[] args)
    {
        final int TRIES = 1000000000;
        Random gen = new Random();
        int hits = 0;
        for(int i = 1; i <= TRIES; i++)
        {
            double r = gen.nextDouble();
            double x = -1+2*r;
            r = gen.nextDouble();
            double y = -1+2*r;
            if((x*x)+(y*y)<=1)
            {
                hits++;
            }
            
        }
        double piEstimate=4.0*hits/TRIES;
        System.out.println("The estimate for pi is: " + piEstimate);
    }
}