import java.util.*;

/**
 * Created by HHUANG on 3/10/2017.
 */
public class APCS_801_LunchLine
{
    public static void main(String[] Theory)
    {
        String[] FG1 = {"banana", "Ham", "Chicken", "Milk", "Pizza"};
        String[] FG2 = {"Pizza", "Pizza", "fries", "diet water"};
        String[] FG3 = {"Phones", "metal", "rock"};

        line straight = new line();

        straight.add(new tray(FG1, 20153.5));
        straight.add(new tray(FG2, 12523.2));
        straight.add(new tray(FG3, 99999.13));

        System.out.println(straight.toString());

        straight.checkOutFirst();

        System.out.println(straight.toString());

    }
}

class tray
{
    private String[] food = new String[5];
    private double cost;

    public tray(String[] food, double cost) {
        this.food = food;
        this.cost = cost;
    }

    public String[] getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "Food " + Arrays.toString(food) + ", cost " + cost;
    }
}

class line
{
    private LinkedList<tray> longLine;

    public line() {
        longLine = new LinkedList<>();
    }

    public void checkOutFirst()
    {
        longLine.removeFirst();
    }
    public void add(tray t)
    {
        longLine.add(t);
    }

    @Override
    public String toString()
    {
        Iterator<tray> it = longLine.iterator();
        String prints = "";
        while(it.hasNext())
        {
            prints += it.next().toString()+"\n";
        }
        return prints;
    }
}
