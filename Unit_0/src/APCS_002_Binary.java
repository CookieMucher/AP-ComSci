/**
 * Created by Hank on 9/1/2016.
 */
import java.util.Scanner;

public class APCS_002_Binary
{
        public static void main (String[] Theory)
        {
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Please enter integer");
            int i = keyboard.nextInt();
            keyboard.nextLine();

            System.out.println("Please enter Binary number");
            String s = keyboard.nextLine();

            System.out.println(i +" as a binary is "+toBin(i));
            System.out.println(s +" as a decimal is "+toDec(s));
        }

        public static String toBin(int dec)
        {
            String Bin="";
            while(dec>=1)
            {
                if ((dec % 2) == 1)
                {
                    Bin = "1" + Bin;
                }
                else
                {
                    Bin = "0" + Bin;
                }
                dec = dec / 2;

            }
            return Bin;
        }

        public static int toDec(String bin)
        {
            double temp2=0;
            int i = bin.length(), dec, j=0 ;

            while(i>0)
            {
                String temp = bin.substring(i-1,i);
                int num = Integer.parseInt(temp);
                temp2 += num*Math.pow(2,j);
                i--;
                j++;
            }
            dec = (int)temp2;
            return dec;
        }
}
