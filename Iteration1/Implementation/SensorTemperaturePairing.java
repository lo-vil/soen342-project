package Iteration1.Implementation;
import java.util.Random;

public class SensorTemperaturePairing{
    private final Integer sensorId;
    private Temperature temperature;


    //Constructor
    public SensorTemperaturePairing(Integer sensorId){
        this.sensorId = sensorId;
        this.temperature = generateRandomTemperature();
    }

    private Temperature generateRandomTemperature(){
        Random rand = new Random();
        float randomTempValue = -40.0f + 80.0f * rand.nextFloat();
        return new Temperature(randomTempValue, "C");
    }
    public Temperature getTemperature(){
        return generateRandomTemperature();
    }
    public Integer getSensorId(){
        return sensorId;
    }

}
