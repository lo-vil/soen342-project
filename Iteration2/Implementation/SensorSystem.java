package Iteration2.Implementation;

import java.util.Objects;
import java.util.logging.Logger;

public class SensorSystem {

    private Integer numSensors;

    public SensorSystem() {

    }

    // deploy a new sensor or an existing sensor at the given location
    public static void deploySensor(Sensor sensorObj, Location location) {
        if (location == null) {
            System.out.println("Location is null. Try Again.");
            throw new IllegalArgumentException("Location is null");
        }
        if (SensorRegistry.findSensor(sensorObj.getID()) == null) {
            SensorRegistry.addSensorToList(sensorObj);
        }
        Sensor sensor = SensorRegistry.findSensor(sensorObj.getID());
        if (sensor==null) {
            System.out.println("Sensor not found, error adding the new sensor to the registry. Try Again.");
            throw new IllegalArgumentException("Sensor not found, error adding the new sensor to the registry");
        }

        boolean isDeployed = sensor.getIsDeployed();

        // Fetch sensor if there exists one for this location
        Sensor locationExists = SensorLocationPairings.locationExists(location);

        if (isDeployed && locationExists == null) {
            System.out.println("Sensor is already deployed. Try Again.");
            throw new IllegalArgumentException("Sensor is already deployed");
        }
        if (!isDeployed && locationExists != null) {
            System.out.println("Location is already used. Try Again.");
            throw new IllegalArgumentException("Location is already used");
        }
        if (isDeployed) {
            System.out.println("Sensor is already deployed and location is already used. Try Again.");
            throw new IllegalArgumentException("Sensor is already deployed and location is already used");
        }

        // Create a new pairing
        SensorLocationPairing<Sensor, Location> sensorLocationPairing = new SensorLocationPairing<>(sensor, location);
        // Add pairing to the list of SensorLocation Pairings
        SensorLocationPairings.addSensorLocationPairing(sensorLocationPairing);

        // Create a new pairing
        SensorTemperaturePairing<Sensor, Temperature> sensorTemperaturePairing = new SensorTemperaturePairing<>(sensor, SensorTemperaturePairing.generateRandomTemperature());
        // Add pairing to the list of SensorTemperature Pairings
        SensorTemperaturePairings.addSensorTemperaturePairing(sensorTemperaturePairing);

        // Set sensor to deployed
        sensor.setIsDeployed(true);

        // Log success
        Logger.getLogger(System.class.getName()).info("Successfully deployed sensor " + sensor.getID() + " at location " + location.getCoordinates());
    }

    // returns the temperature of the sensor
    public static String readTemperature(Location location) {
        if (location == null) {
            System.out.println("Location is null. Try Again.");
            throw new IllegalArgumentException("Location is null");
        }
        
        // Fetch sensor if there exists one for this location
        Sensor sensor = SensorLocationPairings.locationExists(location);

        if(sensor != null){
            return Objects.requireNonNull(SensorTemperaturePairings.getPairing(sensor.getID())).toString();
        } else {
            System.out.println("Sensor not found. Try Again.");
            throw new IllegalArgumentException("Sensor not found");
        }
    }

    // returns a list that contains the sensorID with its corresponding location (using sensorLocationPairings list) and temperature
    public static String getAllLocationsWithTemperatures() {
        StringBuilder status = new StringBuilder();
        for (SensorLocationPairing<Sensor, Location> sensorLocationPairing : SensorLocationPairings.getSensorLocationPairings()) {
            Sensor sensor = sensorLocationPairing.getSensor();
            Location location = sensorLocationPairing.getLocation();
            Temperature temperature = SensorTemperaturePairings.getPairing(sensor.getID());

            status.append("Sensor ID: ").append(sensor.getID()).append(" is deployed at ").append(location.getCoordinates()).append(" and has a temperature of ").append(temperature.toString()).append("\n");
        }
        return status.toString();
    }
}
