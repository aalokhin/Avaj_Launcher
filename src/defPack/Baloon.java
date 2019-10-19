package defPack;

/**
 * Created by aalokhin on 2/2/19.
 */
public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;


    protected Baloon(String name, Coordinates coordinates)
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
        System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        Result.resultBuilder.append("Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.\n");
    }
}
