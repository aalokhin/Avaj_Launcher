package defPack;

/**
 * Created by aalokhin on 2/2/19.
 */
public class Baloon extends Aircraft {
    private WeatherTower weatherTower;
    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }
    public void updateConditions (){

    }
    public void registerTower(WeatherTower weatherTower, Coordinates coordinates)
    {
        this.weatherTower = weatherTower;

    }
}
