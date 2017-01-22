/**
 * Created by Hank on 12/6/2016.
 */
public class APCS_301_Lots_of_classes
{
    public static void main(String[] Theory)
    {
        Person per = new Person("Goodman", "666 Rainbow Road", "937-257-5676","Goodman.Will@ymail.com");
        System.out.println(per.toString());
        System.out.println();

        Student stu = new Student("Badstu","super senior");
        System.out.println(stu.toString());
        System.out.println();

        Employee emp = new Employee("Grenade",918,900.01,"11/11/11");
        System.out.println( emp.toString());
        System.out.println();

        Faculty fac = new Faculty("Waters","12:00 to 12:01","Legendary Eagle Master");
        System.out.println(fac.toString());
        System.out.println();

        Staff sta = new Staff("Magic","Supreme Supervisor");
        System.out.println(sta.toString());
        System.out.println();

    }

}
class Person
{
    String name, address, phoneNum, emailAddress;

    public Person(String name)
    {
        this.name=name;
    }
    public Person(String name, String address, String phoneNum, String emailAddress)
    {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.emailAddress = emailAddress;
    }

    public String toString() {
        return "Person name: "+name+"\nAddress: "+address+"\nPhoneNum: "+phoneNum+"\nEmail Address: "+emailAddress;
    }
}

class Student extends Person
{
    private String classStatus;

    public Student(String name, String classStatus) {
        super(name);
        this.classStatus = classStatus;
    }

    public String toString()
    {
        return "Student name: "+super.name+"\nGrade: "+classStatus;
    }
}

class Employee extends Person
{
    private int office;
    private double salary;
    private String dateHired;

    public Employee(String name) {
        super(name);
    }

    public Employee(String name, int office, double salary, String dateHired) {
        super(name);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public String toString() {
        return "Employee name: "+super.name+"\nOffice number: "+office+"\nSalary: "+salary+"\nDate Hired: "+dateHired;
    }
}

class Faculty extends Employee
{
    private String officeHours, rank;

    public Faculty(String name, String officeHours, String rank) {
        super(name);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public String toString() {
        return "Faculty name: "+super.name+"\nOfficeHours: "+officeHours+"\nRank: "+rank;
    }
}

class Staff extends Employee
{
    private String title;

    public Staff(String name, String title) {
        super(name);
        this.title = title;
    }

    public String toString() {
        return "Staff name: "+super.name + "\ntitle: "+title;
    }
}

