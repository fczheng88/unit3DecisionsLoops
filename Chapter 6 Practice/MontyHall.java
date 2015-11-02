import java.util.Scanner;
import java.util.Random;
public class MontyHall
{
    public static void main(String[] args)
    {

        //user selects a door        
        Scanner s = new Scanner(System.in);
        //System.out.print("Welcome to the Monty Hall Tester!\nPlease enter a door number (1-3): ");

        Random rnd = new Random();
        int prizeDoor, usrDoor, goatDoor;
        boolean switchDoor;

        /*
        System.out.print("Do you want to switch yes/no: ");
        if(s.next().toLowerCase().compareTo("yes")==0)
        {
        switchDoor = true;
        }
        else
        {
        switchDoor = false;
        }
         */
        int sT, t;
        sT=t=0;
        int iter = 1000000000;
        for(int l = 0;l<iter;l++)
        {

            switchDoor = true;

            prizeDoor = rnd.nextInt(3); 
            usrDoor = rnd.nextInt(3); //s.nextInt()-1;      
            goatDoor = pickDoor(prizeDoor, usrDoor, rnd);
            if(answer(switchDoor, prizeDoor, usrDoor))
            {
                sT++;
            }
            
            switchDoor = false;
            prizeDoor = rnd.nextInt(3); 
            usrDoor = rnd.nextInt(3); //s.nextInt()-1;       
            goatDoor = pickDoor(prizeDoor, usrDoor, rnd);
            if(answer(switchDoor, prizeDoor, usrDoor))
            {
                t++;
                
            }
            
        }
        System.out.println("\nSwitched, Won: " + sT);
        System.out.println("Switched, Lost: " + (iter-sT));
        System.out.println("Unswitched, Won: " + t);
        System.out.println("Unswitched, Lost: " + (iter-t));
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
            return true;
        }
        else if(!switchDoor && prizeDoor == usrDoor)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}