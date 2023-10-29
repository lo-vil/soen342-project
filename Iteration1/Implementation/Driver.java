package Iteration1.Implementation;

public class Driver {
    public static void main(String[] args) {
        //create a new sensor
        Sensor sensor1 = new Sensor();
        // Print the sensor ID and deployment status
        System.out.println("Sensor 1 has been created with the ID: " + sensor1.getID() + " and deployed value is: " + sensor1.getIsDeployed());
        //create a new location
        Location location1 = new Location("1234 Fake Street", "A1B2C3", "NL", "Canada", "47.567, -52.712");

        //deploy the sensor at the location
        SensorSystem.deploySensor(sensor1, location1);

        // Print the sensor ID and deployment status
        System.out.println("Sensor 1 has been deployed with the ID: " + sensor1.getID() + " and deployed value is: " + sensor1.getIsDeployed());

        // Print the temperature of the sensor
        System.out.println("Sensor 1 has a temperature of: " + SensorSystem.readTemperature(location1));

        /*
         * At this point a sensor has been created with a location and a temperature pairing
         */

        //create a new sensor
        Sensor sensor2 = new Sensor();

        //Error handling testing
        boolean errorTest = false;

        if (errorTest) {
            // Let's try to deploy a new sensor at an existing location
            SensorSystem.deploySensor(sensor2, location1);

            // Let's try to deploy a deployed sensor at an existing location
            SensorSystem.deploySensor(sensor1, location1);

            // Let's try to deploy a deployed sensor at a new unique location
            Location location2 = new Location("5678 Fake Street", "D4E5F6", "QC", "Canada", "87.345, -13.678");
            SensorSystem.deploySensor(sensor1, location2);

            // Tests that if we try to read a temperature from a location that doesn't exist, it throws an error
            SensorSystem.readTemperature(null);
        }

        // Creation of multiple sensors
        Sensor sensor3 = new Sensor();
        Sensor sensor4 = new Sensor();
        Sensor sensor5 = new Sensor();

        // Create multiple locations
        Location location3 = new Location("1234 Elm Street", "A1B2C3", "ON", "Canada", "45.678, -78.910");
        Location location4 = new Location("4321 Maple Avenue", "X9Y8Z7", "BC", "Canada", "56.789, -89.012");
        Location location5 = new Location("2345 Birch Drive", "R4S5T6", "AB", "Canada", "67.890, -90.123");

        // Deploy the sensors at the locations
        SensorSystem.deploySensor(sensor3, location3);
        SensorSystem.deploySensor(sensor4, location4);
        SensorSystem.deploySensor(sensor5, location5);

        // Print the value of the sensor ID and deployment status
        System.out.println("Sensor 3 has been deployed with the ID: " + sensor3.getID() + " and deployed value is: " + sensor3.getIsDeployed());
        System.out.println("Sensor 4 has been deployed with the ID: " + sensor4.getID() + " and deployed value is: " + sensor4.getIsDeployed());
        System.out.println("Sensor 5 has been deployed with the ID: " + sensor5.getID() + " and deployed value is: " + sensor5.getIsDeployed());

        // Print the values of the temperature of the sensors
        System.out.println("Sensor 3 has a temperature of: " + SensorSystem.readTemperature(location3));
        System.out.println("Sensor 4 has a temperature of: " + SensorSystem.readTemperature(location4));
        System.out.println("Sensor 5 has a temperature of: " + SensorSystem.readTemperature(location5));

        // Print the number of sensors in the registry
        System.out.println("The number of sensors in the registry is: " + SensorRegistry.getNbOfSensors());

        // Print the number of sensor location pairings
        System.out.println("The number of sensor location pairings is: " + SensorLocationPairings.getNbOfSensorLocationPairings());

        // Print the number of sensor temperature pairings
        System.out.println("The number of sensor temperature pairings is: " + SensorTemperaturePairings.getNbOfSensorTemperaturePairings());
    }
}
