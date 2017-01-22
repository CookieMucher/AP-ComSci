/**
 * Created by Hank on 10/20/2016.
 */
public class APCS_202_Sieve
{
    public static void main(String[] theory)
    {
        Sieve thing = new Sieve();

        boolean[] numbers = new boolean[130];

        thing.sieve(numbers);
        thing.chart(numbers);
    }

}

class Sieve
{

    public void sieve(boolean[] numbers)
    {
        int[] list = new int[numbers.length];
        int elements = 2;
        //filling the array with numbers stating from 2
        for(int i = 0; i<numbers.length; i++)
        {
            list[i] = elements;
            elements++;
        }

        int maxDiv = (int) Math.sqrt(numbers.length)+1;

        //find the multiples
        //cycle through all the divisors stating with 2
        for(int j=2; j<maxDiv; j++)
        {
            //cycles through all the elements in the array
            //-j to avoid out of bounds
            for (int k=0; k<numbers.length-j; k++)
            {
                //check if element is divisible
                //adding j to avoid the divider itself
                if(list[k+j]%j==0)
                {
                    numbers[k+j] = true;
                }
            }
        }

    }
    public void chart(boolean[] numbers)
    {
        int[] list = new int[numbers.length];
        int elements = 2;
        //filling the array with numbers stating from 2
        for(int i = 0; i<numbers.length; i++)
        {
            list[i] = elements;
            elements++;
        }

        int count =0;
        String temp="";
        String toPrint ="";

        //cycle through all elements of the boolean list "numbers"
        for(int x=0; x<numbers.length; x++)
        {
            //if numbers[pos] is false add to it to temp
            if(!numbers[x])
            {
                temp = temp+" "+list[x];
                count++;
            }
            //if 8 elements has been add to temp
            //add temp to a master string and set temp and count to 0
            if(count == 8)
            {
                toPrint = toPrint+temp+"\n";
                temp ="";
                count=0;
            }
        }
        // checks if there are left overs
        if(count<8)
        {
            toPrint = toPrint+temp+"\n";
        }
        //prints out primes
        System.out.println(toPrint);
    }
}
