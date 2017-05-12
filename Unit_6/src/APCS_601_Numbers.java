/**
 * Created by Hank on 2/19/2017.
 */
public class APCS_601_Numbers
{
    public static void main(String[] Theory)
    {
        numbers tester = new numbers();

        System.out.println(tester.findFirst(5));
        System.out.println(tester.findLast(5));
        tester.findAll(5);
        System.out.println("\n"+tester.count(5));
        System.out.println(tester.greater(5));

    }
}

class numbers
{
    int[] nums;

    public numbers()
    {
        nums = new int[100];
        for (int i = 0; i < nums.length ; i++) {
            nums[i] = (int) (Math.random() *(20)+1);
        }
    }

    // returns the first occurrence location
    public  int findFirst(int value)
    {
        for (int i = 0; i < nums.length; i++)
            if(nums[i]==value)
                return i;
        return -1;
    }


    // returns last occurrence location
    public int findLast(int value)
    {
        for (int i = nums.length-1; i > 0; i--)
            if(nums[i]==value)
                return i;
        return -1;
    }

    // prints a list of all locations
    public void findAll(int value)
    {
        for (int i = 0; i < nums.length; i++)
            if(nums[i]==value)
                System.out.print(i+", ");
    }

    // returns the number of times value appears in the array
    public int count(int value)
    {
        int count =0;
        for (int i = 0; i < nums.length; i++)
            if(nums[i]==value)
                count++;
        return count;
    }

    // returns how many items are greater than value in the array
    public int greater(int value)
    {
        int count =0;
        for (int i = 0; i < nums.length; i++)
            if(nums[i]>value)
                count++;
        return count;
    }


}
