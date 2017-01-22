/**
 * Created by Hank on 9/23/2016.
 */
import java.util.Scanner;
public class APCS_103_StringSandbox
{
    public static void main(String[] Theory)
    {
        Scanner keyboard = new Scanner(System.in);
        StringSandbox fun = new StringSandbox();

        System.out.println("enter a phrase and I'll tell you how many 'a's it have/has");
        String input = keyboard.nextLine();
        System.out.println(fun.countA(input));

        System.out.println("Enter a number and I'll count how many 'a's is after it");
        int begin = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println(fun.countA(input,begin));

        System.out.println(fun.matey(input));

        System.out.println("this is the last alphabetical letter in the input '"+fun.lastLetter(input)+"'");

        System.out.println("do you want to skip capital letters? Y/N");
        String cho = keyboard.nextLine();
        boolean skipCaps = (cho.equalsIgnoreCase("Y")||cho.equalsIgnoreCase("Yes"));
        System.out.println("this is the last alphabetical letter in the input '"+fun.lastLetter(input,skipCaps)+"'");
    }
}

class StringSandbox {
    //counts the number of times ‘a’ appears in input
    public int countA(String input) {
        //makes all lower case
        input = input.toLowerCase();
        //replace anything that is a space character (including space, tab characters etc) (\s)
        input = input.replaceAll("\\s+", "");
        // replace anything that isn't a word character (including punctuation etc) (\W)
        input = input.replaceAll("\\W+", "");
        //get length of input;
        int length = input.length();
        int count = 0;

        //for each character of input see if it matches "a". if yes count it.
        while (length > 0) {
            String c = input.substring(length - 1, length);
            if (c.equals("a")) {
                count++;
            }
            length--;
        }
        return count;
    }

    //counts the number of times ‘a’ appears in input after begin
    public int countA(String input, int begin) {
        //makes all lower case
        input = input.toLowerCase();
        //replace anything that is a space character (including space, tab characters etc) (\s)
        input = input.replaceAll("\\s+", "");
        // replace anything that isn't a word character (including punctuation etc) (\W)
        input = input.replaceAll("\\W+", "");
        //get length of input;
        int length = input.length();
        int count = 0;

        //for each character of input stating from begin see if it matches "a". if yes count it.
        while (begin < length) {
            String c = input.substring(begin, begin + 1);
            if (c.equals("a")) {
                count++;
            }
            begin++;
        }
        return count;
    }

    //returns the input with the word “matey” added at the end
    public String matey(String input) {
        return input + "matey";
    }

    //returns the last alphabetical letter in the input
    // example    “rootbeer”  -> ‘t’
    // example    “Adam”      -> ‘m’
    public char lastLetter(String input)
    {
        //makes all lower case
        input = input.toLowerCase();
        //replace anything that is a space character (including space, tab characters etc) (\s)
        input = input.replaceAll("\\s+", "");
        // replace anything that isn't a word character (including punctuation etc) (\W)
        input = input.replaceAll("\\W+", "");

        String a = input.substring(0, 1), b;

        for (int i = 0; i < input.length()-1; i++)
        {
            b = input.substring(i+1,i+2);
            //a is smaller
            if (Character.getNumericValue(a.charAt(0))<=Character.getNumericValue(b.charAt(0)))
            {
                a = b;
            }
        }
        return a.charAt(0);
    }


        //like prior, but allows capitals to be ignored
    // example    “Trig”,true  -> ‘r’
    // example    “Trig”,false -> ‘T’
    public char lastLetter(String input, boolean skipCaps)
    {
        if (skipCaps)
        {
            input = input.replaceAll("[A-Z]","");
        }
        //replace anything that is a space character (including space, tab characters etc) (\s)
        input = input.replaceAll("\\s+", "");
        // replace anything that isn't a word character (including punctuation etc) (\W)
        input = input.replaceAll("\\W+", "");

        String a = input.substring(0, 1), b;

        for (int i = 0; i < input.length()-1; i++)
        {
            b = input.substring(i+1,i+2);
            //a is smaller
            if (Character.getNumericValue(a.charAt(0))<=Character.getNumericValue(b.charAt(0)))
            {
                a = b;
            }
        }
        return a.charAt(0);
    }

}
