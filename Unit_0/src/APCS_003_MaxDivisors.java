/**
 * Created by Hank on 9/1/2016.
 */
import javax.swing.*;

public class APCS_003_MaxDivisors
{
}

class MaxDivisor
{
    private int number;       // One of the integers whose divisors we have to count
    private int maxDivisors;  //  Maximum number of divisors seen so far
    private int numWithMax;   //   A value of N that had the given number of divisors

    MaxDivisor()
    {
        String inputNumber = JOptionPane.showInputDialog(null, "Enter a number : ","Input", 1);
        number = Integer.parseInt(inputNumber);

        /** you can replace JOptionPane with scanner if you prefer.
         * It's just a popup window similar to a javascript alert
         */
    }

    // Determines which number (up to and including number)
    //has the the most divisors

    public void findMaxDivisor()
    {
        int count=0;
        maxDivisors = 0;

        for (int i=number; i>=1; i--)
        {

            for (int divider=i; divider > 0; divider--)
            {
                if (i%divider==0)
                {
                    count++;
                }
            }
            if (count > maxDivisors)
            {
                numWithMax = i;
                maxDivisors = count;
            }
            count=0;
        }
    }

    public void display()
    {
        JOptionPane.showMessageDialog(null, "The number with the most divisors is "+numWithMax, "Output", 1);


        /** You can replace this with scanner as well  */
    }
}

class DivisorTester
{
    public static void main (String[] Theory)
    {
        /**TODO:
         * 1 - Create a MaxDivisor instance
         * 2 - Prompt the user for a test number
         * 3 - Call the findMaxDivisor method to do the math
         * 4 - Call the display method to show the results
         **/

        MaxDivisor thing= new MaxDivisor();
        thing.findMaxDivisor();
        thing.display();

    }
}