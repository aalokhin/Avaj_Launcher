package defPack;
import java.util.Random;
/**
 * Created by aalokhin on 2/2/19.
 */

public class WeatherProvider
{
    private static WeatherProvider weatherProvider = null;

    private String[] weather = {"SUN", "FOG", "RAIN", "SNOW"};

    private WeatherProvider()
    {

        System.out.println("weather provider here");
    }

    public static WeatherProvider getProvider()
    {
        if (weatherProvider != null)
            return weatherProvider;
        else {
            weatherProvider = new WeatherProvider();
            return weatherProvider;
        }

    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        Random rand = new Random();
        return (this.weather[rand.nextInt(4)]);
    }
}