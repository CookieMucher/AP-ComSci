/**
 * Created by Hank on 10/20/2016.
 */
public class APCS_204_ArrayMethods
{
    public static void main(String[] Theory)
    {
        String words = "black banana republic boots", toPrint="";

        int[] vowels = vowelCount(words);

        for(int i=0; i<vowels.length; i++)
        {
            if(i==vowels.length-1)
            {
                toPrint += vowels[i];
            }
            else
            {
                toPrint += vowels[i]+", ";
            }
        }
        System.out.println("{"+toPrint+"}");
    }

    public static int[] vowelCount(String words)
    {
        int[] vol = new int[5];
        for(int j=0; j<words.length(); j++)
        {
            switch (words.charAt(j))
            {
                case 'a':
                    vol[0]++;
                    break;
                case 'e':
                    vol[1]++;
                    break;
                case 'i':
                    vol[2]++;
                    break;
                case 'o':
                    vol[3]++;
                    break;
                case 'u':
                    vol[4]++;
                    break;
                default:
                    break;
            }
        }
        return vol;
    }
}
