/**
 * Created by Hank on 10/29/2016.
 */
import java.util.*;
import java.io.*;

public class APCS_208_Encryption
{
    public static void main(String[] args) throws IOException
    {
        String data;
        Encryptor enigma = new Encryptor("sms.txt");
        data = enigma.fileReader();
        System.out.println(enigma.encrypt(data));
//
//        data = enigma.decrypt(data);
//        System.out.println("decoded "+data);
    }
}

class Encryptor
{
    private int[][] key = {{1,2},{2,8}};
    private String message;
    public Scanner file;

    public Encryptor(String fileName)throws IOException
    {
        File temp = new File(fileName);
        file = new Scanner(temp);
    }

    public String fileReader()
    {
        String data="";
        try
        {
            while(file.hasNext())
            {
                data += file.nextLine();
            }
            data = data.replaceAll("\\W+", "");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public String encrypt(String data)
    {
        int[][] eMessage = new int[(data.length()/2)+1][2];
        int counter = 0;

        for (int i = 0; i <(data.length()/2)+1; i++)
        {
            for (int j = 0; j < eMessage[0].length; j++)
            {
                if(counter>=data.length())
                {
                    break;
                }
                else if (Character.getNumericValue(data.charAt(counter))==-1)
                {
                    eMessage[i][j] = 27;
                }
                else
                {
                    eMessage[i][j] = (Character.getNumericValue(data.charAt(counter))-9);
                }
                counter++;
            }
        }

        //Calculations for multiplying matrices
        int m1 = eMessage.length;
        int n1 = eMessage[0].length;
        int n2 = key[0].length;
        int[][] c = new int[m1][n2];
        for (int i = 0; i < m1; i++)
        {
            for (int j = 0; j < n2; j++)
            {
                for (int k = 0; k < n1; k++) {
                    c[i][j] += eMessage[i][k] * key[k][j];
                }
            }
        }

        //set the array into a one string
        for(int x=0;x<eMessage.length;x++)
        {
            for(int y=0;y<eMessage[0].length;y++)
            {
                message+=c[x][y]+" ";
            }
        }
        return message;
    }


    public String decrypt(String data)
    {
        double[][] rKey ={{2,-.5},{-.5,.25}};

        int[][] eMessage = new int[(data.length()/2)+1][2];
        int counter = 0;

//        for(int i=0; i<)

        //Calculations for multiplying matrices
        int m1 = eMessage.length;
        int n1 = eMessage[0].length;
        int n2 = rKey[0].length;
        int[][] c = new int[m1][n2];
        for (int i = 0; i < m1; i++)
        {
            for (int j = 0; j < n2; j++)
            {
                for (int k = 0; k < n1; k++) {
                    c[i][j] += eMessage[i][k] * rKey[k][j];
                }
            }
        }

        //set the array into a one string
        for(int x=0;x<eMessage.length;x++)
        {
            for(int y=0;y<eMessage[0].length;y++)
            {
                message+=c[x][y]+" ";
            }
        }
        return message;
    }
}
