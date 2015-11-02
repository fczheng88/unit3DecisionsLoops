
public class FibonacciNumbers
{
    public static void main(String[] args)
    {
        java.util.Scanner s = new java.util.Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = s.nextInt();
        int fold1=0;
        int fold2=1;
        int foldN = 0;
        if(n==0)
        {
            foldN = 0;
        }
        else if(n==1)
        {
            foldN = 1;
        }
        else{
            for(int i=0; i<=n; i++)
            {
                foldN = fold1+fold2;
                fold1 = fold2;
                fold2 = foldN;
            }
        }
        System.out.println(foldN);
    }
}