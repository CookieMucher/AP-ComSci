import java.util.ArrayList;

/**
 * Created by Hank on 2/19/2017.
 */
public class APCS_603_LittleLeague
{
    public static void main(String[] Theory)
    {
        ArrayList<Players> CSleague = new ArrayList<>();
        CSleague.add(new Players("falcons","Jason McScallopZ"));
        CSleague.add(new Players("pirates","Joe Arggggggg"));
        CSleague.add(new Players("falcons","Arya Smells"));
        CSleague.add(new Players("pirates","Al Yourbase"));
        CSleague.add(new Players("falcons","Alex Smellsworse"));
        CSleague.add(new Players("falcons","Katie ThinksIt’sOkToBeLate"));
        CSleague.add(new Players("pirates","Jeremy Meh"));


        RosterPrinter printer = new RosterPrinter();
        System.out.println(printer.byName(CSleague).toString());
        System.out.println();
        System.out.println();
        printer.byTeam(CSleague);


    }
}
class RosterPrinter
{
    public ArrayList<Players> byName(ArrayList<Players> player)
    {
      for(int i=1; i<player.size();i++)
      {
          for(int j=0;j<i;j++)
          {
              if(player.get(i).getName().compareTo(player.get(j).getName())<0)
              {
                  player.add(j,player.get(i));
                  player.remove(i+1);
              }
          }
      }
      return player;
    }

    public void byTeam(ArrayList<Players> player)
    {
        byName(player);

        while (player.size()!=0)
        {
            String tName = player.get(0).getTeam();
            System.out.println(tName+":");
            for(int i=0; i<player.size();i++)
            {
                if(tName.equals(player.get(i).getTeam()))
                {
                    System.out.println(player.get(i).getName());
                    player.remove(i);
                    i--;
                }
            }
        }
    }
}
class Players
{
    String team, name;

    public Players(String team, String name) {
        this.team = team;
        this.name = name;
    }
    public String getTeam() {
        return team;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name ;
    }
}


