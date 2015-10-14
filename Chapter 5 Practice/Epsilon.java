import java.util.*;
public class Epsilon{
    public static final double EPS = 1e-14;
    public static void main(String[] args)
    {
        Epsilon thingy = new Epsilon();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter a floating point number: ");
        double i=0;
        try
        {
            i = sc.nextDouble();
        }
        catch(InputMismatchException e)
        {
            System.out.println("\n\nInvalid input\n\n");
            
            thingy.main(new String[] {});
        }
        if(i == -1)
        {
            System.out.println("The program will exit.");
            System.exit(0);
        }
        String adj = "";
        if(Math.abs(i) < 1.0)
        {
            adj = "small";
        }
        else if(Math.abs(i) > 1000000)
        {
            adj = "large";
        }
        
        if(Math.abs(i-0) < EPS)
        {
            System.out.println("It's a zero!");
        }
        else if(i>0)
        {
            System.out.println("It's a "+adj+" positive number.");
        }
        else
        {
            System.out.println("It's a "+adj+" negative number.");
        }
        thingy.main(new String[] {});
    }
}