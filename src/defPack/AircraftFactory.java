package defPack;

/**
 * Created by aalokhin on 2/2/19.
 */


public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        String whatType = type.toLowerCase();


        Flyable Aircraft = whatType.equals("baloon") ? new Baloon(name, coordinates) : (whatType.equals("helicopter")
                ? new Helicopter(name, coordinates) : (whatType.equals("jetplane") ? new JetPlane(name, coordinates) : null));

        return Aircraft;
    }
}
