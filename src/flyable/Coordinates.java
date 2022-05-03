package flyable;

import simulator.InvalidCoordinateException;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    private Coordinates(int longitude, int latitude, int height) throws InvalidCoordinateException{
        if (longitude < 0 || latitude < 0 || height < 0) {
            throw new InvalidCoordinateException("Value can not be negative.");
        }
        this.longitude = longitude;
        this.latitude = latitude;
        if (height > 100) {
            height = 100;
        }
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void changeLongitudeBy(int value) throws InvalidCoordinateException{
        longitude += value;
        if (longitude < 0) {
            throw new InvalidCoordinateException("Value can not be negative.");
        }
    }

    public void changeLatitudeBy(int value) throws InvalidCoordinateException{
        latitude += value;
        if (latitude < 0) {
            throw new InvalidCoordinateException("Value can not be negative.");
        }
    }

    public void changeHeightBy(int value) {
        height += value;
        if (height > 100) {
            height = 100;
        }
        if (height < 0) {
            height = 0;
        }
    }

}
