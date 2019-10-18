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
       // System.out.println("this is new helicopter " + name + " " + coordinates.getLongitude() + " " + coordinates.getLatitude() +" " + coordinates.getHeight() );
    }
    public void updateConditions()
    {
        String weather= this.weatherTower.getWeather(this.coordinates);
        if(weather == "SNOW") {
            this.coordinates.setNewCoordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
            System.out.println("Helicoopter: can't bear it. too much snow.");
            Result.resultBuilder.append("Helicoopter: can't bear it. too much snow.\n");
        }
        if(weather == "RAIN"){
            this.coordinates.setNewCoordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
            System.out.println("Helicoopter: Singing in the rain.");
            Result.resultBuilder.append("Helicoopter: Singing in the rain.\n");
        }
        if(weather == "FOG")
        {
            this.coordinates.setNewCoordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
            System.out.println("Helicoopter: Fog? Whatever.");
            Result.resultBuilder.append("Helicoopter: Fog? Whatever.\n");
        }
        else //SUN
        {
            this.coordinates.setNewCoordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
            System.out.println("Helicoopter: Sun is good.");
            Result.resultBuilder.append("Helicoopter: Sun is good.\n");
        }
//
//        if (this.coordinates.getHeight() <= 0)
//        {
//            System.out.println("Helicoopter#" + this.name + "(" + id + ") landing.");
//            this.weatherTower.unregister(this);
//            System.out.println("Helicoopter#" + this.name + "(" + id + ") unregistered from weather tower.");
//        }
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
