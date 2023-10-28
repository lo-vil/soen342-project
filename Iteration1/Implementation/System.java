package Iteration1.Implementation;

import java.util.logging.Logger;

public class System {

    private Integer numSensors;

    public void system () {

    }

    // deploy a new sensor or an existing sensor at the given location
    public void deploySensor(Sensor sensorObj, String coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Location is null");
        }
        if (SensorRegistry.findSensor(sensorObj.getID()) == null) {
            //sensor.setIsDeployed(true);  not right place
            SensorRegistry.addSensorToList(sensorObj);
        }
        Sensor sensor = SensorRegistry.findSensor(sensorObj.getID());
        if (sensor==null) {
            throw new IllegalArgumentException("Sensor not found, error adding the new sensor to the registry");
        }

        boolean isDeployed = sensor.getIsDeployed();
        boolean locationExists = SensorLocationPairings.locationExists(coordinates);

        if (isDeployed && !locationExists) {
            throw new IllegalArgumentException("Sensor is already deployed");
        }
        if (!isDeployed && locationExists) {
            throw new IllegalArgumentException("Location is already used");
        }
        if (isDeployed) {
            throw new IllegalArgumentException("Sensor is already deployed and location is already used");
        }

        Location.createLocation(coordinates);
        SensorLocationPairing.createPairing(sensor, coordinates);

        sensor.setIsDeployed(true);

        Logger.getLogger(System.class.getName()).info("Successfully deployed sensor " + sensor.getID() + " at location " + coordinates);
    }

    // returns the temperature of the sensor
    public float readTemperature(String coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Location is null");
        }
        SensorLocationPairings pairingObj = SensorLocationPairings.pairingObjAtLocation(coordinates);
        if (pairingObj == null) {
            throw new IllegalArgumentException("Location is not used");
        }

        return updateSensorTemperature(pairingObj.sensor.getID());
    }




}
