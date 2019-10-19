package defPack;

/**
 * Created by aalokhin on 2/2/19.
 */
public class WeatherTower extends Tower
{
    private WeatherProvider provider;

    public String getWeather(Coordinates coordinates)
    {
        WeatherProvider weatherGetter = provider.getProvider();
        return (weatherGetter.getCurrentWeather(coordinates));

    }
    void changeWeather()
    {
        super.conditionsChanged();
    }

}
