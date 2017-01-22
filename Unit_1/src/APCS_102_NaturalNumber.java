/**
 * Created by Hank on 9/23/2016.
 */
import java.util.Scanner;
public class APCS_102_NaturalNumber
{
}

class Tester1
{
    public static void main(String[] Theory)
    {
        NaturalNumber number = new NaturalNumber();
        System.out.println(number.toString());

        int x = 134649;
        number = new NaturalNumber(x);
        System.out.println(number.toString());

        String y = "21315669489798794164979546489655649879794646799879879";
        number = new NaturalNumber(y);
        number.increment();
        System.out.println(number.toString());
        number.decrement();
        System.out.println(number.toString());

    }
}
class NaturalNumber
{
    private int NatNum;
    private String BigNatNum;

    public NaturalNumber()
    {
        NatNum = 0;
        BigNatNum = "0";
    }

    public NaturalNumber(int x)
    {
        NatNum = x;
    }

    public NaturalNumber(String y)
    {
        BigNatNum = y;
    }

    public void increment()
    {
        int length = BigNatNum.length();

        //initialize variable
        int counter = 0, counter2, i;
        String tail = BigNatNum.substring(length-1,length);

        //checks if there are trailing 9s, if so keep going to find a number that is not 9
        for (i = 1; tail.equals("9"); i++)
        {
            tail = BigNatNum.substring(length-i-1, length-i);
            counter++;
        }

        //calculating the place from the left
        counter2 = length - counter -1;

        //after finding a number in the system that is not a 9 add one to it
        int tailNum = Integer.parseInt(tail);
        tailNum++;
        String newTail = Integer.toString(tailNum);

        //change the trailing 9s to 0s
        while(counter>0)
        {
            newTail+="0";
            counter--;
        }
        //cut out the tail so it can be replaced
        BigNatNum = BigNatNum.substring(0,counter2) + newTail;
    }

    public void decrement()
    {
        if (!BigNatNum.equals("0"))
        {
            int length = BigNatNum.length();

            //initialize variable
            int counter = 0, counter2, i;
            String tail = BigNatNum.substring(length-1,length);

            //checks if there are trailing 9s, if so keep going to find a number that is not 9
            for (i = 1; tail.equals("0"); i++)
            {
                tail = BigNatNum.substring(length-i-1, length-i);
                counter++;
            }

            //calculating the place from the left
            counter2 = length - counter -1;

            //after finding a number in the system that is not a 9 add one to it
            int tailNum = Integer.parseInt(tail);
            tailNum--;
            String newTail = Integer.toString(tailNum);

            //change the trailing 0s to 9s
            while(counter>0)
            {
                newTail+="9";
                counter--;
            }
            //cut out the tail so it can be replaced
            BigNatNum = BigNatNum.substring(0,counter2) + newTail;
        }
    }
    public String toString()
    {
        return "Fist number:"+Integer.toString(NatNum)+"\nBig Number:"+BigNatNum;
    }
}
