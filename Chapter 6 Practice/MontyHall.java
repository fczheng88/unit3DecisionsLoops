import java.util.Scanner;
import java.util.Random;
public class MontyHall
{
    public static void main(String[] args)
    {
        //door int array. index 0= door 1 and so 
        int prizeDoor;
        
        Random rnd = new Random();
        prizeDoor = rnd.nextInt(3);      
        
        System.out.println("prizeDoor" + (prizeDoor+1));
        //user selects a door        
        Scanner s = new Scanner(System.in);
        System.out.print("Welcome to the Monty Hall Tester!\nPlease enter a door number (1-3): ");
        
        int usrDoor = -1;
        if(s.hasNextInt())
        {
            usrDoor=s.nextInt()-1;
        }
        int goatDoor = pickDoor(prizeDoor, usrDoor, rnd);
        System.out.println("goatDoor"+(goatDoor+1));
        boolean switchDoor;
        System.out.print("Do you want to switch yes/no: ");
        if(s.next().toLowerCase().compareTo("yes")==0)
        {
            switchDoor = true;
        }
        else
        {
            switchDoor = false;
        }
        
        System.out.println(answer(switchDoor, prizeDoor, usrDoor));
    }
    public static int pickDoor(int prizeDoor, int usrDoor, Random rnd)
    {
        while(true)
        {
            int rndPick = rnd.nextInt(3);
            if(usrDoor != rndPick && prizeDoor != rndPick)
            {
                return rndPick;
            }
        }
    }
    public static boolean answer(boolean switchDoor, int prizeDoor, int usrDoor)
    {
        if(switchDoor && prizeDoor != usrDoor)
        {
            System.out.println("switched");
            return true;
        }
        else if(!switchDoor && prizeDoor == usrDoor)
        {
            System.out.println("notSwitched");
            return true;
        }
        else
        {
            return false;
        }
    }
}