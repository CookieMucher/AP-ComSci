import java.util.ArrayList;

/**
 * Created by Hank on 2/19/2017.
 */
public class APCS_604_Cities
{
}

class Cities
{
    ArrayList<City> several;

    public Cities(ArrayList<City> several) {
        this.several = several;
    }

//    public static City[] mergeSort(City[] a)
//    {
//        if(a.length==1)
//        {
//            return a;
//        }
//
//
//    }
}

class City
{
    private String name, state;
    private int population;

    public City(String name, String state, int population) {
        this.name = name;
        this.state = state;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }
}

