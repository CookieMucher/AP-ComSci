/**
 * Created by Hank on 10/20/2016.
 */
public class APCS_203_Stretch
{
    public static void main(String[] Theory)
    {
        int[] num = {18,7,4,24,11};

        int[] temp = stretch(num);

        String toPrint = "";

        for(int i=0; i<temp.length; i++)
        {
            if(i==temp.length-1)
            {
                toPrint += temp[i];
            }
            else
            {
                toPrint += temp[i]+", ";
            }
        }
        System.out.println("{"+toPrint+"}");


    }

    public static int[] stretch(int[] num)
    {
        int[] temp = num;
        int[] output = new int[(num.length*2)];
        int count=0;


        for(int i = 0; i<temp.length; i++)
        {

            if(temp[i]%2==0)
            {
                output[i+count]=temp[i]/2;
                output[(i+1+count)]=temp[i]/2;
            }
            else
            {
                output[i+count]=(temp[i]/2)+1;
                output[(i+1+count)]=(temp[i]/2);
            }

            count++;
        }
        return output;
    }
}
