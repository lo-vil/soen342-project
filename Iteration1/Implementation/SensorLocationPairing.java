package Iteration1.Implementation;

public class SensorLocationPairing<Sensor, Location> {
    private Sensor sensor;
    private Location location;

    public SensorLocationPairing(){
        this.sensor = null;
        this.location = null;
    }

    public SensorLocationPairing(Sensor sensor, Location location){
        this.sensor = sensor;
        this.location = location;
    }
    
    public Sensor getSensor(){
        return this.sensor;
    }

    public Location getLocation(){
        return this.location;
    }
}
