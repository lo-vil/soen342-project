package Iteration1.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class SensorRegistry {
    Sensor sensor;

    private static final List<SensorRegistry> registry = new ArrayList<>();

    public SensorRegistry(Sensor sensor) {
        this.sensor = sensor;
    }

    // Getter for the registry list
    public static List<SensorRegistry> getRegistry() {
        return registry;
    }

    // Adds instance of the new obj to the registry list
    public static void addSensorToList(Sensor sensor) {
        registry.add(new SensorRegistry(sensor));

        Logger.getLogger(SensorRegistry.class.getName()).info("Added sensor to registry list");
    }

    // Method to find a sensor in the registry list
    public static Sensor findSensor(Integer id) {
        for (SensorRegistry sensorInList : getRegistry()) {
            if (Objects.equals(sensorInList.sensor.getID(), id)) {
                return sensorInList.sensor;
            }
        }
        return null;
    }

    // Method to find if a sensor is deployed
    public boolean isDeployed(Integer id) {
        Sensor sensor = findSensor(id);

        if (sensor != null) {
            return sensor.getIsDeployed();
        }
        throw new IllegalArgumentException("Sensor not found");
    }

    // Method to find number of sensors in the registry list
    public Integer getNbOfSensors() {
        return registry.size();
    }
}
