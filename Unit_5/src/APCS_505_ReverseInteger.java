/**
 * Created by Hank on 1/24/2017.
 */
public class APCS_505_ReverseInteger {
    public static void main(String[] Theory)
    {
        System.out.println(reverseString("abcdefghijkl"));
        System.out.println(reverseInt(123456789));
    }
    public static int reverseInt(int n)
    {

        return Integer.parseInt(reverseString(Integer.toString(n)));

    }
    public static String reverseString(String s)
    {
        if(s.length()<=1)
            return s;
        else
            return reverseString(s.substring(1,s.length()))+s.charAt(0);
    }
}