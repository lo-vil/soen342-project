package Iteration2.Implementation;

import java.util.Random;
import java.util.logging.Logger;

public class Sensor {
    private final Integer _ID;
    private Boolean _isDeployed;

    //constructor
    public Sensor() {
        _ID = createUniqueID();
        _isDeployed = false;

        Logger.getLogger(Sensor.class.getName()).info("Created sensor with ID: " + _ID);
    }

    //creates an ID between 1000 and 9999
    private Integer createUniqueID() {
        int uniqueID;
        do {
            uniqueID = 1000 + new Random().nextInt(9000);
        } while (SensorRegistry.findSensor(_ID) != null);

        return uniqueID;
    }

    //creates a new sensor
    public Sensor createSensor() {
        return new Sensor();
    }

    //getter and setter methods
    public Integer getID() {
        return _ID;
    }

    public Boolean getIsDeployed() {
        return _isDeployed;
    }

    public void setIsDeployed(Boolean isDeployed) {
        _isDeployed = isDeployed;
    }



}
