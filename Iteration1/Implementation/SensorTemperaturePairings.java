package Iteration1.Implementation;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class SensorTemperaturePairings {
    private List<SensorTemperaturePairing> pairings = new ArrayList<>();

    private static final SensorTemperaturePairings instance = new SensorTemperaturePairings();

    private SensorTemperaturePairings(){
    }
    
    public static SensorTemperaturePairings getInstance(){
        return instance;
    }

    //Add pairing
    public void addPairing(Integer sensorId){
        SensorTemperaturePairing newPairing = new SensorTemperaturePairing(sensorId);
        pairings.add(newPairing);
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
