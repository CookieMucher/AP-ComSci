/**
 * Created by Hank on 9/23/2016.
 */
import java.util.Scanner;
public class APCS_104_Time
{
    public static void main(String[] Theory)
    {
        Scanner keboard = new Scanner(System.in);

        System.out.println("Set hour");
        int hr = keboard.nextInt();
        keboard.nextLine();

        System.out.println("Set minute");
        int min = keboard.nextInt();
        keboard.nextLine();

        myClock time = new myClock(hr,min);
        time.setHour(hr);
        time.setMinute(min);

        System.out.printf("%02d:%02d\n",time.getHour(),time.getMinute());


        System.out.println("Set a new hour");
        hr = keboard.nextInt();
        keboard.nextLine();

        System.out.println("Set a new minute");
        min = keboard.nextInt();
        keboard.nextLine();

        time.setHour(hr);
        time.setMinute(min);

        System.out.print(time.toString());

        RepairShop reps = new RepairShop();

        reps.springForward(time);
        System.out.println(time.toString());

        reps.resetClock(time);
        System.out.println("Reset time\n"+time.toString());

        reps.cloneClock(time);
        System.out.println(time.toString());

    }
}
class  myClock
{
    private int minute;
    private int hour;

    //default constructor
    public myClock()
    {
        hour = 2;
        minute = 3;
    }
    //constructor that accepts int hour and minute
    public myClock(int hr, int min)
    {
        hour = hr;
        minute = min;
    }
    //getHour method
    public int getHour()
    {
        return hour;
    }
    //getMinute method
    public int getMinute()
    {
        return minute;
    }
    //setHour method
    public void setHour(int hr)
    {
        hour = hr;
    }
    //SetMinute method
    public void setMinute(int min)
    {
        minute = min;
    }
    //toString method with formatting
    public String toString()
    {
        return String.format("%02d:%02d\n",hour,minute);
    }
}
class RepairShop
{
    //Advance hour by 1
    public void springForward(myClock time)
    {
        if(time.getHour() == 12)
        {
            time.setHour(1);
        }
        else
        {
            time.setHour(time.getHour()+1);
        }

    }
    //resets the clock
    public void resetClock(myClock time)
    {
        time.setHour(2);
        time.setMinute(3);
    }
    //create a clone of myClock
    public myClock cloneClock(myClock time)
    {
        myClock cloneTime = time;
        return cloneTime;
    }
}
