/**
 * Created by Hank on 9/23/2016.
 */
import java.util.Scanner;
public class APCS_101_Point {
}
class Tester
{
    public static void main (String[] Theory)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter X:");
        int x = keyboard.nextInt();
        System.out.println("Enter Y:");
        int y = keyboard.nextInt();

        Point dots = new Point(x,y);
        Point other = new Point(5,5);

        System.out.println("x = "+dots.getX());
        System.out.println("y = "+dots.getY());

        System.out.println("Distance from Origin "+ dots.distanceFromOrigin());
        System.out.println("Distance from other "+dots.distance(other));

        System.out.println("Enter new X:");
        x = keyboard.nextInt();
        System.out.println("Enter new Y:");
        y = keyboard.nextInt();

        dots.setLocation(x,y);
        dots.translate(5,5);
        System.out.println(dots.toString());
    }
}

class Point {
    private int x;
    private int y;

    public Point()
    {
        x=0;
        y=0;
    }

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()                       // return field values
    {
        return x;
    }
    public int getY()
    {
        return y;
    }

    // Use the distance formula to find the distance of this point from the origin (0,0)
    public double distanceFromOrigin()
    {
        return Math.sqrt((x*x)+(y*y));
    }

    // Find the "manhattan" distance between current point and other.
    //  You can look at http://x...content-available-to-author-only...t.gov/dads//HTML/manhattanDistance.html for help
    public double distance(Point other)
    {
        return Math.sqrt(((other.getX()-x)*(other.getX()-x))+((other.getY()-y)*(other.getY()-y)));
    }

    // Changes the coordinate to new values
    public void setLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    //Shift the point by the translation T<x+h,y+k>
    public void translate(int h, int k)
    {
        x+=h;
        y+=k;
    }

    //Displays the instance variables as a coordinate e.g. "(4, -7)"
    public String toString()
    {
        return "("+x+", "+y+")";
    }
}
