public class StringCompare
{
    public static void main(String[] args)
    {
        String word1 = "catalog";
        String word2 = "cat";
        
        if(word1.compareTo("aaa")>0)
        {
            System.out.println("1");
        }
        if(word1.compareTo(word2)==0)
        {
            System.out.println("yaay");
        }
        if(word1.compareTo(word2)<0)
        {
            System.out.println("lessthan");
        }
        if(word1.substring(0,3).compareTo(word2.substring(0,3))==0)
        {
            System.out.println("3letterprefix");
        }
    }

}