/**
 * Created by HHUANG on 3/10/2017.
 */

import java.util.*;
public class APCS_802_ClassRank
{
    public static void main(String[] Theory)
    {
        TreeSet<learningUnit> Ranks = new TreeSet<learningUnit>(new theRank());

        Ranks.add(new learningUnit("Bobby","175454","3.82","3.22"));
        Ranks.add(new learningUnit("John","175123","2.28","3.33"));
        Ranks.add(new learningUnit("Crish","185524","1.82","3.93"));
        Ranks.add(new learningUnit("Kristen","155454","3.82","3.12"));

        for(learningUnit l: Ranks)
            System.out.println(l);


        Ranks.add(new learningUnit("Rose","153333","3.90","3.22"));


        System.out.println();
        for(learningUnit l: Ranks)
            System.out.println(l);
    }
}

class theRank implements Comparator<learningUnit>
{
    @Override
    public int compare(learningUnit o1, learningUnit o2) {
        if(o1.getaGPA().compareTo(o2.getaGPA())==0)
        {
            if(o1.getwGAP().compareTo(o2.getwGAP())==0)
            {
                return o1.getIdNum().compareTo(o2.getIdNum());
            }
            else
            {
                return o1.getwGAP().compareTo(o2.getwGAP());

            }
        }
        else
        {
            return o1.getaGPA().compareTo(o2.getaGPA());

        }
    }

}

class learningUnit
{
    String name,idNum, aGPA,wGAP;

    public learningUnit(String name, String idNum, String aGPA, String wGAP) {
        this.name = name;
        this.idNum = idNum;
        this.aGPA = aGPA;
        this.wGAP = wGAP;
    }

    public String getIdNum() {
        return idNum;
    }

    public String getaGPA() {
        return aGPA;
    }

    public String getwGAP() {
        return wGAP;
    }

    @Override
    public String toString() {
        return "Name: " +name+ "|| ID number:" +idNum+ "|| Average GPA:" + aGPA + "|| Whole GAP:" + wGAP;
    }
}