import java.util.Random;
public class DrunkardWalk
{
    public static int x = 0;
    public static int y = 0;
    public static int BLOCK = 1;
    public static int ITER = 100000;
    public static void main(String[] args)
    {

        Random rnd = new Random();
        for(int i = 0; i<ITER; i++)
        {
            //0 = backwards, 1 = left, 2 = forward, 3 = right
            int dir = rnd.nextInt(4);        
            if(dir == 0)
            {
                x-=BLOCK;
            }
            else if(dir == 1)
            {
                y+=BLOCK;
            }
            else if(dir == 2)
            {
                x+=BLOCK;
            }
            else
            {
                y=+BLOCK;
            }
            
        }
        System.out.println("Final Position: "+x+", "+y+")");
    }
}