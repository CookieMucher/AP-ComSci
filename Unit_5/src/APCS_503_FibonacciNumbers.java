/**
 * Created by Hank on 1/24/2017.
 */
public class APCS_503_FibonacciNumbers
{
    private static int count;

    public static void main(String[] Theory)
    {
        System.out.println(fib(8));
    }

    //  1 2 3 4 5 6 7  8  9  10
    //0 1 1 2 3 5 8 13 21 34 55
    public static int fib(int nth)
    {
        if(nth == 0)
            return 0;
        else if(nth == 1)
            return 1;
        else
            return fib(nth-1)+fib(nth-2);

    }
}
