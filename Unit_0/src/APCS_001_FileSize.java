/**
 * Created by Hank Huang on 9/1/2016.
 */

import java.util.Scanner;
public class APCS_001_FileSize
{
    public static void main(String[] Theroy)
    {
        Scanner keyboard = new Scanner(System.in);
        double input;

        while(true)
        {
            System.out.println("Enter file size");
            input = keyboard.nextDouble();

            if (input != -1)
            {
                System.out.println("Good Bye");
                return;
            }
            double a = Math.log10(input);
            int size = (int) a;

            switch (size)
            {
                case 0:
                case 1:
                case 2:
                    System.out.println("Byte");
                    break;
                case 3:
                case 4:
                case 5:
                    System.out.println("KB");
                    break;
                case 6:
                case 7:
                case 8:
                    System.out.println("MB");
                    break;
                case 9:
                case 10:
                case 11:
                    System.out.println("GB");
                    break;
                case 12:
                case 13:
                case 14:
                    System.out.println("TB");
                    break;
                default:
                    System.out.println("Something has gone awry.");
                    return;
            }
        }
    }
}
