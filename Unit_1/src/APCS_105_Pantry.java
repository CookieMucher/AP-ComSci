import javax.annotation.processing.SupportedSourceVersion;

/**
 * Created by Hank on 9/24/2016.
 */
import java.util.Scanner;
public class APCS_105_Pantry //Tester
{
    public static void main(String[] Theory)
    {
        Scanner keyboard = new Scanner(System.in);
        Jam jam1 = new Jam("Gooseberry","7/4/86",12);
        Jam jam2 = new Jam("Crab Apple","9/30/99",8);
        Jam jam3 = new Jam("Rhubarb","10/31/99",3);
        Pantry pantry = new Pantry(jam1,jam2,jam3);

        System.out.println(pantry.toString());

        System.out.println("What jar do you want to use?");
        int num = keyboard.nextInt();
        keyboard.nextLine();
        pantry.setSelected(num);

        System.out.println("How much do you want to Spread?");
        int amount = keyboard.nextInt();
        keyboard.nextLine();
        pantry.spreadJam(amount);

        System.out.println(pantry.toString());

        System.out.println("Which jam do you want to replace?");
        num = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("Name of new jam");
        String type = keyboard.nextLine();
        System.out.println("Canned date (mm/dd/yy)");
        String date = keyboard.nextLine();
        System.out.println("Number of ounces");
        int ounces = keyboard.nextInt();
        keyboard.nextLine();
        Jam newJam = new Jam(type,date,ounces);
        pantry.replace(num,newJam);

        System.out.println(pantry.toString());
    }
}
class Jam
{
    private Scanner keyboard = new Scanner(System.in);
    private String type;
    private String date;
    private int numOunce;

    //Constructor that takes in two strings and one int
    public Jam(String type, String date, int ounces)
    {
        this.type=type;
        this.date=date;
        numOunce=ounces;
    }

    //method for checking if jam is empty
    public boolean empty()
    {
        return numOunce<=0;
    }

    //method for spreading jam
    public void spread(int amount)
    {
        //checks for if jam is empty
        if(empty())
        {
            System.out.println("Can't spread because there is nothing to spread");
        }

        //checks for input amount is bigger than what jam oz. If so, loop till the user puts in the right amount
        else if (amount>numOunce)
        {
            System.out.println("Can't spread "+amount+" ounces because there is only "+numOunce+" ounces");
            amount = keyboard.nextInt();
            keyboard.nextLine();
            spread(amount);
        }

        //decreases the jam oz if above are false
        else
        {
            numOunce-=amount;
            System.out.println("you are spreading "+amount+" ounces and there is "+numOunce+" ounces left in the jar");
        }
    }
    public String toString()
    {
        return type+", canned "+date+", "+numOunce+"oz";
    }
}

class Pantry
{
    private Jam jar1;
    private Jam jar2;
    private Jam jar3;
    private Jam selected;

    //constructor takes in the jam
    public Pantry(Jam jam1,Jam jam2,Jam jam3)
    {
        jar1 = jam1;
        jar2 = jam2;
        jar3 = jam3;
    }

    //method for the user to select the jam
    public void setSelected(int num)
    {
        switch(num)
        {
            case 1: selected = jar1;
                    break;
            case 2: selected = jar2;
                    break;
            case 3: selected = jar3;
                    break;
            default: System.out.println("CAKES");
                     System.exit(0);
        }
    }

    //calls for the spread method if select is not null
    public void spreadJam(int amount)
    {
        if(selected != null)
        {
            selected.spread(amount);

        }
    }

    //method for replacing the jam
    public void replace(int num, Jam newJam)
    {
        switch(num)
        {
            case 1: jar1=newJam;
                break;
            case 2: jar2=newJam;
                break;
            case 3: jar3=newJam;
                break;
            default: System.out.println("CAKES!!");
                System.exit(0);
        }
    }

    //outputs all the jams in the pantry in string form
    public String toString()
    {
        return "\n"+jar1+"\n"+jar2 +"\n"+jar3;
    }
}