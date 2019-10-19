package defPack;

import java.util.ArrayList;

public class Launcher
{
    private ArrayList<Flyable> flyables;
    AircraftFactory factory;
    WeatherTower tower;
    int changes;

    Launcher(ArrayList<Flyable> flyables, AircraftFactory factory, WeatherTower tower, int changes)
    {
        this.flyables = flyables;
        this.factory = factory;
        this.tower = tower;
        this.changes = changes;
    }

    public void launchScenario()
    {
        for (Flyable flyable: this.flyables)
        {
            flyable.registerTower(tower);
        }
        System.out.println("here we gooo----------------------------------------------------------");
        int i = 0;
        for ( i = 0; i < changes; i++)
        {
            tower.changeWeather();
            System.out.println("------------------------ change weather ----------------------------------");


        }
        System.out.println("Ended with: \n  i == " + i + "  \nchanges : " + changes);

    }

}
