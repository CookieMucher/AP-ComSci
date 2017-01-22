/**
 * Created by Hank on 12/24/2016.
 */

import java.util.*;

public class APCS_303_Library
{
}

class Book implements Comparable<Book>
{
    private String author, title;
    private int ISBN;

    public  Book()
    {
    }
    public Book(String author, String title, int ISBN)
    {
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public int compareTo(Book o) {
        return 0;
    }

    public String toString()
    {
        return "Author: "+author+", title: "+title+", ISBN: "+ISBN;
    }
}

abstract class LibraryBook extends Book
{
    int callNumber;

    public LibraryBook(String author, String title, int ISBN, int callNumber) {
        super(author, title, ISBN);
        this.callNumber = callNumber;
    }

    public int getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(int callNumber) {
        this.callNumber = callNumber;
    }

    public abstract void checkout();
    public abstract void returned();
    public abstract String circulationStatus();
    public String toString()
    {
        return super.toString()+"Call Number: "+callNumber+"Status: ";
    }
}

class ReferenceBook extends LibraryBook
{
    Book[] collection;

    public ReferenceBook(String author, String title, int ISBN, int callNumber, Book[] collection) {
        super(author, title, ISBN, callNumber);
        this.collection = collection;
    }

    public Book[] getCollection() {
        return collection;
    }

    public void setCollection(Book[] collection) {
        this.collection = collection;
    }

    public void checkout()
    {
        System.out.println("Cannot check out a reference book");
    }
    public void returned()
    {
        System.out.println("Reference book could not have been checked out -- return impossible");
    }
    public String circulationStatus()
    {
        return "non-circulating reference book";
    }


    public String toString() {
        return super.toString()+"collection: "+Arrays.toString(collection);
    }
}

class CirculatingBook extends LibraryBook
{
    String currentHolder, dueDate;
    Scanner keyboard = new Scanner(System.in);

    public CirculatingBook(String author, String title, int ISBN, int callNumber) {
        super(author, title, ISBN, callNumber);
        this.currentHolder = null;
        this.dueDate = null;
    }

    public String getCurrentHolder() {
        return currentHolder;
    }

    public void setCurrentHolder(String currentHolder) {
        this.currentHolder = currentHolder;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void checkout()
    {
        System.out.println("Name: ");
        String name = keyboard.nextLine();
        System.out.println("Date: ");
        String date = keyboard.nextLine();
        setCurrentHolder(name);
        setDueDate(date);
    }
    public void returned()
    {
        setCurrentHolder(null);
        setDueDate(null);
    }
    public String circulationStatus()
    {
        if(currentHolder.equals(null))
        {
            return "book available on shelves";
        }
        else
        {
            return "Current Holder: "+getCurrentHolder()+", Due Date: "+getDueDate();
        }
    }

    public String toString()
    {
        if(currentHolder.equals(null))
        {
            return super.toString();
        }
        else
        {
            return super.toString()+"Current Holder: "+getCurrentHolder()+", Due Date: "+getDueDate();
        }

    }
}
