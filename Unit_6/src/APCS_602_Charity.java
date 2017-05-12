import java.util.*;

/**
 * Created by Hank on 2/19/2017.
 */
public class APCS_602_Charity
{
    public static void main(String[] Theory)
    {
        ArrayList<Charity> list = new ArrayList<>();
        list.add(new Charity("Uninted Way", "11/02/17", 2.3655));
        list.add(new Charity("Task force for Global", "02/02/02", 12322));
        list.add(new Charity("YMCA of YMCA", "03/33/78", 98273));
        list.add(new Charity("Food for the rich", "05/21/19", 1443546));


        Log tree = new Log(list);

        tree.display();
        System.out.println();

        tree.addCharity(new Charity("St. Jude", "03/10/13", 32543425));
        tree.display();

        System.out.println();
        System.out.println(tree.donationCheck(new Charity("St. Jude", "03/10/13", 32543425)));
        System.out.println(tree.monthCheck("11"));

    }
}
class Charity
{
    private String name, date;
    private double donation;

    public Charity(String name, String date, double donation) {
        this.name = name;
        this.date = date;
        this.donation = donation;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Charity "+ name +", Date"+ date + ", donation $"+ donation;
    }
}
class Log
{
    private static ArrayList<Charity> list;

    public Log(ArrayList<Charity> list) {
        this.list = list;
        Log.sort();
    }

    public static void sort()
    {
        for(int i=0; i<list.size(); i++)
        {
            Charity tmp = list.get(i);
            int pos = i;
            for(int j=i; j<list.size(); j++)
            {
                if (tmp.getName().compareTo(list.get(j).getName()) > 0)
                {
                    tmp = list.get(j);
                    pos = j;
                }
            }
            Collections.swap(list, i, pos);
        }
    }

    public void addCharity(Charity org)
    {
        list.add(org);
        sort();
    }

    public boolean donationCheck(Charity org)
    {
        for(Charity x: list)
            if(org.getName().compareTo(x.getName())==0)
                return true;
        return false;
    }

    public boolean monthCheck(String month)
    {
        for(Charity x: list)
            if(month.equalsIgnoreCase(x.getDate().substring(0,2)))
                return true;
        return false;
    }

    public void display()
    {
        for(Charity x: list)
        {
            System.out.println(x);
        }
    }

}