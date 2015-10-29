import java.util.Scanner;

public class SubstringPrinter
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("String: ");
        String word = s.next();
        /*
        for (int i = 0; i < word.length(); i++)
        {
            for(int j = i+1; j <= word.length(); j++)
            {
                System.out.println(word.substring(i, j));
            }
        }
        */
        for(int i = 1; i<=word.length();i++)
        {
            for(int j = 0; j<=word.length()-i; j++)
            {
                System.out.println(word.substring(j, j+i));
            }
        }
    }
}