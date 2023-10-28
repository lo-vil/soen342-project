package Iteration1.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SensorLocationPairings {
    private static List<SensorLocationPairing<Sensor, Location>> sensorLocationPairings = new ArrayList<SensorLocationPairing<Sensor, Location>>();

    public static void addSensorLocationPairing(SensorLocationPairing<Sensor, Location> pairing){
        try{
            sensorLocationPairings.add(pairing);
        } catch(Exception e){
            Logger.getLogger(SensorLocationPairings.class.getName()).severe(e.getMessage());
        }
    }

    public static Sensor locationExists(Location location){
        for(int i = 0; i < sensorLocationPairings.size(); i++){
            if(sensorLocationPairings.get(i).getLocation().equals(location)){
                return sensorLocationPairings.get(i).getSensor();
            }
        }
        return null;
    }
}
