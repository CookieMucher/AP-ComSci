
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

/**
 * Created by Hank on 1/16/2017.
 */
public class APCS_404_Generic_Methods
{
    public static <E extends Comparable <E>> E max(E[][] list)
    {
        E maximum = list[0][0];

        for(int i=0; i<list.length; i++)
        {
            for(int j=0; j< list[0].length;j++)
            {
                if (maximum.compareTo(list[i][j])>0)
                {
                    maximum=list[i][j];
                }
            }
        }
        return maximum;
    }

    public static <E> void shuffle(ArrayList<E> list)
    {
        for(int i=0;i<list.size();i++)
        {
            Collections.swap(list,i,numGen(list.size()));
        }
//        Collections.shuffle(list);
    }

    public static int numGen(int end)
    {
        return (int)(Math.random()*end+1);
    }


}
