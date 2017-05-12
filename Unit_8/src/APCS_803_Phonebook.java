/**
 * Created by HHUANG on 3/10/2017.
 */
import java.util.*;

public class APCS_803_Phonebook
{
    public static void main(String[] theory)
    {

    }

}

class phoneBook
{
    Set<contacts> yellowBook;

    public phoneBook(List<contacts> Book)
    {
        yellowBook = new HashSet<>(Book);

    }
}

class contacts
{
    private String phoneNum, email, cellNum, home;

    public contacts(String phoneNum, String email, String cellNum, String home) {
        this.phoneNum = phoneNum;
        this.email = email;
        this.cellNum = cellNum;
        this.home = home;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getCellNum() {
        return cellNum;
    }

    public String getHome() {
        return home;
    }
}
