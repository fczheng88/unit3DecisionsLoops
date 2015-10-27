import java.util.Scanner;

public class PromptUntilMatch
{
    public static double promptUntilMatch()
    {
        boolean valid = false;
        Scanner s = new Scanner(System.in);
        double input;
        
        do
        {
            System.out.print("Enter a positive value < 100: ");
            input = s.nextDouble();
            if(input>0&&input<100)
            {
                valid = true;
            }
        }
        while(!valid);
        return input;
    }
}