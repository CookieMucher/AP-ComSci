/**
 * Created by Hank on 10/29/2016.
 */

import java.sql.Array;
import java.util.*;
import java.io.*;
public class APCS_205_WordSize
{
    public static void main(String[] Theory)throws IOException
    {
        int[] length = new int[5];
        String passage ="";
        String[] words;
        try
        {
            File file = new File("Message.txt");
            Scanner scan = new Scanner(file);

            while(scan.hasNextLine())
            {
                passage +=scan.nextLine();
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        words = passage.split("[+\\-*/\\^//., ]+");
        words[0] = words[0].substring(1);

        length = addSizes(words, length);
        for (int i = 0; i < length.length; i++) {
            System.out.println(i + ": " + length[i]);
        }
        printHistogram(length);
    }

    public static int[] addSizes(String[] words, int[] length)
    {
        int size;
        for (int i = 0; i <words.length; i++) {
            size = words[i].length();
            if (size > length.length - 1)
            {
                int[] newarray = new int[size+1];
                for(int j=0; j<length.length;j++)
                {
                    newarray[j] = length[j];
                }
                length = newarray;
                length[size] += 1;
            }
            else {
                length[size]++;
            }
        }
        return length;
    }

    public static void printHistogram(int[] values )
    {
        int count =0;
        int letternum=1;
        String outPut ="";

        for(int i=1; i<values.length; i++)
        {
            while (count<values[i])
            {
                outPut = outPut+"*";
                count++;
            }
            System.out.println(letternum+" Words:"+outPut);
            outPut="";
            count=0;
            letternum++;
        }
    }
}
