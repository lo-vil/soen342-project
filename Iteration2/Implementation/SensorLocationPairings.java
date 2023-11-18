package Iteration2.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SensorLocationPairings {
    private static List<SensorLocationPairing<Sensor, Location>> sensorLocationPairings = new ArrayList<>();

    public static void addSensorLocationPairing(SensorLocationPairing<Sensor, Location> pairing){
        try{
            sensorLocationPairings.add(pairing);
            Logger.getLogger(SensorTemperaturePairings.class.getName()).info("Added sensor to location pairing list");
        } catch(Exception e){
            Logger.getLogger(SensorLocationPairings.class.getName()).severe(e.getMessage());
        }
    }

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
}
