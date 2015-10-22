import java.util.Scanner; 

public class Spectrum
{
    public static void main(String[] args)
    {
    
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter a wavelenth: ");
        float wavelength = s.nextFloat();
        
        Spectrum spec = new Spectrum();
        
        System.out.println("A wave with a wavelength of "+ wavelength +" is a " + spec.waveType(wavelength) + " and has a frequency of " + spec.toHz(wavelength) + " Hz.");
        
        
            
    }
    public float toHz(float wavelength)
    {
        return 299792458/wavelength;
    }
    public String waveType(float wavelength)
    {
        if(wavelength > 1e-1)
        {
            return "Radio Wave";
        }
        else if(wavelength > 1e-3)
        {
            return "Microwave";
        }
        else if(wavelength > 7*1e-7)
        {
            return "Infrared Wave";
        }
        else if(wavelength > 4*1e-7)
        {
            return "Visible Light Wave";
        }
        else if(wavelength > 1e-8)
        {
            return "Ultraviolet Wave";
        }
        else if(wavelength > 1e-11)
        {
            return "X-rays";
        }
        else
        {
            return "Gamma Ray";
        }
    }
}