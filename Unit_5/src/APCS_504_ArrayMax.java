/**
 * Created by Hank on 1/24/2017.
 */
public class APCS_504_ArrayMax
{
    public static void main(String[] args)
    {
        int[] nums = {1,5,3,4,8,6,5,4};
        System.out.println(recursiveIntMax(nums,0,0));
    }

    public static int recursiveIntMax(int[] a, int index, int max)
    {
        if(index==a.length-1)
            return a[a.length-1];
        max = recursiveIntMax(a,index+1,max);
        if(a[index]<max)
            return max;
        else
            return a[index];
    }

    private static <T extends Comparable<T>> T recursiveGenericMax(T[] a, int index, T max)
    {
        if(index==a.length-1)
            return a[a.length-1];
        max = recursiveGenericMax(a,index,max);
        if(a[index].compareTo(max)==-1)
            return max;
        else
            return a[index];
    }
}