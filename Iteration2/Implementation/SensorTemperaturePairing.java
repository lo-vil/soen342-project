package Iteration2.Implementation;

import java.util.Random;

public class SensorTemperaturePairing<S, T> {
    private final S sensor;

    // Constructor
    public SensorTemperaturePairing(S sensor, T temperature) {
        this.sensor = sensor;
    }

    // Generate random temperature
    public static Temperature generateRandomTemperature() {
        Random rand = new Random();
        float randomTempValue = -40.0f + 80.0f * rand.nextFloat();
        return new Temperature(randomTempValue, "C");
    }

    // Getter methods
    public T getTemperature() {
        return (T) generateRandomTemperature();
    }

    public S getSensor() {
        return sensor;
    }
}