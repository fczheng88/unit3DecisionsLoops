public class NestedLoops
{
    public static void main(String[] args)
    {
        for(int i = 1; i < 3; i++)
        {
            for(int r = 1; r < 5; r++)
            {
                System.out.println(i + " " + r);

            }        
        }
        int i = 1;
        while(i<3)
        {
            int r = 1;
            while(r<5)
            {
                System.out.println(i + " " + r);
                r++;
            }
            i++;
        }
        
        i = 1;
        do
        {
            int r = 1;
            do
            {
                System.out.println(i + " " + r);
                r++;
            }
            while(r<5);
            i++;
        }
        while(i<3);
    }
    
}