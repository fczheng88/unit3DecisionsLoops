import java.util.Scanner;

public class CircleOverlap
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        while(true)
        {
            System.out.print("Input the radius of the first circle: ");
            double radius1 = in.nextDouble(); 
            if(radius1==-1)
            {
                System.exit(0);
            }
            System.out.print("Input the x of the first circle: ");
            double xcenter1 = in.nextDouble();
            System.out.print("Input the y of the first circle: ");
            double ycenter1 = in.nextDouble();

            System.out.print("Input the radius of the second circle: ");
            double radius2 = in.nextDouble(); 
            System.out.print("Input the x of the second circle: ");
            double xcenter2 = in.nextDouble();
            System.out.print("Input the y of the second circle: ");
            double ycenter2 = in.nextDouble();

            // Your work goes here

            //Overlapping:
            double ctrDistance = Math.pow((Math.pow(xcenter1-xcenter2, 2)+Math.pow(ycenter1-ycenter2, 2)), 0.5) ;
            System.out.println("centerdistance: "+ctrDistance);
            //mutually contained
            if(xcenter1==xcenter2&&ycenter1==ycenter2)
            {
                //concentric
                System.out.print("The circles are concentric and");
                if(radius1> radius2)
                {
                    System.out.println("cirlce 1 is larger than circle 2");
                }
                else if(radius2>radius1)
                {
                    System.out.println("circle 2 is larger than circle 1");
                }
                else
                {
                    System.out.println("the circles overlap");
                }

            }
            else if(ctrDistance >= radius1+radius2)
            {
                //Disjoint, not concentric
                System.out.print("The circles are disjoint");
                if(ctrDistance == radius1+radius2)
                {
                    System.out.print(", are tangent,");
                }
                if(ycenter1==ycenter2)
                {
                    System.out.println(" and are on the same horizontal axis.");
                }
                else if(xcenter1==xcenter2)
                {
                    System.out.println(" and are on the same vertical axis.");
                }
                else
                {
                    System.out.println(" and are not share a common axis.");
                }
            }
            else if(radius1 > ctrDistance+radius2 || radius2>ctrDistance+radius1)
            {
                //Not disjoint, not concentric, mutually contained?
                System.out.print("The circles are mutually contained and");
                if(radius1>radius2)
                {
                    System.out.println("circle 1 is larger than circle 2.");
                }
                else
                {
                    System.out.println("circle 2 is larger than circle 1.");
                }

            }
            else if(radius1 == ctrDistance+radius2 || radius2 == ctrDistance+radius1)
            {
                //Not disjoint, not concentric, mutually possible mutually contained, possibly tangent??
                System.out.print("The circles are mutually contained, tangent, and");
                if(radius1>radius2)
                {
                    System.out.println("circle 1 is larger than circle 2.");
                }
                else
                {
                    System.out.println("circle 2 is larger than circle 1.");
                }

            }
            else
            {
                System.out.print("The circles are overlapping");
                if(ctrDistance == radius1+radius2)
                {
                    System.out.print(", are tangent,");
                }
                if(ycenter1==ycenter2)
                {
                    System.out.println(" and are on the same horizontal axis.");
                }
                else if(xcenter1==xcenter2)
                {
                    System.out.println(" and are on the same vertical axis.");
                }
                else
                {
                    System.out.println(" and are not share a common axis.");
                }
            }
        }
    }
}
