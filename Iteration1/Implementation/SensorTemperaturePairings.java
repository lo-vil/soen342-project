package Iteration1.Implementation;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class SensorTemperaturePairings {
    private List<SensorTemperaturePairing> pairings;

    private static SensorTemperaturePairings instance = null;

    private SensorTemperaturePairings(){
        pairings = new ArrayList<>();
    }
    
    public static SensorTemperaturePairings getInstance(){
        if (instance == null){
            instance = new SensorTemperaturePairings();
        }
        return instance;
    }

    //Add pairing
    public void addPairing(Integer sensorId){
        SensorTemperaturePairing newPairing = new SensorTemperaturePairing(sensorId);
        pairings.add(newPairing);
        
    }

    //Update Temperature
    public void updateSensorTemperature(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(pairings.size());
        pairings.get(randomIndex).updateRandomTemperature();
    }


    //Get pairing by sensorId
    public Temperature getPairing(Integer sensorId){
        for(SensorTemperaturePairing pairing: pairings){
            if(Objects.equals(pairing.getSensorId(), sensorId)){
                return pairing.getTemperature();
            }
        }
        return null;
    }
}
