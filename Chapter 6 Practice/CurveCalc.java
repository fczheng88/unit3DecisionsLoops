import java.awt.geom.Point2D;
public class CurveCalc
{
    public double A, B, C, xL, xR, yT, yB, boxArea, progress;
    public double EPS = 0.000001;
    String loadingBar = "";

    public CurveCalc(double A, double B, double C, double xL, double xR)
    {
        this.A = A;
        this.B = B;
        this.C = C;

        this.xL = xL;
        this.xR = xR;
    }

    public double func(double x)
    {
        return (A*x*x)+(B*x)+C;
    }

    public double derivCalc(double x)
    {
        return 2*A*x+B;
    }

    public boolean isAPositive()
    {
        if(A > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Point2D findExtrema()
    {

        Point2D vx = new Point2D.Double((0.0-B)/(2.0*A), func((0.0-B)/(2.0*A)));

        return vx;
    }
    //case 1: opens upwards, vertex below x
    //case 2: opens upwards, vertex above x
    //case 3: opens downwards, vertex below x
    //case 4: opens downwards, vertex above x
    public void boundaryCalc()
    {
        if(findExtrema().getY() < 0)
        {
            if(isAPositive())
            { //case 1
                yB = findExtrema().getY();
                if(func(xL) > func(xR))
                {
                    yT = func(xL);
                }
                else
                {
                    yT = func(xR);
                }
            }
            else
            { //case 3
                yT = 0;
                if(func(xL) < func(xR))
                {
                    yB = func(xL);
                }
                else
                {
                    yB = func(xR);
                }                
            }
        }
        else if(findExtrema().getY() > 0)
        {
            if(isAPositive())
            { //case 2
                yB = 0;
                if(func(xL) > func(xR))
                {
                    yT = func(xL);
                }
                else
                {
                    yT = func(xR);
                }
            }
            else
            { //case 4
                yT = findExtrema().getY();
                if(func(xL) < func(xR))
                {
                    yB = func(xL);
                }
                else
                {
                    yB = func(xR);
                }
            }
        }
        else if(Math.abs((findExtrema().getY()-0))<=EPS)
        {
            if(isAPositive())
            {
                yB = 0;
                if(func(xL) > func(xR))
                {
                    yT = func(xL);
                }
                else
                {
                    yT = func(xR);
                }
            }
            else
            {
                yT = 0;
                if(func(xL) < func(xR))
                {
                    yB = func(xL);
                }
                else
                {
                    yB = func(xR);
                }
            }
        }
        boxArea = Math.abs(xL-xR)*Math.abs(yT-yB);
    }

    public boolean isUnder(double x, double guessed)
    {
        double y = func(x);
        if(y>0&&guessed<y&&guessed>0)
        {
            return true;
        }
        else if(y<0&&guessed>y&&guessed<0)
        {
            return true;           
        }
        return false;
    }

    public double randGen(java.util.Random rnd, boolean isX)
    {
        if(isX)
        {
            return (rnd.nextDouble()*Math.abs(xL-xR)+xL);
        }
        else
        {
            return (rnd.nextDouble()*Math.abs(yT-yB)+yB);
        }
    }

    public void loadingBar(double cur, double total)
    {
        progress = cur/total;
        if((int)(progress*100)%2==0)
        {
            if(loadingBar.length()<(int)(progress*50))
            {
                loadingBar+="=";
                String spaces="";
                for(int i = 0;i<50-loadingBar.length();i++)
                {
                    spaces+=" ";
                }
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Progress: ["+loadingBar+spaces+"]");
            }
        }

    }

    public void runSim(int points)
    {
        double total = 0;
        double within = 0;
        double rndX, rndY;
        java.util.Random rnd = new java.util.Random();
        System.out.println("Progress: [                                                  ]");
        while(total<=points)
        {
            rndX = randGen(rnd, true);
            rndY = randGen(rnd, false);
            if(isUnder(rndX, rndY))
            {
                within++;
            }
            total++;
            loadingBar((double)total,(double)points);
        }
        System.out.println("The area under the curve is: "+(within/total)*boxArea);
    }
}