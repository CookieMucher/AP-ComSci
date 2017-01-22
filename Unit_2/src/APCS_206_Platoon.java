/**
 * Created by Hank on 10/29/2016.
 */

import java.util.Scanner;
public class APCS_206_Platoon
{
    public static void main(String[] Theory)
    {
        Soldier [] soldiers = new Soldier[5];
        Scanner keyboard = new Scanner(System.in);
        String[] names = {"Olofm","Device","GuardiaN", "Happy", "Snax"};
        String[] rank = {"Gold Nova I","Legendary Eagle Master", "Supreme Master First Class", "Global Elite", "Silver I"};
        String order = "Make Sandwich";
        int[] age = {37,10,18,25,55};


        for (int i = 0; i < soldiers.length; i++)
        {
            soldiers[i] = new Soldier(names[i], rank[i], order, age[i]);
        }

        // construct the platoon
        Platoon dedSec = new Platoon(soldiers);
        System.out.print(dedSec.toString());
        String neoOrder = "Pwn n00bs";
        dedSec.changeOrders(neoOrder);

        System.out.println("\n\n****new orders has been given****\n"+dedSec.toString());
    }
}

class Platoon
{
    private Soldier[] team;

    //default constructor
    Platoon()
    {
    }

    //Setting the group of soldiers into a platoon
    Platoon(Soldier[] soldiers)
    {
        team = soldiers;
    }

    public void changeOrders(String orders) {
        team[0].setOrder(orders);
    }

    public String toString() {
        String output ="";
        for (int i = 0; i < team.length; i++) {
            output += "\n" + team[i].toString();
        }
        return output;
    }

}

class Soldier extends Platoon
{
    private String name, rank;
    private static String order;
    private int age;

    public Soldier(String name, String rank, String order, int age)
    {
        this.name = name;
        this.rank = rank;
        this.order = order;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public static String getOrder() {
        return order;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Name: "+name+", rank: "+rank+", age: "+age+", order: "+order;
    }
}



