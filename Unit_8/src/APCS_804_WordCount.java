/**
 * Created by HHUANG on 3/10/2017.
 */
import java.util.*;
public class APCS_804_WordCount
{
    public static void main(String[] Thoery)
    {
        HashMap<String, Integer> wordCounter = new HashMap<>();

        Scanner data= new Scanner("Roses are red Violets are blue Java Pwns You");
        List<String> Stroage = new ArrayList();
        while(data.hasNext())
        {
            Stroage.add(data.next());
        }

        for(int i=0; i<Stroage.size(); i++)
        {
            if(wordCounter.containsKey(Stroage.get(i)))
            {
                wordCounter.put(Stroage.get(i),wordCounter.get(Stroage.get(i))+1);
            }
            else
            {
                wordCounter.put(Stroage.get(i),1);
            }
        }

        System.out.println(wordCounter);
    }
}
