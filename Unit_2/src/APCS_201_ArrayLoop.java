/**
 * Created by Hank on 10/20/2016.
 */
public class APCS_201_ArrayLoop
{
    public static void main(String[] Theory)
    {
        //call createArray
        int[] list = createArray();
        int j = 0;
        int big = list[j];
        int small = list[j];
        int sum = 0;
        String[] toPrint = {"","","","","","","","","",""};
        int count = 0;

        //loop
        for (j = 0; j < list.length; j++)
        {
            int temp = list[j];

            //Maximum value
            if(big<=temp)
            {
                big = temp;
            }

            //Minimum value
            if(small>=temp)
            {
                small = temp;
            }
            //Sum of all
            sum += list[j];

            //count of "2" appearing and Chart of each number appearing
            switch (list[j])
            {
                case 1:
                    toPrint[0] +="*";
                    break;
                case 2:
                    toPrint[1] +="*";
                    break;
                case 3:
                    toPrint[2] +="*";
                    break;
                case 4:
                    toPrint[3] +="*";
                    break;
                case 5:
                    toPrint[4] +="*";
                    break;
                case 6:
                    toPrint[5] +="*";
                    break;
                case 7:
                    toPrint[6] +="*";
                    break;
                case 8:
                    toPrint[7] +="*";
                    break;
                case 9:
                    toPrint[8] +="*";
                    break;
                case 10:
                    toPrint[9] +="*";
                    break;
                default:
                    break;
            }
        }
        //Average of all
        double average = sum/list.length;

        System.out.println("The max is "+big);
        System.out.println("The min is "+small);
        System.out.println("The sum is "+sum);
        System.out.println("The average is "+average);
        System.out.println("The number 2 appeared "+toPrint[1].length()+" times");

        for(int i=0; i<toPrint.length; i++)
        {
            System.out.printf("\n%-10d%s",i+1, toPrint[i]);
        }
    }

    public static int[] createArray()
    {
        //create a array size of random
        int x = (int)(Math.random()*(100+1)+1);
        int[] a = new int [x];

        //fill the array with random numbers
        for (int i =0; i<x; i++)
        {
            int y = (int)(Math.random()*(10)+1);
            a[i] = y;
        }

        //return array
        return a;
    }
}
