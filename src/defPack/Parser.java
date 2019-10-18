package defPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    private BufferedReader reader;
    private ArrayList<Flyable> flyables;
    private AircraftFactory factory;
    private WeatherTower tower;
    private int changes;

    public Parser(BufferedReader reader) {
        this.reader = reader;
        this.factory = new AircraftFactory();
        this.tower = new WeatherTower();
        this.flyables = new ArrayList<Flyable>();
        this.changes = 0;

        extractObjects();
    }

    public ArrayList<Flyable> getFlyables() {
        return flyables;
    }

    public AircraftFactory getFactory() {
        return factory;
    }

    public WeatherTower getTower() {
        return tower;
    }

    public int getChanges() {
        return changes;
    }

    private void extractObjects() {
        String[] parse;
        String line = null;
        int i = 0;

        try {
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                if (line.isEmpty()) {
                    System.out.println("Error: first line of scenario file must be an integer.");
                    continue;
                }
                if (line != null && !line.isEmpty() && i == 0) {
                    try {
                        this.changes = Integer.parseInt(line);
                        i++;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error: first line of scenario file must be an integer.");
                        return;
                    }
                } else if (!line.isEmpty() && i != 0) {
                    parse = line.split(" ");
                    if (parse.length != 5) {
                        System.out.println("=))))) Error on line " + i + "! String should  have the type, name, coordinate x, coordinate y and coordinate z ");
                        System.exit(1);
                        return;
                    } else {

                        try {
                            String aircraftType = parse[0].toLowerCase();
                            String name = parse[1];
                            int longitude = Integer.parseInt(parse[2]);
                            int latitude = Integer.parseInt(parse[3]);
                            int height = Integer.parseInt(parse[4]);
                            //System.out.println("type : " + aircraftType + " name: " + name + " a " + a + " b " + b + " c "+ c);
                            flyables.add(factory.newAircraft(aircraftType, name, longitude, latitude, height));
                        } catch (NumberFormatException nfe) {
                            System.out.println("Error on line " + i + ": coordinates integers.");
                            return;
                        } catch (Exception ex) {
                            System.out.println("Error: I don't know what : " + ex.getLocalizedMessage());
                            return;
                        }
                    }
                }

                i++;
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
