/**
 * Created by HHUANG on 1/19/2017.
 */
public class APCS_501_TwoParts
{
    public static void main(String[] Theory)
    {
        System.out.println(factorials(4));
        System.out.println(GCDs(17,34));
    }

    public static int factorials(int value)
    {
        if (value>= 1)
            return value*factorials(value-1);
        return 1;
    }

    public static int GCDs(int a, int b)
    {
        if(b==0)
        {
            return a;
        }
        else
        {
            return GCDs(b, (a%b));
        }
    }



}
