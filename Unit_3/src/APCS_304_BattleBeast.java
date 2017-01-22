import java.util.Arrays;

/**
 * Created by HHUANG on 12/9/2016.
 */
public class APCS_304_BattleBeast
{
}

class Teams
{
    private String name;
    private Beast[] roster;

    public Beast getBeast(int num) {
        return roster[num];
    }

    public String toString() {
        return "Teams{" + "name='" + name + '\'' + ", roster=" + Arrays.toString(roster) + '}';
    }
}

class Beast
{
    private String element, name, animal;

    public int battle(Beast b)
    {
        return 1; // always wwwwinning
    }

    public String toString() {
        return "Beast{" + "element='" + element + '\'' + ", name='" + name + '\'' + ", animal='" + animal + '\'' + '}';
    }
}

class statBeast extends Beast
{
    private int[] stats = new int[3];

    public void win()
    {
        stats[0]++;
    }
    public void loss()
    {
        stats[1]++;
    }
    public void tie()
    {
        stats[2]++;
    }

}