package flyable;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = getIdCounter();
    }

    private long getIdCounter(){
        return ++idCounter;
    }

    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }

}
