package Iteration1.Implementation;

import java.util.logging.Logger;

public class SensorSystem {

    private Integer numSensors;

    public void system () {

    }

    // deploy a new sensor or an existing sensor at the given location
    public void deploySensor(Sensor sensorObj, Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Location is null");
        }
        if (SensorRegistry.findSensor(sensorObj.getID()) == null) {
            SensorRegistry.addSensorToList(sensorObj);
        }
        Sensor sensor = SensorRegistry.findSensor(sensorObj.getID());
        if (sensor==null) {
            throw new IllegalArgumentException("Sensor not found, error adding the new sensor to the registry");
        }

        boolean isDeployed = sensor.getIsDeployed();

        // Fetch sensor if there exists one for this location
        Sensor locationExists = SensorLocationPairings.locationExists(location);

        if (isDeployed && locationExists == null) {
            throw new IllegalArgumentException("Sensor is already deployed");
        }
        if (!isDeployed && locationExists != null) {
            throw new IllegalArgumentException("Location is already used");
        }
        if (isDeployed) {
            throw new IllegalArgumentException("Sensor is already deployed and location is already used");
        }

        // Create Pairing
        SensorLocationPairing<Sensor, Location> pairing = new SensorLocationPairing<Sensor, Location>(sensor, location);

        // Add pairing to the list of SensorLocation Pairings
        SensorLocationPairings.addSensorLocationPairing(pairing);

        sensor.setIsDeployed(true);

        Logger.getLogger(System.class.getName()).info("Successfully deployed sensor " + sensor.getID() + " at location " + location.getCoordinates());
    }

    // returns the temperature of the sensor
    public float readTemperature(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Location is null");
        }
        
        // Fetch sensor if there exists one for this location
        Sensor sensor = SensorLocationPairings.locationExists(location);

        // TODO
        if(sensor != null){
            return updateSensorTemperature(sensor.getID());
        }
        return 0;
    }




}
