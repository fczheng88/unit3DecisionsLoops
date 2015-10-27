public class FindFistSpace
{
    public static int findFirstSpace(String str)
    {
        
        for(int i=0; i<str.length(); i++)
        {   
            char ch = str.charAt(i);
            if(' ' == str.charAt(i))
            {
                return i;
            }
        }
        return -1;
    }
}