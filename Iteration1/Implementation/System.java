package Iteration1.Implementation;

import java.util.logging.Logger;

public class System {

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
        SensorLocationPairings locationExists = SensorLocationPairings.locationExists(location);

        if (isDeployed && locationExists == null) {
            throw new IllegalArgumentException("Sensor is already deployed");
        }
        if (!isDeployed && locationExists != null) {
            throw new IllegalArgumentException("Location is already used");
        }
        if (isDeployed) {
            throw new IllegalArgumentException("Sensor is already deployed and location is already used");
        }

        SensorLocationPairing.createPairing(sensor, location);

        sensor.setIsDeployed(true);

        Logger.getLogger(System.class.getName()).info("Successfully deployed sensor " + sensor.getID() + " at location " + location.getCoordinates());
    }

    // returns the temperature of the sensor
    public float readTemperature(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Location is null");
        }
        Sensor sensor = SensorLocationPairings.getSensorFromLocation(location);

        return updateSensorTemperature(sensor.getID());
    }




}
