import java.util.Scanner;

public class SubstringPrinter
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("String: ");
        String word = s.next();
        
        for (int i = 0; i < word.length(); i++)
        {
            for(int j = i; j <= word.length(); j++)
            {
                System.out.println(word.substring(i, j));
            }
        }
    }
}