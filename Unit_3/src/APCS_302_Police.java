/**
 * Created by hhuang on 12/7/2016.
 */
public class APCS_302_Police
{
    public static void main(String[] Theory)
    {
        Patrolman pat = new Patrolman("Road", "Runer", 5);
        System.out.println("Patrolman:"+pat.getFirstName()+" "+pat.getLastName());
        System.out.println("Years of Service:"+pat.getYearOfSer());
        System.out.println("Earnings:"+String.format("%.2f",pat.earnings()));
        System.out.println("Benefit Level:"+pat.benefitLevel());
        System.out.println();

        Sergeant sgt= new Sergeant("Ellmer", "Fuldd", 12);
        System.out.println("Sergeant:"+sgt.getFirstName()+" "+sgt.getLastName());
        System.out.println("Years of Service:"+sgt.getYearOfSer());
        System.out.println("Earnings:"+String.format("%.2f",sgt.earnings()));
        System.out.println("Benefit Level:"+sgt.benefitLevel());
        System.out.println();

        Lieutenant lie = new Lieutenant("Daffy", "Duck", 14);
        System.out.println("Sergeant:"+lie.getFirstName()+" "+lie.getLastName());
        System.out.println("Years of Service:"+lie.getYearOfSer());
        System.out.println("Earnings:"+String.format("%.2f",lie.earnings()));
        System.out.println("Benefit Level:"+lie.benefitLevel());
        System.out.println();

        System.out.println("Average base pay:"+String.format("%.2f",(pat.getBasePatrolPay()+sgt.getBaseSgtPay()+lie.getBaseLieutenantPay())/3));
    }
}

abstract class Policeman
{
    private String firstName, lastName;
    private int yearOfSer;

    public Policeman(String firstName, String lastName, int yearOfSer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfSer = yearOfSer;
    }
    public abstract double earnings();
    public abstract int benefitLevel();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearOfSer() {
        return yearOfSer;
    }
}

class Patrolman extends Policeman
{
    protected static double basePatrolPay = 3600;

    Patrolman(String first, String last, int y)
    {
        super(first, last, y);
    }

    public double getBasePatrolPay()
    {
        return basePatrolPay;
    }

    public double earnings()
    {
         return basePatrolPay*.85+(.06*Math.sqrt(basePatrolPay)*getYearOfSer());
    }
    public int benefitLevel()
    {
        return 1;
    }
}

class Sergeant extends Patrolman
{
    protected static double baseSgtPay = 4700;

    public Sergeant(String first, String last, int y)
    {
        super(first, last, y);
    }
    public double getBaseSgtPay()
    {
        return baseSgtPay;
    }
    public double earnings()
    {
        return baseSgtPay*.82+(1.2*Math.sqrt(baseSgtPay)*getYearOfSer());
    }
    public int benefitLevel()
    {
        return 2+super.benefitLevel();
    }
}

class Lieutenant extends Sergeant
{
    protected static double baseLieutenantPay = 5900;

    public Lieutenant(String first, String last, int y)
    {
        super(first, last, y);
    }

    public double getBaseLieutenantPay()
    {
        return baseLieutenantPay;
    }
    public double earnings()
    {
        return baseLieutenantPay*.80+(1.3*Math.sqrt(baseLieutenantPay)*getYearOfSer());
    }
    public int benefitLevel()
    {
        return 3+super.benefitLevel();
    }
}
