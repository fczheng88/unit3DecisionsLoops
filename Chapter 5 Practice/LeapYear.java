import java.util.Scanner;
public class LeapYear
{
    public static void main(String[] args)
    {

        Scanner s = new Scanner(System.in);

        while(true)
        {
            System.out.print("Enter a year: ");
            int year = s.nextInt();

            System.out.println("\n\nThe year " + year+ " is a leap year: " + isLeapYear(year));
        }
    }

    public static boolean isLeapYear(int year)
    {
        return ((year>=1582 && (year%100!=0 || year%400==0) || (year<1582)) && year%4==0);
    }
}
