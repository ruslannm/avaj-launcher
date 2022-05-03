package flyable;

import simulator.InvalidCoordinateException;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws InvalidCoordinateException {
        Coordinates coordinates = null;
        try {
            coordinates = new Coordinates(longitude, latitude, height);
        } catch (InvalidCoordinateException e) {
            throw e;
        }
        switch (type) {
            case "JetPlane": {
                return new JetPlane(name, coordinates);
            }
            case "Helicopter": {
                return new Helicopter(name, coordinates);
            }
            case "Baloon": {
                return new Baloon(name, coordinates);
            }
            default: {
                System.out.println("Invalid type: " + type + ".");
                System.exit(-1);
                return null;
            }
        }
    }
}
