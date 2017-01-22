/**
 * Created by Hank on 9/1/2016.
 */
import java.util.Scanner;
public class APCS_004_Euler
{
}
class Tester_e
{
    public static void main(String[] Theory)
    {
        
        Scanner keyboard = new Scanner(System.in);
        
        //Get how many iteration the user wants 
        System.out.println("How accurate do you want to be?");
        int acc = keyboard.nextInt();
        
        //Creat an instance of Random_e called tester 
        Random_e tester = new Random_e(acc);
        
        //Get the value after the math 
        tester.getValue();
    }
}

class Random_e
{
    
    //initialize global variable
    double e;

    Random_e( int acc)
    {
        //initialize variable
        int count=0, total=0, a=acc;
        double sum = 0, t=1;

        //while loop of how many iteration the user want
        while (t<a)
        {
            //the second step of algorithmhe
            while(sum < 1)
            {
                //get a random number 
                double rand = Math.random();
                
                //add the random numbers together and see if it is bigger than 1
                sum += rand;
                
                //count up how many times this happens
                count++;
            }
            
            //the sum of how many times it has gone through step 2 
            total += count;
            
            //reset the counters
            sum =0;
            count=0;
            
            //update the loop
            t++;
        }
        //takes the average of how many times it has gone through step 2
        e=total/t;
    }

    public void getValue()
    {
        
        //prints out e when called
        System.out.println(e);
    }
}



