import java.io.File;
import java.util.Scanner;
public class Test_Space
{
    public static void main(String[] args)
    {
        thins t1 = new thins("Thor","Lighting",12,333);
        thins t2 = new thins("OG","Hood",32,666);

        System.out.println(t1.compareTo(t2));
    }
}


class notbook
{
    private String author, title;
    private int ISBN;

    public notbook() {
    }

    public notbook(String author, String title, int ISBN) {
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
    }
}

class thins extends Book implements Comparable<thins>
{
    int callNumber;

    public thins(String author, String title, int ISBN, int callNumber) {
        super(author, title, ISBN);
        this.callNumber = callNumber;
    }

    public int getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(int callNumber) {
        this.callNumber = callNumber;
    }

    @Override
    public int compareTo(thins o) {
        return this.callNumber.compareTo(o.getCallNumber());
    }
}



