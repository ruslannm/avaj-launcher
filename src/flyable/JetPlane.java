package flyable;

import Tower.WeatherTower;

import static simulator.Simulator.writeLog;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private static final String AIRCRAFT_TYPE = "JetPlane";

    private JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public Aircraft(String name, Coordinates coordinates

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String message;
        switch (weather) {
            case "SUN":
                message = "This is hot.";
                coordinates.changeLatitudeBy(10);
                coordinates.changeHeightBy(2);
                break;
            case "RAIN":
                message = "Heaven, don't cry!";
                coordinates.changeLatitudeBy(5);
                break;
            case "FOG":
                message = "We go into the fog.";
                coordinates.changeLatitudeBy(1);
                break;
            case "SNOW":
                message = "My rotor is going to freeze!";
                coordinates.changeHeightBy(-7);
                break;
            default:
                message = "";
        }
        writeLog(AIRCRAFT_TYPE + "#" + name + "(" + id + "): " + message);
        if (coordinates.getHeight() == 0) {
            weatherTower.unregister(this);
            writeLog(AIRCRAFT_TYPE + "#" + name + "(" + id + "): landing at [" + coordinates.getLongitude() + ", " + coordinates.getLatitude() + "].");
        }
    }


    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
