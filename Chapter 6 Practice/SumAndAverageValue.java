public class SumAndAverageValue
{
    public static double averageOfInputs()
    {
        java.util.Scanner s = new java.util.Scanner(System.in);
        System.out.println("Enter a series of numbers and type a letter to quit.");
        double total=0;
        int count = 0;
        
        while(s.hasNextDouble())
        {
            total += s.nextDouble();
            count ++;        
        }
        
        if(count!=0)
        {
            return total/count;
        }
        return 0;
    }
}