/**
 * Created by Hank on 12/8/2016.
 */
import java.io.*;
import java.util.*;
public class APCS_303_Football  //TESTER
{
    public static void main(String[] Theory)throws IOException
    {
        Team soccer = new Team();
        soccer.recruit();
        soccer.showStats();
    }
}

class Team
{
    Player[] theOcho = new Player[20];

    //This reads the file
    public String fileReader() throws IOException
    {
        //"data" will store what is in the file
        String data="";
        try
        {
            File file = new File("players.txt");
            Scanner scan = new Scanner(file);

            while(scan.hasNextLine())
            {
                //gets each line in file and adds it to "data"
                // and adds a "#" at the end of each line so it can be manipulated easier later.
                data += scan.nextLine()+"#";
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
//      System.out.println(data);
        return data;
    }

    public void recruit() throws IOException
    {
        //Splits the "data" and stores into an array
        String[] temp = fileReader().split("#");

        //Try-Catch block checks if there are more than 20 players
        try
        {
            //for each element it will be check if it is a defender or an offender using substring to find the "word"
            for(int i=0;i<temp.length;i++)
            {
                String name = temp[i].substring(0,temp[i].indexOf("@"));
                int number = Integer.parseInt(temp[i].substring(temp[i].indexOf("@")+1,temp[i].lastIndexOf("@")));

                //Creates the correct Object according to what the position the player plays.
                if(temp[i].substring(temp[i].lastIndexOf("@")+1).equalsIgnoreCase("Defense"))
                {
                    theOcho[i] = new Defense(name,"Defense",number, RanNumGen(),RanNumGen());
                }
                else
                {
                    theOcho[i] = new Offense(name,"Offense",number, RanNumGen(),RanNumGen());
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Too many players");
        }

    }

    private int RanNumGen()
    {
        return (int) (Math.random()*10);
    }

    public void showStats()
    {
        String temp="";

        for(int i=0; i<theOcho.length; i++)
        {
            if(theOcho[i].getPosition().equals("Offense"))
            {
                System.out.println(theOcho[i].toString());
            }
            else
            {
              temp+=theOcho[i].toString()+"\n";
            }
        }
       System.out.println(temp);
    }
}

//abstract class player because it does not need to be initialized
abstract class Player
{
    private String name, position;
    private int number;

    public Player(String name, String position, int number) {
        this.name = name;
        this.position = position;
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public String toString() {
        return "Player Name: "+ name +"|| Number: "+ number +"|| Position: "+ position;
    }
}

class Defense extends Player
{
    private int tackles, interceptions;

    //Takes in the same parameters as Player and tackles and interceptions
    public Defense(String name, String position, int number, int tackles, int interceptions) {
        super(name, position, number);
        this.tackles = tackles;
        this.interceptions = interceptions;
    }

    //super.toString uses toString from "Player"
    public String toString()
    {
        return super.toString()+"|| Tackles: "+ tackles +"|| Interceptions: "+ interceptions;
    }
}

//Similar to Defense
class Offense extends Player
{
    private int touchDowns, yards;

    public Offense(String name, String position, int number, int touchDowns, int yards) {
        super(name, position, number);
        this.touchDowns = touchDowns;
        this.yards = yards;
    }

    public String toString() {
        return super.toString()+"|| TouchDowns: "+ touchDowns +"|| Yards:" + yards;
    }
}