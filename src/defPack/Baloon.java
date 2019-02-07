package defPack;

/**
 * Created by aalokhin on 2/2/19.
 */
public class Baloon extends Aircraft implements Flyable {
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

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
