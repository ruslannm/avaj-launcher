package simulator;

import Tower.Tower;
import Tower.WeatherTower;
import flyable.AircraftFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
    public static void main(String[] args) {
        int count = 0;
        String[] airctaft;
        int longitude = 0;
        int latitude = 0;
        int height = 0;
        if (args.length != 1) {
            System.out.println("Usage: java avajl-auncher.simulator.Simulator <scenario>");
            System.exit(-1);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line = br.readLine();
            if (line.isEmpty()) {
                System.out.println("First line can not be empty!");
                System.exit(-1);
            }
            try {
                count = Integer.parseInt(line.trim());
                if (count < 0) {
                    System.out.println("Number of time the simulations can't be negative!");
                    System.exit(-1);
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
                System.exit(-1);
            }
            AircraftFactory aircraftFactory = new AircraftFactory();
            Tower tower = new WeatherTower();
            while (!((line = br.readLine()) == null)) {
                airctaft = line.trim().split("\s+");
                if (airctaft.length != 5) {
                    System.out.println("Invalid line: " + line);
                    System.exit(-1);
                }
                try {
                    longitude = Integer.parseInt(airctaft[2]);
                    latitude = Integer.parseInt(airctaft[3]);
                    height = Integer.parseInt(airctaft[4]);
                }catch (NumberFormatException e) {
                    System.out.println(e);
                    System.exit(-1);
                }
                tower.register(aircraftFactory.newAircraft(airctaft[0], airctaft[1], longitude, latitude, height));
            }
            for (int i = 0; i < count; i++){
                tower.changeWeather();

            }
        } catch (InvalidCoordinateException e){
            System.out.println(e);
            System.exit(-1);
        }
        catch (IOException e) {
            System.out.println(e);
            System.exit(-1);
        }


    }


    public static void writeLog(String message) {
        System.out.println(message);
    }

    ;


}
