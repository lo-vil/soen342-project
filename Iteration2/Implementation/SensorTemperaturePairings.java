package Iteration2.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SensorTemperaturePairings {


    private static final List<SensorTemperaturePairing<Sensor, Temperature>> sensorTemperaturePairings = new ArrayList<>();

    //Add pairing
    public static void addSensorTemperaturePairing(SensorTemperaturePairing<Sensor, Temperature> pairing){
        try{
            sensorTemperaturePairings.add(pairing);
            Logger.getLogger(SensorTemperaturePairings.class.getName()).info("Added sensor to temperature pairing list");
        } catch(Exception e){
            Logger.getLogger(SensorTemperaturePairings.class.getName()).severe(e.getMessage());
        }
    }

    //Get pairing by sensorId
    public static Temperature getPairing(Integer sensorId){
        for (SensorTemperaturePairing<Sensor, Temperature> sensorTemperaturePairing : sensorTemperaturePairings) {
            if (sensorTemperaturePairing.getSensor().getID().equals(sensorId)) {
                return sensorTemperaturePairing.getTemperature();
            }
        }
        return null;
    }

    public static Integer getNbOfSensorTemperaturePairings() {
        return sensorTemperaturePairings.size();
    }

    // Replace Sensor given the oldSensor is paired and newSensor isn't
    public static void replaceSensor(Sensor oldSensor, Sensor newSensor){
        for (int i = 0; i < sensorTemperaturePairings.size(); i++){
            if(sensorTemperaturePairings.get(i).getSensor().equals(oldSensor)){
                sensorTemperaturePairings.set(i, new SensorTemperaturePairing<>(newSensor, sensorTemperaturePairings.get(i).getTemperature()));
                System.out.println("newSensor (id: " + newSensor.getID() + ") has now replaced oldSensor (id: " + oldSensor.getID() + ") in the SensorTemperaturePairings");
            }
        }
    }
}
