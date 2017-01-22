/**
 * Created by Hank on 1/6/2017.
 */

import java.util.*;
public class Tester
{
    public static void main(String[] Theory)
    {

        List<Integer> data  = new ArrayList<>();

        int[] list = {1,2,2,2,2,2,2,2,3,5,5,5,5,4,7,5,83};


        for(Integer x: list)
        {
            data.add(x);
        }

        for(int i=0; i<data.size()-1; i++)
        {
            for(int j=1;j<data.size(); j++ )
            {
                if (data.get(i).equals(data.get(j)))
                {
                    data.remove(j);
                }
            }
        }

        System.out.println(data);

    }
}
