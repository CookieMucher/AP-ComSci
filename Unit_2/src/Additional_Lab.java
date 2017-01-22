/**
 * Created by Hank on 11/6/2016.
 */
import java.util.*;
public class Additional_Lab //This is the tester class
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Let's make a triangle");
        System.out.println("enter the first side");
        double s1 = keyboard.nextDouble();
        System.out.println("enter the second side");
        double s2 = keyboard.nextDouble();
        System.out.println("enter the third side");
        double s3 = keyboard.nextDouble();
        Triangle congruent = new Triangle(s1,s2,s3);
        System.out.println("you have entered a "+congruent.toString());

        System.out.println("Choose a color");
        String color = keyboard.nextLine();
        congruent.setColor(color);

        System.out.println("enter the third side");
        boolean fill = keyboard.nextBoolean();
        congruent.setFilled(fill);

        System.out.println("The area of the triangle is "+congruent.gerArea());
        System.out.println("The perimeter of the triangle is "+congruent.getPerimeter());
        System.out.println("The color of the triangle is "+congruent.getColor());
        System.out.println("The triangle is filled: " +congruent.isFilled());
    }
}

class Triangle extends SimpleGeometricObject
{
   private double side1=1.0,side2=1.0,side3=1.0;

    public Triangle()
    {
    }

    public Triangle(double s1,double s2, double s3)
    {
        side1=s1;
        side2=s2;
        side3=s3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }
    public double gerArea()
    {
        //Heron's formula
        double S = getPerimeter()/2;
        return Math.sqrt(S*(S-side1)*(S-side2)*(S-side3));
    }
    public double getPerimeter()
    {
        return side1+side2+side3;
    }

    public String toString() {
        return "triangle: side1=" + side1 + " side2=" + side2 + " side3=" + side3;
    }
}

class SimpleGeometricObject
{
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    public SimpleGeometricObject() {
        dateCreated = new java.util.Date();
    }

    public SimpleGeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
}


