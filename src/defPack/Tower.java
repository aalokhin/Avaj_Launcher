package defPack;
import java.util.*;


/**
 * Created by aalokhin on 2/2/19.
 */
public class Tower {

    private List<Flyable>  aircrafts = new ArrayList<Flyable>();

    public void register(Flyable flyable)
    {
        if (aircrafts.contains(flyable))
            return;

        aircrafts.add(flyable);
        Result.resultBuilder.append("Tower says: ");

    }
    public void unregister(Flyable flyable)
    {
        aircrafts.remove(flyable);
        Result.resultBuilder.append("Tower says: ");

    }

    protected void conditionsChanged()
    {

        for (int i = 0; i < aircrafts.size(); i++)
        {
            aircrafts.get(i).updateConditions();
        }

//concurrent modification exception
//        for (Flyable aircraft: this.aircrafts)
//        {
//            aircraft.updateConditions();
//        }
    }
}
