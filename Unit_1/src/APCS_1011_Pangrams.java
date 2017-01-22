/**
 * Created by Hank on 9/23/2016.
 */;
import java.util.Scanner;

public class APCS_1011_Pangrams
{
    public static void main(String[] Theory)
    {;
        Scanner keboard = new Scanner(System.in);;

        System.out.println("Enter your sentence:");
        String input = keboard.nextLine();
        String keeper = input;
        String key = "abcdefghijklmnopqrstuvwxyz";

        //fixing the input to make it all uniform
        //http://stackoverflow.com/questions/5455794/removing-whitespace-from-strings-in-java
        //makes all lower case
        input = input.toLowerCase();
        //replace anything that is a space character (including space, tab characters etc) (\s)
        input = input.replaceAll("\\s+","");
        // replace anything that isn't a word character (including punctuation etc) (\W)
        input = input.replaceAll("\\W+","");

        //will go through every single character in the input sentence
        for(int i=0; i<input.length(); i++)
        {
            //cut each one out
            String a = input.substring(i,i+1);

            //will cut each letter in the alphabet out and compare it to the string
            for (int j=0; j<key.length(); j++)
            {
                String b = key.substring(j,j+1);

                //if there is a mach, the letter will be taken out of the key
                if (b.equals(a))
                {
                    key = key.replace(b,"");
                }
            }
        }

        //if the key has no character in it, that means the sentence has every letter of the alphabet at least once.
        if (key.length()==0)
        {
            System.out.println(keeper+" is a pangram");
        }
        else
        {
            System.out.println(keeper+"is not a pangram");
        }




    }
}
