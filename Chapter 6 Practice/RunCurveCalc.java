
/**
 * Write a description of class RunCurveCalc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RunCurveCalc
{
    public static void main(String[] args)
    {
        java.util.Scanner s = new java.util.Scanner(System.in);
        System.out.println("Let f(x)=Ax^2 + Bx + c");
        System.out.print("A: ");
        double A = s.nextDouble();
        System.out.print("B: ");
        double B = s.nextDouble();
        System.out.print("C: ");
        double C = s.nextDouble();
        System.out.print("From: ");
        double L = s.nextDouble();
        System.out.print("To: ");
        double R = s.nextDouble();
        System.out.print("Trials (10^?): ");
        double T = s.nextDouble();
        
        CurveCalc curve = new CurveCalc(A,B,C,L,R);
        curve.boundaryCalc();
        System.out.println(curve.func(-0.75));
        curve.runSim((int)Math.pow(10.0, T));
    
    }
}
