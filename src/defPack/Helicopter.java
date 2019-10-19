package defPack;
import java.util.HashMap;
/**
 * Created by aalokhin on 2/2/19.
 */

public class Helicopter extends Aircraft implements Flyable
{

    private WeatherTower weatherTower;

    protected Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        HashMap<String, WeatherUpdateResult> weatherUpdateResult = new HashMap<String, WeatherUpdateResult>(){{
            put("SUN", new WeatherUpdateResult(10, 0, 2, "Can't bear it. too much snow.\n"));
            put("SNOW", new WeatherUpdateResult(0, 0, -12, "Sun is good.\n"));
            put("RAIN", new WeatherUpdateResult(5, 0, 0, "Singing in the rain.\n"));
            put("FOG", new WeatherUpdateResult(1, 0, 0, "Fog? Whatever.\\n"));
        }};
        String message =  "Helicoopter#" + this.name + "(" + this.id + ") : " + weatherUpdateResult.get(weather).getMessage();
        int longt = this.coordinates.getLongitude() + weatherUpdateResult.get(weather).addLongitude;
        int lat = this.coordinates.getLatitude() + weatherUpdateResult.get(weather).addLongitude;
        int height = this.coordinates.getHeight() + weatherUpdateResult.get(weather).addLongitude;
        this.coordinates.setNewCoordinates(longt, lat, height);
        if (this.coordinates.getHeight() <= 0)
        {
            message = "Helicoopter#" + this.name + "(" + id + ") landing.\n";
            this.weatherTower.unregister(this);
            message += "Helicoopter#" + this.name + "(" + id + ") unregistered from weather tower.\n";
        }
        System.out.println(message);
        Result.resultBuilder.append(message);

    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        Result.resultBuilder.append("Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.\n");
    }
}



// If an aircraft needs to pass the upper limit height it remains at 100.
//If an aircraft reaches height 0 or needs to go below it, the aircraft lands, unregisters from the weather tower and logs its current coordinates.