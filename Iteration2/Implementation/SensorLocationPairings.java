package Iteration2.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SensorLocationPairings {
    private static List<SensorLocationPairing<Sensor, Location>> sensorLocationPairings = new ArrayList<>();

    // Add Pairing
    public static void addSensorLocationPairing(SensorLocationPairing<Sensor, Location> pairing){
        try{
            sensorLocationPairings.add(pairing);
            Logger.getLogger(SensorTemperaturePairings.class.getName()).info("Added sensor to location pairing list");
        } catch(Exception e){
            Logger.getLogger(SensorLocationPairings.class.getName()).severe(e.getMessage());
        }
    }

    // Check if location is paired to a sensor
    public static Sensor locationExists(Location location){
        for (SensorLocationPairing<Sensor, Location> sensorLocationPairing : sensorLocationPairings) {
            if (sensorLocationPairing.getLocation().equals(location)) {
                return sensorLocationPairing.getSensor();
            }
        }
        return null;
    }

    public static Integer getNbOfSensorLocationPairings() {
        return sensorLocationPairings.size();
    }

    public static List<SensorLocationPairing<Sensor, Location>> getSensorLocationPairings() {
        return sensorLocationPairings;
    }

    // Replace Sensor given the oldSensor is paired and newSensor isn't
    public static void replaceSensor(Sensor oldSensor, Sensor newSensor){
        for (int i = 0; i < sensorLocationPairings.size(); i++){
            if(sensorLocationPairings.get(i).getSensor().equals(oldSensor)){
                sensorLocationPairings.set(i, new SensorLocationPairing<Sensor, Location>(newSensor, sensorLocationPairings.get(i).getLocation()));
                System.out.println("newSensor (id: " + newSensor.getID() + ") has now replaced oldSensor (id: " + oldSensor.getID() + ") in the SensorLocationPairings");
            }
        }
    }
}
