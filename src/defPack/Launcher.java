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
        //System.out.println("hey hey");
        for (Flyable flyable: this.flyables)
        {
            flyable.registerTower(tower);
        }
        for (int i = 0; i < changes; i++)
        {
            tower.changeWeather();

        }
    }

}
