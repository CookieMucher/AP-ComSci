/**
 * Created by Hank on 1/24/2017.
 */
public class APCS_502_SquareRoot
{
    private static int root = 81;
    public static void main(String[] Theory)
    {
        System.out.println(Calcuate(1));
    }

    public static double Calcuate(double guess)
    {
        if(Math.abs((root/guess)-guess)<0.00001)
        {
            return guess;
        }
        else
        {
            return Calcuate((guess + root/guess) / 2);
        }
    }
}
