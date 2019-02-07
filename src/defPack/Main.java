package defPack;
import java.io.*;

import java.io.FileNotFoundException;
/**
 * Created by aalokhin on 2/2/19.
 */
public class Main {
    public static void main(String[] args)
            throws FileNotFoundException
    {

        if(args.length < 1)
        {
            System.out.println("=))))) Error, usage: java ClassName inputfile");
            System.exit(1);
            return ;
        }

        File Scenario = new File("simulation.txt");

// ***************************************************        reading file *******************

        String input = args[0];

        File inputFile = new File(input);
        BufferedReader br = null;


        try
        {
            br = new BufferedReader(new FileReader(inputFile));
            String st = null;

            while ((st = br.readLine()) != null)
            {
                System.out.println(st);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
            }
        }


       // FileReader fr = new FileReader;


       // BufferedReader br = new BufferedReader(new FileReader(input));

//        String st;
//        while ((st = br.readLine()) != null)
//

        System.out.println("hello from simulator again");
    }
}
