
/**
 * Created by Hank on 9/23/2016.
 */

public class Test_Space
{
    public static void main (String[] Theory)
    {
        String BigNatNum = "57890000000000000000";
        System.out.println(BigNatNum);

        int length = BigNatNum.length();
        //initialize variable
        int counter = 0, counter2 = 1, i;
        String tail = BigNatNum.substring(length-1,length);

        //checks if there are trailing 9s, if so keep going to find a number that is not 9
        for (i = 1; tail.equals("0"); i++)
        {
            tail = BigNatNum.substring(length-i-1, length-i);
            counter++;
        }

        //calculating the place from the left
        counter2 = length - counter -1 ;

        //after finding a number in the system that is not a 9 add one to it
        int tailNum = Integer.parseInt(tail);
        tailNum--;
        String newTail = Integer.toString(tailNum);

        //change the trailing 9s to 0s
        while(counter>0)
        {
            newTail+="9";
            counter--;
        }
        //cut out the tail so it can be replaced
        BigNatNum = BigNatNum.substring(0,counter2) + newTail;

        System.out.println(BigNatNum);
    }

}
