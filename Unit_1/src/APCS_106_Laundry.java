/**
 * Created by Hank on 9/24/2016.
 */
import java.util.Scanner;
public class APCS_106_Laundry
{
    public static void main(String[] Theory)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Name");
        String name = keyboard.nextLine();
        System.out.println("Number of Items");
        int num = keyboard.nextInt();
        System.out.println("s the order ready?");
        boolean done = keyboard.nextBoolean();
        LaundryOrder order = new LaundryOrder(name,num,done);

        System.out.println(order.toString());

        System.out.println("Is the order ready now?");
        done = keyboard.nextBoolean();
        order.setReady(done);

        System.out.println(order.toString());
    }
}
class LaundryOrder
{
    private String name;
    private int itemNum;
    private boolean ready;

    public LaundryOrder(String name, int num, boolean done)
    {
        this.name = name;
        itemNum = num;
        ready = done;
    }
    public String toString()
    {
        return "Name: "+name+"\nNumber of items: "+itemNum+"\nFinished:"+ready;
    }
    public void setReady(boolean done)
    {
            ready = done;
    }
}
