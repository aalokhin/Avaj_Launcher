package defPack;
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
        String message;
        int longt = 0;
        int lat = 0;
        int height = 0;

        if(weather == "SNOW") {
            longt = this.coordinates.getLongitude();
            lat = this.coordinates.getLatitude();
            height = this.coordinates.getHeight() - 12;
            message = "Helicoopter#" + this.name + "(" + this.id + ")" + ": can't bear it. too much snow.\n";

        }
        else if(weather == "RAIN"){
            longt = this.coordinates.getLongitude() + 5;
            lat = this.coordinates.getLatitude();
            height = this.coordinates.getHeight();
            message = "Helicoopter#" + this.name + "(" + this.id + ")" + ": Singing in the rain.\n";
        }
        else if(weather == "FOG")
        {
            longt = this.coordinates.getLongitude() + 1;
            lat = this.coordinates.getLatitude();
            height = this.coordinates.getHeight() + 2;
            message = "Helicoopter#" + this.name + "(" + this.id + ")" + ": Fog? Whatever.\n";

        }
        else //SUN
        {
            longt = this.coordinates.getLongitude() + 10;
            lat = this.coordinates.getLatitude();
            height = this.coordinates.getHeight() + 2;
            message = "Helicoopter#" + this.name + "(" + this.id + ")" + ": Sun is good.\n";
        }

        System.out.println( "the longt before  is : =======> " + longt);
        System.out.println( "the lat  before is : =======> " + lat);
        System.out.println( "the height  before is : =======> " + height);

        this.coordinates.setNewCoordinates(longt, lat, height);

        System.out.println( "the longt after  is : =======> " +  this.coordinates.getLongitude());
        System.out.println( "the lat  after is : =======> " +  this.coordinates.getLatitude());
        System.out.println( "the height  after is : =======> " +  this.coordinates.getHeight());

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

//• Helicopter:
//        ◦ SUN - Longitude increases with 10, Height increases with 2
//        ◦ RAIN - Longitude increases with 5
//        ◦ FOG - Longitude increases with 1
//        ◦ SNOW - Height decreases with 12

// If an aircraft needs to pass the upper limit height it remains at 100.
//If an aircraft reaches height 0 or needs to go below it, the aircraft lands, unregisters from the weather tower and logs its current coordinates.