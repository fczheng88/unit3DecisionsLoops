import java.util.Scanner;
public class Diamond
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter the side length: ");
        int diag = s.nextInt();
        
        int height = diag*2-1;
        for(int i = 1; i<=height; i++)
        {
            System.out.println(splats(i, height));
        }
    
    }
    public static String splats(int iter, int height)
    {
        String splats = "";
        String spaces = "";
        if(iter<=height/2+1)
        {
            for(int i =0;i<iter*2-1;i++)
            {
                splats+="*";
            }
        }
        else
        {
            for(int i=0;i<=(height-iter+1)*2-1;i++)
            {
                splats+="*";
            }
        }
        for(int i=0;i<(height-splats.length())/2;i++)
        {
            spaces+=" ";
        }
        return spaces+splats;
    }



}