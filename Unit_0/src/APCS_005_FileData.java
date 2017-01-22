/**
 * Created by Hank on 9/3/2016.
 */

import java.io.*;
import java.util.*;
public class APCS_005_FileData
{
    public static void main(String[] Theory) throws IOException
    {
        //initialize variable
        int count=0;
        double average=0, variance=0, StaDev;
        
        //create an arry to put in all the data 
        ArrayList<Integer> array = new ArrayList<Integer>();
        Scanner keyboard = new Scanner(System.in);

        //have the user select the file by name 
        System.out.println("Enter File Name");
        String name = keyboard.nextLine();
        
        //create a Scanner to read the file 
        File temp = new File(name);
        Scanner file = new Scanner(temp);
        
        //initialize the variable 
        String input;
        int number;
        
        //while loop that keep running if there is another data set in the file  
        while (file.hasNext())
        {
            //try statement that tries to convert all the data from a String into an int 
            try {
                while (file.hasNext()) {
                    input = file.nextLine();
                    number = Integer.parseInt(input);
                    array.add(number);
                }
            //catch statement that out puts the wrong data set if data type is wrong
            } catch (Exception e) {
                System.out.println("Wrong data type:\n"+e.getMessage());
            }
        }
        
        //Finds the average 
        for (int i:array)
        {
            average+=i;
            count++;
        }
        average = average/count;

        //Finds the Variance 
        for (int j: array)
        {
            variance += Math.pow((j-average),2);
        }
        //Finds the standard deviation using the varance and how many sets of data there is 
        variance = variance/count;
        StaDev = Math.sqrt(variance);
        
        //Out put the standard deviation of the data set 
        System.out.printf("\n%s %.5f","The Standard Deviation is", StaDev);
    }
}
