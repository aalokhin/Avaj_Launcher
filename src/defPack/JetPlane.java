package defPack;

/**
 * Created by aalokhin on 2/2/19.
 */
public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    protected JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
       // System.out.println("this is new jet " + name + " " + coordinates.getLongitude() + " " + coordinates.getLatitude() +" " + coordinates.getHeight() );
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("JetPlane " + this.name + "(" + this.id + ")" + " registered to weather tower.");
        Result.resultBuilder.append("JetPlane " + this.name + "(" + this.id + ")" + " registered to weather tower.\n");

    }


    public void updateConditions()
    {
        String weather= this.weatherTower.getWeather(this.coordinates);
        if(weather == "SNOW") {
            this.coordinates.setNewCoordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
            System.out.println("JetPlane: I am likely to end up buried with snow.");
            Result.resultBuilder.append("JetPlane: I am likely to end up buried with snow.\n");

        }
        if(weather == "RAIN"){
            this.coordinates.setNewCoordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
            System.out.println("JetPlane: I want no flying, I want crying.");
            Result.resultBuilder.append("JetPlane: I want no flying, I want crying.\n");
        }
        if(weather == "FOG")
        {
            this.coordinates.setNewCoordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
            System.out.println("JetPlane: Here we go, Fog, again. Latitude crawls up.");
            Result.resultBuilder.append("JetPlane: Here we go, Fog, again. Latitude crawls up.\n");
        }
        else //SUN
        {
            this.coordinates.setNewCoordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
            System.out.println("JetPlane: Hey-Hey! This vicious circle of life makes me wanna fly.");
            Result.resultBuilder.append("JetPlane: Hey-Hey! This vicious circle of life makes me wanna fly.\n");
        }

        if (this.coordinates.getHeight() <= 0)
        {
            System.out.println("JetPlane#" + this.name + "(" + id + ") landing.");
            Result.resultBuilder.append("JetPlane#" + this.name + "(" + id + ") landing.\n");
            this.weatherTower.unregister(this);
            System.out.println("JetPlane#" + this.name + "(" + id + ") unregistered from weather tower.\n");
            Result.resultBuilder.append("JetPlane#" + this.name + "(" + id + ") unregistered from weather tower.\n");
        }
    }
}
//
//          SUN - Latitude increases with 10, Height increases with 2
//        ◦ RAIN - Latitude increases with 5
//        ◦ FOG - Latitude increases with 1
//        ◦ SNOW - Height decreases with 7
//(int longitude, int latitude, int height)

